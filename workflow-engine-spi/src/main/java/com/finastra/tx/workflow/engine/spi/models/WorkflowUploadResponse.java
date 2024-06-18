package com.finastra.tx.workflow.engine.spi.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkflowUploadResponse {
  String processDefinitionKey;
  String message;
  String code;
}
