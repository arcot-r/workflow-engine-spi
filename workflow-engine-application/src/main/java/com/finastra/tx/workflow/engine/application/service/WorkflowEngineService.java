package com.finastra.tx.workflow.engine.application.service;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;
import com.finastra.tx.workflow.engine.spi.models.WorkflowRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowResponse;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadResponse;
import org.springframework.stereotype.Service;

@Service
public class WorkflowEngineService {
  private final WorkflowEngine workflowEngine;

  public WorkflowEngineService(WorkflowEngine workflowEngine) {
    this.workflowEngine = workflowEngine;
  }

  public String getWelcomeMessage() {
    return workflowEngine.getMessage();
  }

  public WorkflowResponse startProcess(WorkflowRequest request) {
    return workflowEngine.startProcess(request);
  }

  public WorkflowResponse endProcess(WorkflowRequest request) {
    return workflowEngine.endProcess(request);
  }

  public WorkflowResponse completeTask(WorkflowRequest request) {
    return workflowEngine.completeTask(request);
  }

  public WorkflowResponse getAllTasks(WorkflowRequest request) {
    return workflowEngine.getAllTasks(request);
  }

  public WorkflowResponse getTasksByUser(WorkflowRequest request) {
    return workflowEngine.getTasksByUser(request);
  }

  public WorkflowResponse getProcessInstanceMeta(WorkflowRequest request) {
    return workflowEngine.getProcessInstanceMeta(request);
  }

  public WorkflowResponse listAllProcessVariables(WorkflowRequest request) {
    return workflowEngine.listAllProcessVariables(request);
  }

  public WorkflowResponse listAllTaskVariables(WorkflowRequest request) {
    return workflowEngine.listAllTaskVariables(request);
  }

  public WorkflowUploadResponse uploadDefinition(WorkflowUploadRequest request) {
    return workflowEngine.uploadDefinition(request);
  }
}
