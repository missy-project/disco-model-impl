package org.gesis.discovery;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.skos.Concept;

/**
 * <p>
 * An AnalysisUnit is defined as follows: The process of collecting data focuses
 * on the analysis of a particular type of subject. If, for example, the adult
 * population of Finland is being studied, the AnalysisUnit would be individuals
 * or persons.
 * </p>
 * <p>
 * An AnalysisUnit is a {@link Concept}.
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#analysis-units-and-universes}
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class AnalysisUnit extends Concept
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	// relations

	// getter/setter
}