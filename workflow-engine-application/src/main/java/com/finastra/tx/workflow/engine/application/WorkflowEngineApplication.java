package com.finastra.tx.workflow.engine.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;

@SpringBootApplication
@ComponentScan(basePackages = {"com.finastra.tx.workflow"})
public class WorkflowEngineApplication {
	
	@Autowired
	private WorkflowEngine workflowEngine;

  public static void main(String[] args) {
    SpringApplication.run(WorkflowEngineApplication.class, args);
  }
}
