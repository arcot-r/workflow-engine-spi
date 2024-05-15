package com.finastra.tx.workflow.engine.application.config;
import java.util.ServiceLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;

@Configuration
public class WorkflowEngineConfiguration {

    @Bean
    ServiceLoader<WorkflowEngine> workflowEngineLoader() {
        return ServiceLoader.load(WorkflowEngine.class);
    }
}
