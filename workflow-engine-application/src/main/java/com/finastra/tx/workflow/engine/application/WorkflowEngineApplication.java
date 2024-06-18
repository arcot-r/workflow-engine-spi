package com.finastra.tx.workflow.engine.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.finastra.tx.workflow"})
public class WorkflowEngineApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkflowEngineApplication.class, args);
  }
}
