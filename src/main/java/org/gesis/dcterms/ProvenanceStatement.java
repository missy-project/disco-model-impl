package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.discovery.DataFile;
import org.gesis.rdfs.Resource;

/**
 * Defines the provenance information, for instance, for the data file.
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#other-general-dublin-core-metadata-properties}
 * @see {@link DataFile}
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class ProvenanceStatement extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
