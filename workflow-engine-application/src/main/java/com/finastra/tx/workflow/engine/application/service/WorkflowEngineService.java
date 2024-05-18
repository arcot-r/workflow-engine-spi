package com.finastra.tx.workflow.engine.application.service;

import org.springframework.stereotype.Service;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;

@Service
public class WorkflowEngineService {
	private final WorkflowEngine workflowEngine;
	
    public WorkflowEngineService(WorkflowEngine workflowEngine) {
        this.workflowEngine = workflowEngine;
    }

    public String executeWorkflow() {
        return workflowEngine.getMessage();
    }
}
