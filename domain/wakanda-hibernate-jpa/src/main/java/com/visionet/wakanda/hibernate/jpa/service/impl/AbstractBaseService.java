/*
 * Copyright (c) 2019. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.service.impl;

import com.visionet.wakanda.hibernate.jpa.entity.BaseEntity;
import com.visionet.wakanda.hibernate.jpa.repository.BaseRepository;
import com.visionet.wakanda.hibernate.jpa.service.BaseService;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author pangcaijie
 * @since 2019/3/19.
 */
public class AbstractBaseService<M extends BaseEntity, ID> implements BaseService<M, ID> {

	private BaseRepository<M, ID> customizeRepository;

	@Override
	public void setBaseRepository(BaseRepository<M, ID> baseRepository) {
		this.customizeRepository = baseRepository;
	}

	public BaseRepository<M, ID> getCustomizeRepository() {
		return customizeRepository;
	}

	@Override
	public M save(BaseEntity baseEntity) {
		return null;
	}

	@Override
	public boolean exist(Object o) {
		return false;
	}

	@Override
	public void delete(Object o) {

	}

	@Override
	public void delete(BaseEntity baseEntity) {

	}

	@Override
	public M findOne(Object o) {
		return null;
	}

	@Override
	public List findAll() {
		return null;
	}

	@Override
	public List findAll(Sort sort) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}
}
