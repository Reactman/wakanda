/*
 * Copyright (c) 2019. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.config;

import com.visionet.wakanda.hibernate.jpa.repository.SimpleBaseRepositoryFactoryBean;
import com.visionet.wakanda.hibernate.jpa.support.DefaultAuditorAware;
import com.visionet.wakanda.hibernate.jpa.support.HibernateConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author pangcaijie
 * @since 2019/3/15.
 */
@EntityScan("com.visionet.**.entity")
@EnableJpaRepositories(
		basePackages = "com.visionet",
		repositoryFactoryBeanClass= SimpleBaseRepositoryFactoryBean.class)
public class HibernateConfiguration implements EnvironmentAware {

	private Environment environment;

	private Logger logger = LoggerFactory.getLogger(HibernateConfiguration.class);

	@Bean
	public AuditorAware auditorAware() {
		String customizeAuditorAware = environment.getProperty("wakanda.jpa.auditorAware");
		if (customizeAuditorAware == null || customizeAuditorAware.length() <= 0) {
			return new DefaultAuditorAware();
		} else {
			try {
				Class<?> cls = Class.forName(customizeAuditorAware);
				return (AuditorAware) cls.newInstance();
			} catch (Exception e) {
				logger.error("Could not customize AuditorAware instance, cause:", e);
				throw new HibernateConfigException();
			}
		}

	}

	@Override
	public void setEnvironment(Environment environment) {
        this.environment = environment;
	}
}
