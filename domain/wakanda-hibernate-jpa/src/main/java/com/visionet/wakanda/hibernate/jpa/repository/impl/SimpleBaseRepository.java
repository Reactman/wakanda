/*
 * Copyright (c) 2019. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.repository.impl;

import com.visionet.wakanda.hibernate.jpa.entity.BaseEntity;
import com.visionet.wakanda.hibernate.jpa.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * @author pangcaijie
 * @since 2019/3/16.
 */
public class SimpleBaseRepository<M extends BaseEntity, T> extends SimpleJpaRepository implements BaseRepository {

	private final EntityManager em;

	private final JpaEntityInformation<M, String> entityInformation;

	private Class<M> entityClass;

	public SimpleBaseRepository(JpaEntityInformation entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
		this.entityInformation = entityInformation;
	}
}
