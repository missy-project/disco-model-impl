package org.gesis.persistence;

/**
 * The base-interface for all persistable Resources.
 *
 * @author matthaeus
 *
 */
public interface IPersistableResource
{

	/**
	 * Returns the physical relevant identifier for this instance.
	 *
	 * @return
	 */
	public abstract String getId();

	/**
	 * Returns the functional relevant identifier for this instance.
	 *
	 * @return
	 */
	public abstract String getURN();

}