// ActivitiWorkflowEngineImpl.java
package com.finastra.tx.workflow.activiti;

import org.springframework.stereotype.Service;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;
@Service("activiti")
public class ActivitiWorkflowEngine implements WorkflowEngine {
    // Implement methods of the WorkflowEngine interface here
    
    @Override
    public void startWorkflow(String workflowId) {
        // Implementation specific to Activiti workflow engine
        System.out.println("Starting workflow with Flowable: " + workflowId);
    }

    @Override
    public void executeTask(String taskId) {
        // Implementation specific to Activiti workflow engine
        System.out.println("Executing task with Flowable: " + taskId);
    }

	@Override
	public String getMessage() {
		return "Activiti Called";
	}

    // Additional methods specific to ActivitiWorkflowEngine can be added here
}
