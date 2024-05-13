package com.finastra.tx.workflow.engine.spi;

public interface WorkflowEngine {
	String getMessage();
	void startWorkflow(String workflowId);

	void executeTask(String taskId);

}
