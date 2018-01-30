package org.gesis.dcterms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;

import org.gesis.discovery.DataFile;
import org.gesis.discovery.LogicalDataSet;
import org.gesis.discovery.Study;
import org.gesis.rdfs.Resource;

/**
 * {@link Study}, {@link LogicalDataSet}s, and {@link DataFile}s may have a
 * spatial, temporal, and topical coverage. There is no dedicated coverage type
 * in DDI-RDF. The comprehensive description by spatial, temporal, and topical
 * coverage is directly attached to the respective study, logical dataset, and
 * datafile (using DCMI terms).
 * 
 * <p>
 * Disco could be used to discover datasets by searching for specific questions,
 * topics, and geographical coverage. For spatial coverage, dcterms:spatial is
 * used, pointing to any geographic location.
 * </p>
 * <p>
 * Please note that these properties are a feature at risk, since the domain is
 * not Disco. Maintainers of the domain ontology may introduce their own
 * properties for this purpose.
 * </p>
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#coverage-of-studies-logical-datasets-and-data-files}
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Location extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@Column
	@Lob
	private String label;

	// getter/setter

	/**
	 * Corresponds to rdfs:label.
	 * 
	 * @return The label of this Location.
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * Corresponds to rdfs:label. Sets the label for this Location.
	 * 
	 * @param label
	 * @return This Location object.
	 * @see {@link getLabel()}
	 */
	public Location setLabel( final String label )
	{
		this.label = label;
		return this;
	}

}
