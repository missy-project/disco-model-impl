package org.gesis.discovery;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.rdfs.Resource;

/**
 * The Representation of a variable is the combination of a value domain,
 * datatype, and, if necessary, a unit of measure or a character set.
 * Representation is one of a set of values to which a numerical measure or a
 * category from a classification can be assigned (e.g. income, age, and sex:
 * male coded as 1). Questions (ResponseDomain), variables (Variable)
 * (Representation), and variable definitions (RepresentedVariable)
 * (Representation) may have representations.
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#representation">Definition:
 *      Representation</a>
 * @see org.gesis.skos.ConceptScheme
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Representation extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}