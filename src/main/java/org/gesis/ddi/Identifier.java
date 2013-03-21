package org.gesis.ddi;

public interface Identifier {

	public abstract String getURN();

	public abstract String getAgencyId();

	public abstract String getObjectId();

	public abstract String getMajorVersion();

	public abstract String getMinorVersion();

}