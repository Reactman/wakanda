/*
 * Copyright (c) 2019. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.service.impl;

import com.visionet.wakanda.hibernate.jpa.entity.BaseEntity;
import com.visionet.wakanda.hibernate.jpa.repository.BaseRepository;
import com.visionet.wakanda.hibernate.jpa.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author pangcaijie
 * @since 2019/3/19.
 */
public class AbstractBaseService<M extends BaseEntity, ID> implements BaseService<M, ID> {

	private BaseRepository<M, ID> customizeRepository;

	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<M, ID> baseRepository) {
		this.customizeRepository = baseRepository;
	}

	public BaseRepository<M, ID> getCustomizeRepository() {
		return customizeRepository;
	}

	@Override
	public M save(M entity) {
		return this.customizeRepository.save(entity);
	}

	@Override
	public boolean exist(ID id) {
		return this.customizeRepository.existsById(id);
	}

	@Override
	public void delete(M m) {
		this.customizeRepository.delete(m);
	}

	@Override
	public void delete(ID id) {
		this.customizeRepository.deleteById(id);
	}

	@Override
	public M findOne(ID id) {
		return this.customizeRepository.getOne(id);
	}

	@Override
	public List<M> findAll() {
		return this.customizeRepository.findAll();
	}

	@Override
	public List<M> findAll(Sort sort) {
		return this.customizeRepository.findAll(sort);
	}

	@Override
	public long count() {
		return this.customizeRepository.count();
	}
}
