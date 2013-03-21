package org.gesis.ddi.ontology;

import java.util.Set;

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
public class Question extends Resource
{

	// properties

	@OneToOne
	private LangString questionText;

	// relations

	@ManyToMany
	@JoinTable(
			name="Question_Representation",
			joinColumns=@JoinColumn( name = "question_id" ),
			inverseJoinColumns=@JoinColumn( name = "representation_id" ) )
	protected Set<Representation> responseDomain;

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name="Question_Concept",
			joinColumns=@JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn( name = "concept_id" ))
	protected Set<Concept> concept;

	@ElementCollection
	@ManyToOne
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	// getter/setter

	public Question( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Object getQuestionText() {
		return questionText;
	}

	public void setQuestionText( LangString questionText )
	{
		this.questionText = questionText;
	}

	public Set<Representation> getResponseDomain()
	{
		return responseDomain;
	}

	public void setResponseDomain( Set<Representation> responseDomain )
	{
		this.responseDomain = responseDomain;
	}

	public Set<Concept> getConcept() {
		return this.concept;
	}

	public void setConcept(Set<Concept> concept) {
		this.concept = concept;
	}

	public Universe getUniverse()
	{
		return this.universe;
	}

	public void setUniverse( Universe universe )
	{
		this.universe = universe;
	}

}