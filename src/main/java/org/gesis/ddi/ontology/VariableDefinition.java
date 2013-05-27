package org.gesis.ddi.ontology;

import java.util.HashSet;
import java.util.Set;

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
	private String dcterms_description;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="VariableDefinition_Universe",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "universe_id" ))
	protected Set<Universe> universe;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "concept_id" )
	protected Concept concept;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="VariableDefinition_Representation",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "representation_id" ))
	protected Set<Representation> representation;

	// getter/setter

	public VariableDefinition( final String agencyId, final String objectId, final int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public String getDcterms_description() {
		return this.dcterms_description;
	}

	public void setDcterms_description(final String dcterms_description) {
		this.dcterms_description = dcterms_description;
	}

	public Set<Universe> getUniverse() {
		return this.universe;
	}

	public void setUniverse(final Set<Universe> universe)
	{
		this.universe = universe;
	}

	public VariableDefinition addUniverse( final Universe universe )
	{
		if ( this.universe == null )
			this.universe = new HashSet<Universe>();

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

	public Set<Representation> getRepresentation() {
		return this.representation;
	}

	public void setRepresentation(final Set<Representation> representation)
	{
		this.representation = representation;
	}

	public VariableDefinition addRepresentation( final Representation representation )
	{
		if ( this.representation == null )
			this.representation = new HashSet<Representation>();

		this.representation.add( representation );

		return this;
	}

}