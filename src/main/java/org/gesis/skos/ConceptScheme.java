package org.gesis.skos;

import java.util.LinkedHashSet;
import java.util.Set;

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

	@ManyToMany
	@JoinTable(
			name="ConceptScheme_Concept",
			joinColumns=@JoinColumn(name="conceptScheme_id"),
			inverseJoinColumns=@JoinColumn(name="concept_id")
	)
	protected Set<Concept> hasTopConcept;

	// getter/setter

	public Set<Concept> getHasTopConcept()
	{
		return this.hasTopConcept;
	}

	public void setHasTopConcept( final Set<Concept> skos_hasTopConcept )
	{
		this.hasTopConcept = skos_hasTopConcept;
	}

	public ConceptScheme addHasTopConcept( final Concept concept )
	{
		if ( this.hasTopConcept == null )
			this.hasTopConcept = new LinkedHashSet<Concept>();

		this.hasTopConcept.add( concept );

		return this;
	}

}