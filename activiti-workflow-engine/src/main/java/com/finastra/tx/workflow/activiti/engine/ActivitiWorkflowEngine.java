// ActivitiWorkflowEngineImpl.java
package com.finastra.tx.workflow.activiti.engine;

import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskAdminRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.finastra.tx.workflow.activiti.config.SecurityUtil;
import com.finastra.tx.workflow.engine.spi.WorkflowEngine;
@Service("activiti")
public class ActivitiWorkflowEngine implements WorkflowEngine {
	Logger log = LoggerFactory.getLogger(ActivitiWorkflowEngine.class);
	@Autowired ProcessRuntime processRuntime;
	@Autowired TaskRuntime taskRuntime;
	@Autowired TaskAdminRuntime taskAdminRuntime;
	@Autowired RepositoryService repositoryService;
	@Autowired SecurityUtil securityUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public void startWorkflow(String workflowId) {
        // Implementation specific to Activiti workflow engine
        System.out.println("Starting workflow with Flowable: " + workflowId);
    }

    @Override
    public void executeTask(String taskId) {
        // Implementation specific to Activiti workflow engine
        System.out.println("Executing task with Flowable: " + taskId);
    }

	@Override
	public String getMessage() {
		securityUtil.logInAs("reviewer");
		log.info("Logged in as reviewer" );
		return "Activiti Called";
	}

    // Additional methods specific to ActivitiWorkflowEngine can be added here
}
