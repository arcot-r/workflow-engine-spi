package com.finastra.tx.workflow.activiti.connectors;

import org.activiti.api.process.model.IntegrationContext;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.process.runtime.connector.Connector;
import org.activiti.api.task.runtime.TaskRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "serviceTaskConnector")
public class ServiceTaskConnector implements Connector {
  Logger log = LoggerFactory.getLogger(ServiceTaskConnector.class);
  @Autowired ProcessRuntime processRuntime;
  @Autowired TaskRuntime taskRuntime;

  @Override
  public IntegrationContext apply(IntegrationContext t) {
    log.info(
        "Service Task [processInstanceId={}],[taskId={}] ",
        t.getProcessInstanceId(),
        t.getExecutionId());
    var inboundVariableMap = t.getInBoundVariables();
    t.addOutBoundVariables(inboundVariableMap);
    log.info("Service Task is completed....");
    return t;
  }
}
