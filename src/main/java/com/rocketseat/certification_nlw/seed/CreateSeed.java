package com.rocketseat.certification_nlw.seed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {
  private final JdbcTemplate jdbcTemplate;

  public CreateSeed(DataSource datasource) {
    this.jdbcTemplate = new JdbcTemplate(datasource);
  }

  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
    dataSource.setUsername("admin");
    dataSource.setPassword("admin");

    CreateSeed createSeed = new CreateSeed(dataSource);
    createSeed.run(args)
  }

  public void run(String... args) {
    executeSqlFile("src/main/resources/create.sql");
  }

  private void executeSqlFile(String filePath) {
    try {
      String sql = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      // TODO: handle exception
    }
  }
}
