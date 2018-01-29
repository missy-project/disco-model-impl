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

/**
 * A Questionnaire is an {@link Instrument} that contains a flow of
 * {@link Question}s.
 * 
 * @author matthaeus
 * @see http://rdf-vocabulary.ddialliance.org/discovery.html#dfn-disco-questionnaire
 *
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Questionnaire extends Instrument
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	/**
	 * A collection method (also "Mode of Collection") is a special
	 * {@link Instrument} that defines the procedure, technique, or mode of inquiry
	 * used to attain the data. A specific collection mode can be associated with 0
	 * to n {@link Questionnaire}s.
	 * 
	 * @see http://rdf-vocabulary.ddialliance.org/discovery.html#dfn-disco-collectionmode
	 * @see http://www.ddialliance.org/Specification/DDI-CV/ModeOfCollection_2.0.html
	 * 
	 * @return List of Concepts definining the collection mode.
	 */
	public List<Concept> getCollectionMode() {
		return this.collectionMode;
	}

	/**
	 * Sets the list of collection modes ({@link Concept}) for this Questionnaire.
	 * 
	 * @param collectionMode
	 * @see {@link getCollectionMode()}
	 */
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

	/**
	 * Indicates the {@link Question}s associated to {@link Variable}s or contained
	 * in {@link Questionnaire}s.
	 * 
	 * @return List of Questions contained in this Questionnaire.
	 */
	public List<Question> getQuestion() {
		return this.question;
	}

	/**
	 * Sets the list of Questions for this Questionnaire instrument.
	 * 
	 * @param question
	 * @see {@link getQuestion()}
	 */
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