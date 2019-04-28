/*
 * Copyright (c) 2019. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.support;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * JPA 默认操作监听
 * @author pangcaijie
 * @since 2019/3/15.
 */
public class DefaultAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("system");
	}
}
