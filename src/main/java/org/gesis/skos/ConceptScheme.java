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

	public List<Concept> getHasTopConcept()
	{
		return hasTopConcept;
	}

	public void setHasTopConcept( final List<Concept> skos_hasTopConcept )
	{
		hasTopConcept = skos_hasTopConcept;
	}

	public ConceptScheme addHasTopConcept( final Concept concept )
	{
		if ( hasTopConcept == null )
			hasTopConcept = new ArrayList<Concept>();

		hasTopConcept.add( concept );

		return this;
	}

}