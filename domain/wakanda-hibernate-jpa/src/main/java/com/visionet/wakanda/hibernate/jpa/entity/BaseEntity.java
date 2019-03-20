/*
 * Copyright (c) 2019. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author pangcaijie
 * @since 2019/3/15.
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity<T> {

	@Id
	@GenericGenerator(name = "sys_uuid", strategy = "guid")
	@GeneratedValue(generator = "sys_uuid")
	private T id;

	@CreatedBy
	@Column(updatable = false)
	private String createdBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createdDate;

	@LastModifiedBy
	private String updatedBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Version
	private Integer version;

	private Boolean isDeleted = false;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}
}
