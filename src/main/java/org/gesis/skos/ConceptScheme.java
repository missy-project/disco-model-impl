package org.gesis.skos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.gesis.discovery.Representation;

/**
 * A ConceptScheme, defined within the SKOS namespace, is a set of metadata
 * describing statistical Concepts in a theme taxonomy.
 * 
 * <p>
 * A ConceptScheme is a {@link Representation}.
 * </p>
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#codes-and-categories">Definition:
 *      Codes and Categories</a>
 * @see org.gesis.discovery.Representation
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class ConceptScheme extends Representation
{

	// properties

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// relations

	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable(
			name = "ConceptScheme_Concept",
			joinColumns = @JoinColumn( name = "conceptScheme_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn( name = "hasTopConcept_id" ) )
	protected List<Concept> hasTopConcept;

	// getter/setter

	/**
	 * @return The list of top concepts in this ConceptScheme.
	 * @see org.gesis.skos.Concept
	 */
	public List<Concept> getHasTopConcept()
	{
		return hasTopConcept;
	}

	/**
	 * Corresponds to skos:hasTopConcept. Sets the top concepts in this specific
	 * ConceptScheme.
	 * 
	 * @param hasTopConcept
	 * @return This ConceptScheme object.
	 * @see #getHasTopConcept()
	 */
	public ConceptScheme setHasTopConcept( final List<Concept> hasTopConcept )
	{
		this.hasTopConcept = hasTopConcept;
		return this;
	}

	public ConceptScheme addHasTopConcept( final Concept concept )
	{
		if ( hasTopConcept == null )
			hasTopConcept = new ArrayList<Concept>();

		hasTopConcept.add( concept );

		return this;
	}

}