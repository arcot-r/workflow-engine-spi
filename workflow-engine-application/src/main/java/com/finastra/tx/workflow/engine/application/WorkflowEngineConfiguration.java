package com.finastra.tx.workflow.engine.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;


@Configuration
public class WorkflowEngineConfiguration {
    @Value("${workflow.engine}")
    private String workflowEngineType;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public WorkflowEngine workflowEngine() {
    	
        return applicationContext.getBean(getWorkflowEngineBeanName(), WorkflowEngine.class);
    }

    private String getWorkflowEngineBeanName() {
        switch (workflowEngineType.toLowerCase()) {
//            case "activiti":
//                return "activitiWorkflowEngine";
            case "camunda":
                return "camundaWorkflowEngine";
            case "flowable":
                return "flowableWorkflowEngine";
            default:
                throw new IllegalArgumentException("Unknown workflow engine type: " + workflowEngineType);
        }
    }
}
