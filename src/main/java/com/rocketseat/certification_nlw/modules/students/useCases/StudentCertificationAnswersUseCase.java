package com.rocketseat.certification_nlw.modules.students.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.questions.entities.QuestionEntity;
import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.entities.AnswersCertificationsEntity;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.rocketseat.certification_nlw.modules.students.entities.StudentEntity;
import com.rocketseat.certification_nlw.modules.students.repositories.CertificationStudentRepository;
import com.rocketseat.certification_nlw.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {
  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private QuestionsRepository questionRepository;

  @Autowired
  private CertificationStudentRepository certificationStudentRepository;

  public CertificationStudentEntity execute(StudentCertificationAnswerDTO dto) {
    // Buscar alternativas das perguntas
    // Para saber se é a corretas
    List<QuestionEntity> questionsEntitiy = questionRepository.findByTechnology(dto.getTechnology());
    List<AnswersCertificationsEntity> answersCertifications = new ArrayList<>();

    dto.getQuestionsAnswers()
        .stream().forEach(questionAnswer -> {
          var question = questionsEntitiy.stream()
              .filter(q -> q.getId().equals(questionAnswer.getQuestionID()))
              .findFirst().get();

          var findCorrectAlternative = question.getAlternatives().stream()
              .filter(alternative -> alternative.isCorrect()).findFirst().get();

          if (findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())) {
            questionAnswer.setCorrect(true);
          } else {
            questionAnswer.setCorrect(false);
          }
          var answersCertificationsEntity = AnswersCertificationsEntity.builder()
              .answerID(questionAnswer.getAlternativeID())
              .questionID(questionAnswer.getQuestionID())
              .isCorrect(questionAnswer.isCorrect()).build();

          answersCertifications.add(answersCertificationsEntity);
        });
    // Verificar se existe o estudante pelo email
    var student = studentRepository.findByEmail(dto.getEmail());
    UUID studentID;
    if (student.isEmpty()) {
      var studentCreated = StudentEntity.builder().email(dto.getEmail()).build();
      studentCreated = studentRepository.save(studentCreated);
      studentID = studentCreated.getId();
    } else {
      studentID = student.get().getId();
    }

    CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
        .technology(dto.getTechnology())
        .studentID(studentID)
        .build();

    // Salvar as informaçoes da certificação
    var certificationStudentCreated = certificationStudentRepository.save(certificationStudentEntity);
    answersCertifications.stream().forEach(answerCertifications -> {
      answerCertifications.setCertificationID(certificationStudentEntity.getId());
      answerCertifications.setCertificationStudentEntity(certificationStudentEntity);
    });
    certificationStudentEntity.setAnswersCertificationEntity(answersCertifications);
    certificationStudentRepository.save(certificationStudentEntity);
    return certificationStudentCreated;
  }
}
