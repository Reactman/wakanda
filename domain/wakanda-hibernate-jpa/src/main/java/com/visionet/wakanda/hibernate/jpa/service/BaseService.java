/*
 * Copyright (c) 2019. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.service;

import com.visionet.wakanda.hibernate.jpa.entity.BaseEntity;
import com.visionet.wakanda.hibernate.jpa.repository.BaseRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author pangcaijie
 * @since 2019/3/16.
 */
public interface BaseService <M extends BaseEntity, ID> {

	public abstract void setBaseRepository(BaseRepository<M, ID> baseRepository);

	/**
	 * 保存单个实体
	 * @param m 实体
	 * @return 保存成功的实体 m
	 */
	public abstract M save(M m);

	/**
	 * 根据主键判断实体是否存在
	 * @param id
	 * @return Boolean
	 */
	public abstract boolean exist(ID id);

	/**
	 * 根据主键删除实体
	 * @param id 主键
	 */
	public abstract void delete(ID id);

	/**
	 * 根据实体删除对应实体
	 * @param m
	 */
	public abstract void delete(M m);

	/**
	 * 根据主键查询实体
	 * @param id
	 * @return id对应的实体
	 */
	public abstract M findOne(ID id);

	/**
	 * 查询所有实体
	 * @return List<M> 所有实体集合
	 */
	public abstract List<M> findAll();

	/**
	 * 按照顺序查询所有实体
	 * @param sort
	 * @return List<M>
	 */
	public abstract List<M> findAll(Sort sort);

	/**
	 * 按条件分页查询实体
	 * @param Searchable 查询条件
	 * @return Page
	 */
//	public abstract Page findAllForPage(Searchable searchable);

	/**
	 * 按条件查询实体
	 * @param searchable 条件
	 * @return List<M>
	 */
//	public abstract List<?> findAll(Searchable searchable);

	/**
	 * 查询所有实体数量
	 * @return longs
	 */
	public abstract long count();

	/**
	 * 按条件统计实体数量
	 * @param searchable 条件
	 * @return long
	 */
//	public abstract long count(Searchable searchable);
}
