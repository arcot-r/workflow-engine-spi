// CamundaWorkflowEngineImpl.java
package com.finastra.tx.workflow.camunda;

import org.springframework.stereotype.Service;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;

@Service("camunda")
public class CamundaWorkflowEngine implements WorkflowEngine {
    // Implement methods of the WorkflowEngine interface here
    
    @Override
    public void startWorkflow(String workflowId) {
        // Implementation specific to Camunda workflow engine
        System.out.println("Starting workflow with Flowable: " + workflowId);
    }

    @Override
    public void executeTask(String taskId) {
        // Implementation specific to Camunda workflow engine
        System.out.println("Executing task with Flowable: " + taskId);
    }
	@Override
	public String getMessage() {
		return "Camunda Called";
	}
}
