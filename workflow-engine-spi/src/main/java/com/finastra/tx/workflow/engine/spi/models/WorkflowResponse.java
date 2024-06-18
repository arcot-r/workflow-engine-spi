package com.finastra.tx.workflow.engine.spi.models;

import com.finastra.tx.workflow.engine.spi.enums.TaskStatus;
import com.finastra.tx.workflow.engine.spi.enums.TaskType;
import com.finastra.tx.workflow.engine.spi.enums.WorkflowStatus;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkflowResponse {
  String message;
  Long correlationId;
  String processInstanceId;
  String taskId;
  TaskStatus taskStatus;
  TaskType taskType;
  WorkflowStatus workflowStatus;
  Map<String, Object> processVariables;
  Map<String, Object> taskVariables;
}
