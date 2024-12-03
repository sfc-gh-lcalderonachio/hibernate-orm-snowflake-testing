/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package net.snowflake.hibernate.dialect;

class VersionParsingException extends RuntimeException {
public VersionParsingException(String rawVersion, Exception cause) {
	super("Version " + rawVersion + "does not follow {major}.{minor}.{patch} format", cause);
}

public VersionParsingException(String rawVersion) {
	this(rawVersion, null);
}
}
