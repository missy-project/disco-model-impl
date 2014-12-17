package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

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
	protected List<Concept> collectionMode;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="Questionnaire_Question", 
			joinColumns=@JoinColumn(name="questionnaire_id"), 
			inverseJoinColumns=@JoinColumn(name="question_id"))
	protected List<Question> question;

	// getter/setter

	public List<Concept> getCollectionMode() {
		return this.collectionMode;
	}

	public void setCollectionMode(final List<Concept> collectionMode) {
		this.collectionMode = collectionMode;
	}

	public Questionnaire addCollectionMode( final Concept concept )
	{
		if ( this.collectionMode == null )
			this.collectionMode = new ArrayList<Concept>();

		this.collectionMode.add( concept );

		return this;
	}

	public List<Question> getQuestion() {
		return this.question;
	}

	public void setQuestion(final List<Question> question) {
		this.question = question;
	}

	public Questionnaire addQuestion( final Question question )
	{
		if ( this.question == null )
			this.question = new ArrayList<Question>();

		this.question.add( question );

		return this;
	}

}