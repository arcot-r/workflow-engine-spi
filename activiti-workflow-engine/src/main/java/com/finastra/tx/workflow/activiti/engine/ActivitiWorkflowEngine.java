// ActivitiWorkflowEngineImpl.java
package com.finastra.tx.workflow.activiti.engine;

import com.finastra.tx.workflow.activiti.config.SecurityUtil;
import com.finastra.tx.workflow.engine.spi.WorkflowEngine;
import com.finastra.tx.workflow.engine.spi.models.WorkflowRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowResponse;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadResponse;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskAdminRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activiti")
@Slf4j
public class ActivitiWorkflowEngine implements WorkflowEngine {
  @Autowired ProcessRuntime processRuntime;
  @Autowired TaskRuntime taskRuntime;
  @Autowired TaskAdminRuntime taskAdminRuntime;
  @Autowired RepositoryService repositoryService;
  @Autowired SecurityUtil securityUtil;

  @Override
  public String getMessage() {
    return "<<<<<<<<<<<<Welcome to Activiti Workflow Engine>>>>>>>>>>>";
  }

  @Override
  public WorkflowResponse startProcess(WorkflowRequest request) {
    var variableMap = request.getProcessVariables();
    ProcessInstance processInstance =
        processRuntime.start(
            ProcessPayloadBuilder.start()
                .withProcessDefinitionKey(request.getProcessDefinitionKey())
                .withName(request.getProcessName())
                .withVariables(variableMap)
                .build());
    log.info(">>> Created Process Instance: " + processInstance);

    return WorkflowResponse.builder().message("Workflow Started Successfully").build();
  }

  @Override
  public WorkflowResponse endProcess(WorkflowRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WorkflowResponse completeTask(WorkflowRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WorkflowResponse getAllTasks(WorkflowRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WorkflowResponse getTasksByUser(WorkflowRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WorkflowResponse getProcessInstanceMeta(WorkflowRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WorkflowUploadResponse uploadDefinition(WorkflowUploadRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WorkflowResponse listAllProcessVariables(WorkflowRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WorkflowResponse listAllTaskVariables(WorkflowRequest request) {
    // TODO Auto-generated method stub
    return null;
  }
}
