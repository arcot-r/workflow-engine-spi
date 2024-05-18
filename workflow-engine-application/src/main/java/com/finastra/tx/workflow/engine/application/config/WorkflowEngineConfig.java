package com.finastra.tx.workflow.engine.application.config;

import java.util.ServiceLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.finastra.tx.workflow.engine.spi.WorkflowEngine;

@Configuration
public class WorkflowEngineConfig {

	@Bean
	WorkflowEngine workflowEngine(Environment env) {
		String activeEngine = env.getProperty("active.workflow.engine");
		ServiceLoader<WorkflowEngine> serviceLoader = ServiceLoader.load(WorkflowEngine.class);

		for (WorkflowEngine engine : serviceLoader) {
			if (engine.getClass().getSimpleName().toLowerCase().contains(activeEngine)) {
				return engine;
			}
		}

		throw new IllegalStateException("No matching workflow engine found for: " + activeEngine);
	}
}