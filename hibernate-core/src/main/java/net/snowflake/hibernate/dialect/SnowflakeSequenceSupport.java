/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package net.snowflake.hibernate.dialect;

import org.hibernate.MappingException;
import org.hibernate.dialect.sequence.SequenceSupport;

class SnowflakeSequenceSupport implements SequenceSupport {

@Override
public boolean supportsSequences() {
	return SequenceSupport.super.supportsSequences();
}

@Override
public String getSelectSequenceNextValString(String sequenceName) {
	return sequenceName + ".nextval";
}

@Override
public String getSelectSequencePreviousValString(String sequenceName) throws MappingException {
	// https://docs.snowflake.com/en/user-guide/querying-sequences#currval-not-supported
	throw new UnsupportedOperationException(
		"Getting previous value from sequence is not available");
}

@Override
public String getDropSequenceString(String sequenceName) {
	return "drop sequence if exists " + sequenceName;
}
}
