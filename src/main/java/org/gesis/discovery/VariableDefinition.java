package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class VariableDefinition extends Resource
{

	// properties

	@Column
	@Lob
	private String description;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="VariableDefinition_Universe",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "universe_id" ))
	protected List<Universe> universe;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "concept_id" )
	protected Concept concept;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="VariableDefinition_Representation",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "representation_id" ))
	protected List<Representation> representation;

	// getter/setter

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String dcterms_description) {
		this.description = dcterms_description;
	}

	public List<Universe> getUniverse() {
		return this.universe;
	}

	public void setUniverse(final List<Universe> universe)
	{
		this.universe = universe;
	}

	public VariableDefinition addUniverse( final Universe universe )
	{
		if ( this.universe == null )
			this.universe = new ArrayList<Universe>();

		this.universe.add( universe );

		return this;
	}

	public Concept getConcept()
	{
		return this.concept;
	}

	public void setConcept( final Concept concept )
	{
		this.concept = concept;
	}

	public List<Representation> getRepresentation() {
		return this.representation;
	}

	public void setRepresentation(final List<Representation> representation)
	{
		this.representation = representation;
	}

	public VariableDefinition addRepresentation( final Representation representation )
	{
		if ( this.representation == null )
			this.representation = new ArrayList<Representation>();

		this.representation.add( representation );

		return this;
	}

}