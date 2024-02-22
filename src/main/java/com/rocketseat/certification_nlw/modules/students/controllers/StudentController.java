package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.rocketseat.certification_nlw.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.rocketseat.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {
  // Chamar o usecase
  @Autowired
  private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

  @Autowired
  private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

  @PostMapping("/verifyIfHasCertification")
  public String verifyIfHasCerfitication(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
    // Email
    // Technology
    var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
    if (result) {
      return "Usuário já fez a prova";
    }
    return "Usuário pode fazer a prova";
  }

  @PostMapping("/certification/answer")
  public ResponseEntity<Object> certificationAnswer(
      @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) throws Exception {
    try {
      var result = this.studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      // é similar à escrever: responseEntity.status(400)
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}// ok
