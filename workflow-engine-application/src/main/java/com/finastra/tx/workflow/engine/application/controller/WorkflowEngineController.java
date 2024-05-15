package com.finastra.tx.workflow.engine.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;

@RestController
@RequestMapping("/generic-workflow")
public class WorkflowEngineController {
	Logger log = LoggerFactory.getLogger(WorkflowEngineController.class);
	@Value("${active.workflow.engine}")
	private String activeWorkflowEngine;
	
	@Autowired
	private Environment environment;
	
//    @Autowired
//	private WorkflowEngine engine;
	
	@GetMapping
	public String getMessage() {
		log.info("active workflow engine:{}",environment.getActiveProfiles()[0]);
		log.info("active workflow engine:{}",activeWorkflowEngine);
//		log.info("message from workflow:{}",engine.getMessage());
		
		return "Workflow Engine message "+activeWorkflowEngine;
		
	}
	
	

}
