package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractQuestion<C extends AbstractConcept, U extends AbstractUniverse<?>> extends Identifiable {

	// properties

	@Column
	private String questionText;

	@Column
	private String skos_prefLabel;

	// relations

	@ManyToOne
	private Representation responseDomain;

	@ManyToMany
	private Set<C> concept;

	@ManyToOne
	private Set<U> universe;

	// getter/setter

	public Object getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getSkos_prefLabel() {
		return skos_prefLabel;
	}

	public void setSkos_prefLabel(String skos_prefLabel) {
		this.skos_prefLabel = skos_prefLabel;
	}

	public Representation getResponseDomain()
	{
		return responseDomain;
	}

	public void setResponseDomain( Representation responseDomain )
	{
		this.responseDomain = responseDomain;
	}

	public Set<C> getConcept()
	{
		return concept;
	}

	public void setConcept( Set<C> concept )
	{
		this.concept = concept;
	}

	public Set<U> getUniverse()
	{
		return universe;
	}

	public void setUniverse( Set<U> universe )
	{
		this.universe = universe;
	}

}
