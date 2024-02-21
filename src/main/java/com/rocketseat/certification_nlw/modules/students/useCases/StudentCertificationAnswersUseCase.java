package com.rocketseat.certification_nlw.modules.students.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.questions.entities.QuestionEntity;
import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {
  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private QuestionRepository questionRepository;

  public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO dto) {
    // Buscar alternativas das perguntas
    // Para saber se é a corretas
    List<QuestionEntity> questionsEntitiy = questionRepository.findByTechnology(dto.getTechnology());
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
        });
    return dto;
    // Salvar as informaçoes da certificação
  }
}
