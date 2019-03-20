/*
 * Copyright (c) 2015. Visionet and/or its affiliates. All right reserved.
 * VISIONET PROPRIETARY/CONFIDENTIAL.
 */
package com.visionet.wakanda.hibernate.jpa.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalStandardNamingStrategy implements PhysicalNamingStrategy {
	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return null;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return null;
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return null;
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return null;
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return null;
	}
}
