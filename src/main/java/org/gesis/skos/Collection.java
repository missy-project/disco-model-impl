package org.gesis.skos;

import javax.persistence.MappedSuperclass;

import org.gesis.rdfs.Resource;

/**
 * A collection of Resources.
 * 
 * @author matthaeus
 * @see org.gesis.rdfs.Resource
 */
@MappedSuperclass
public interface Collection extends java.util.Collection<Resource>
{

}
