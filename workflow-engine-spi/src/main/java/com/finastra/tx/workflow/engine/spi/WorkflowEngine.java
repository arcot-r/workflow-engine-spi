package com.finastra.tx.workflow.engine.spi;

import com.finastra.tx.workflow.engine.spi.models.WorkflowRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowResponse;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadResponse;

public interface WorkflowEngine {
  String getMessage();

  WorkflowResponse startProcess(WorkflowRequest request);

  WorkflowResponse endProcess(WorkflowRequest request);

  WorkflowResponse completeTask(WorkflowRequest request);

  WorkflowResponse getAllTasks(WorkflowRequest request);

  WorkflowResponse getTasksByUser(WorkflowRequest request);

  WorkflowResponse getProcessInstanceMeta(WorkflowRequest request);

  WorkflowResponse listAllProcessVariables(WorkflowRequest request);

  WorkflowResponse listAllTaskVariables(WorkflowRequest request);

  WorkflowUploadResponse uploadDefinition(WorkflowUploadRequest request);
}
