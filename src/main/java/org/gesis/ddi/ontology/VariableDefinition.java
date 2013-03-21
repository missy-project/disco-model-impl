package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private String dcterms_description;

	// relations

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name="VariableDefinition_Universe",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "universe_id" ))
	protected Set<Universe> universe;

	@ManyToOne
	@JoinColumn( name = "concept_id" )
	protected Concept concept;

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name="VariableDefinition_Representation",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "representation_id" ))
	protected Set<Representation> representation;

	// getter/setter

	public VariableDefinition( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public String getDcterms_description() {
		return dcterms_description;
	}

	public void setDcterms_description(String dcterms_description) {
		this.dcterms_description = dcterms_description;
	}

	public Set<Universe> getUniverse() {
		return this.universe;
	}

	public void setUniverse(Set<Universe> universe)
	{
		this.universe = universe;
	}

	public Concept getConcept()
	{
		return this.concept;
	}

	public void setConcept( Concept concept )
	{
		this.concept = concept;
	}

	public Set<Representation> getRepresentation() {
		return this.representation;
	}

	public void setRepresentation(Set<Representation> representation)
	{
		this.representation = representation;
	}

}