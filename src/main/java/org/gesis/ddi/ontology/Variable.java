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
import javax.persistence.OneToOne;

import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Variable extends Resource
{

	// properties

	@Column
	protected String skos_notation;

	@OneToOne
	protected LangString dcterms_description;

	// relations

	@ManyToOne
	@JoinColumn( name = "analysisUnit_id" )
	protected AnalysisUnit analysisUnit;

	@ManyToOne
	@JoinColumn( name = "concept_id" )
	protected Concept concept;

	@ManyToOne
	@JoinColumn( name = "variableDefinition_id" )
	protected VariableDefinition basedOn;

	@ManyToOne
	@JoinColumn( name = "representation_id" )
	protected Representation representation;

	@ManyToOne
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Variable_Question", 
			joinColumns = @JoinColumn( name = "variable_id" ),
			inverseJoinColumns = @JoinColumn( name = "question_id" ) )
	protected Set<Question> question;

	// getter/setter

	public Variable( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public String getSkos_notation()
	{
		return skos_notation;
	}

	public void setSkos_notation(String skos_notation)
	{
		this.skos_notation = skos_notation;
	}

	public LangString getDcterms_description()
	{
		return dcterms_description;
	}

	public void setDcterms_description( LangString dcterms_description )
	{
		this.dcterms_description = dcterms_description;
	}

	public AnalysisUnit getAnalysisUnit()
	{
		return analysisUnit;
	}

	public void setAnalysisUnit(AnalysisUnit analysisUnit)
	{
		this.analysisUnit = analysisUnit;
	}

	public Concept getConcept()
	{
		return concept;
	}

	public void setConcept(Concept concept)
	{
		this.concept = concept;
	}

	public VariableDefinition getBasedOn()
	{
		return basedOn;
	}

	public void setBasedOn(VariableDefinition dataElement)
	{
		this.basedOn = dataElement;
	}

	public Representation getRepresentation()
	{
		return representation;
	}

	public void setRepresentation(Representation representation)
	{
		this.representation = representation;
	}

	public Universe getUniverse()
	{
		return universe;
	}

	public void setUniverse(Universe universe)
	{
		this.universe = universe;
	}

	public Set<Question> getQuestion()
	{
		return question;
	}

	public void setQuestion(Set<Question> questions)
	{
		this.question = questions;
	}
}
