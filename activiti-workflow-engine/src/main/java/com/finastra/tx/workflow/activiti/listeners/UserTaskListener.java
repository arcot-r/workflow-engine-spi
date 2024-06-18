package com.finastra.tx.workflow.activiti.listeners;

import org.activiti.api.task.runtime.events.TaskCreatedEvent;
import org.activiti.api.task.runtime.events.listener.TaskRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userTaskListener")
public class UserTaskListener implements TaskRuntimeEventListener<TaskCreatedEvent> {
  Logger log = LoggerFactory.getLogger(UserTaskListener.class);

  @Override
  public void onEvent(TaskCreatedEvent event) {
    log.info(
        "Processing the user tasks for the event: {} of type:{}",
        event.getEntity().getId(),
        event.getEventType());
    var task = event.getEntity();
    log.info("User Task [{}] is completed", task);
  }
}
