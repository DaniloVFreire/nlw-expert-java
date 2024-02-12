package com.rocketseat.certification_nlw;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {
  @GetMapping("/retornarPrimeiraController")
  public Usuario retornoPrimeiraController() {
    var usuario = new Usuario("danilo", 22);
    return usuario;
  }

  @PostMapping("/meuPrimeiroPost")
  public String PrimeiroPost() {
    return "Meu primeiro post";
  }

  record Usuario(String nome, int idade) {
  }
}
