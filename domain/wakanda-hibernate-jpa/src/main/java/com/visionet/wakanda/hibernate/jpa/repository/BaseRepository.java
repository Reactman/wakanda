package com.visionet.wakanda.hibernate.jpa.repository;

import com.visionet.wakanda.hibernate.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author TC.Ubuntu
 * @DESCRIPTION ${DESCRIPTION}
 * @since 2019/3/15.
 */
@NoRepositoryBean
public interface BaseRepository<M extends BaseEntity, T> extends JpaRepository<M, T> {

}
