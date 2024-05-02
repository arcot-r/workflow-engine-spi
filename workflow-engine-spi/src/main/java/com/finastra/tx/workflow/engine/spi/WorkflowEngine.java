// WorkflowEngine.java
package com.finastra.tx.workflow.engine.spi;

public interface WorkflowEngine {
    void startWorkflow(String workflowId);

    void executeTask(String taskId);

    // Add other methods related to workflow management as needed

}
