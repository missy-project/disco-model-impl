package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.rdfs.Resource;

/**
 * Defines the provenance information, for instance, for the data file.
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#other-general-dublin-core-metadata-properties">Definition:
 *      Other general dublin core metadata properties</a>
 * @see org.gesis.discovery.DataFile
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
