package com.finastra.tx.workflow.engine.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finastra.tx.workflow.engine.application.service.WorkflowEngineService;

@RestController
@RequestMapping("/generic-workflow")
public class WorkflowEngineController {
	Logger log = LoggerFactory.getLogger(WorkflowEngineController.class);
	@Value("${active.workflow.engine}")
	private String activeWorkflowEngine;

	@Autowired
	WorkflowEngineService service;

	@GetMapping
	public String execute() {
		log.info("active workflow engine:{}", activeWorkflowEngine);
		log.info("message from workflow:{}", service.executeWorkflow());

		return "Workflow Engine message " + activeWorkflowEngine;

	}

}
