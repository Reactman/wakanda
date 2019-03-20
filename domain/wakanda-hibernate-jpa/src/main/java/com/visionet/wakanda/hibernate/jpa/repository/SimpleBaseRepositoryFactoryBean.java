/**
 * Copyright (c) 2016. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.repository;

import com.visionet.wakanda.hibernate.jpa.entity.BaseEntity;
import com.visionet.wakanda.hibernate.jpa.repository.impl.SimpleBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class SimpleBaseRepositoryFactoryBean<R extends JpaRepository<M, ID>, M extends BaseEntity, ID>
		extends JpaRepositoryFactoryBean<R, M, ID> {

	/**
	 * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
	 *
	 * @param repositoryInterface must not be {@literal null}.
	 */
	public SimpleBaseRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
	}

	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new SimpleBaseRepositoryFactory<M, ID>(entityManager);
	}

	class SimpleBaseRepositoryFactory<M extends BaseEntity, T> extends JpaRepositoryFactory {
		private EntityManager entityManager;

		private SimpleBaseRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		@SuppressWarnings({"unchecked"})
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			JpaEntityInformation<M, T> entityInformation = getEntityInformation((Class<M>) metadata.getDomainType());
			return new SimpleBaseRepository<M, T>(entityInformation, entityManager);
		}

		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return SimpleBaseRepository.class;
		}
	}

}
