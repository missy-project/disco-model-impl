package org.gesis.discovery;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.skos.Concept;

/**
 * <p>
 * Universe is the total membership or population of a defined class of people,
 * objects or events. There are two types of population, target population and
 * survey population. A target population is the population outlined in the
 * survey objects about which information is to be sought. A survey population
 * (also known as the coverage of the survey) is the population from which
 * information can be obtained in the survey.
 * </p>
 * <p>
 * A Universe is a {@link Concept}
 * </p>
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#analysis-units-and-universes">Definition:
 *      Analysis Units and Universes</a>
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Universe extends Concept
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	// relations

	// getter/setter

}