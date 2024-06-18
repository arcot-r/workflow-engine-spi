package com.finastra.tx.workflow.engine.application.controller;

import com.finastra.tx.workflow.engine.application.service.WorkflowEngineService;
import com.finastra.tx.workflow.engine.spi.models.WorkflowRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowResponse;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadRequest;
import com.finastra.tx.workflow.engine.spi.models.WorkflowUploadResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generic-workflow")
public class WorkflowEngineController {
  Logger log = LoggerFactory.getLogger(WorkflowEngineController.class);

  @Value("${active.workflow.engine}")
  private String activeWorkflowEngine;

  @Autowired WorkflowEngineService service;

  @GetMapping
  public String welcome() {
    log.info("active workflow engine:{}", activeWorkflowEngine);
    log.info("message from workflow:{}", service.getWelcomeMessage());
    return "Workflow Engine message " + activeWorkflowEngine;
  }

  @PostMapping("/start-process")
  public ResponseEntity<WorkflowResponse> startProcess(@RequestBody WorkflowRequest request) {
    var response = service.startProcess(request);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.CREATED);
  }

  @DeleteMapping("/end-process/{taskId}")
  public ResponseEntity<WorkflowResponse> endProcess(@PathVariable String processInstanceId) {
    var req = WorkflowRequest.builder().processInstanceId(processInstanceId).build();
    var response = service.endProcess(req);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/complete-task/{taskId}")
  public ResponseEntity<WorkflowResponse> completeTask(@PathVariable String taskId) {
    var req = WorkflowRequest.builder().taskId(taskId).build();
    var response = service.endProcess(req);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.ACCEPTED);
  }

  @GetMapping("/get-tasks")
  public ResponseEntity<WorkflowResponse> getAllTasks(@RequestParam String processInstanceId) {
    var request = WorkflowRequest.builder().processInstanceId(processInstanceId).build();
    var response = service.getAllTasks(request);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.OK);
  }

  @GetMapping("/get-task")
  public ResponseEntity<WorkflowResponse> getTasksByUser(@RequestParam String userRole) {
    var request = WorkflowRequest.builder().userRole(userRole).build();
    var response = service.completeTask(request);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.OK);
  }

  @GetMapping("/get-process-meta")
  public ResponseEntity<WorkflowResponse> getProcessInstanceMeta(
      @RequestParam String processInstanceId) {
    var request = WorkflowRequest.builder().processInstanceId(processInstanceId).build();
    var response = service.getProcessInstanceMeta(request);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.OK);
  }

  @GetMapping("/get-process-variables")
  public ResponseEntity<WorkflowResponse> listAllProcessVariables(
      @RequestParam String processInstanceId) {
    var request = WorkflowRequest.builder().processInstanceId(processInstanceId).build();
    var response = service.listAllProcessVariables(request);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.OK);
  }

  @GetMapping("/get-task-variables")
  public ResponseEntity<WorkflowResponse> listAllTaskVariables(
      @RequestParam String processInstanceId, @RequestParam String taskd) {
    var request =
        WorkflowRequest.builder().processInstanceId(processInstanceId).taskId(taskd).build();
    var response = service.listAllTaskVariables(request);
    return new ResponseEntity<WorkflowResponse>(response, HttpStatus.OK);
  }

  @PostMapping("/upload-definition")
  public ResponseEntity<WorkflowUploadResponse> uploadDefinition(
      @RequestBody WorkflowUploadRequest request) {
    var response = service.uploadDefinition(request);
    return new ResponseEntity<WorkflowUploadResponse>(response, HttpStatus.OK);
  }
}
