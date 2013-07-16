package org.gesis.discovery;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Questionnaire extends Instrument
{

	// properties

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="Questionnaire_Concept", 
			joinColumns=@JoinColumn(name="questionnaire_id"), 
			inverseJoinColumns=@JoinColumn(name="concept_id"))
	protected Set<Concept> collectionMode;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="Questionnaire_Question", 
			joinColumns=@JoinColumn(name="questionnaire_id"), 
			inverseJoinColumns=@JoinColumn(name="question_id"))
	protected Set<Question> question;

	// getter/setter

	public Set<Concept> getCollectionMode() {
		return this.collectionMode;
	}

	public void setCollectionMode(final Set<Concept> collectionMode) {
		this.collectionMode = collectionMode;
	}

	public Questionnaire addCollectionMode( final Concept concept )
	{
		if ( this.collectionMode == null )
			this.collectionMode = new HashSet<Concept>();

		this.collectionMode.add( concept );

		return this;
	}

	public Set<Question> getQuestion() {
		return this.question;
	}

	public void setQuestion(final Set<Question> question) {
		this.question = question;
	}

	public Questionnaire addQuestion( final Question question )
	{
		if ( this.question == null )
			this.question = new HashSet<Question>();

		this.question.add( question );

		return this;
	}

}