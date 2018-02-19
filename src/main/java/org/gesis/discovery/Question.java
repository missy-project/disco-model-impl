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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.gesis.rdf.LangString;
import org.gesis.skos.Concept;

/**
 * A Question is designed to get information upon a subject, or sequence of
 * subjects, from a respondent. A Question is a {@link Concept}.
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#question">Definition:
 *      Question</a>
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Question extends Concept
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString questionText;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="Question_Representation",
			joinColumns=@JoinColumn( name = "question_id" ),
			inverseJoinColumns=@JoinColumn( name = "representation_id" ) )
	protected List<Representation> responseDomain;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="Question_Concept",
			joinColumns=@JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn( name = "concept_id" ))
	protected List<Concept> concept;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	// getter/setter

	/**
	 * @return The question text of this Question object.
	 * @see org.gesis.rdf.LangString
	 */
	public Object getQuestionText()
	{
		return questionText;
	}

	/**
	 * Corresponds to disco:questionText. Sets the question text for this Question.
	 * 
	 * @param questionText
	 * @return this Question object.
	 * @see #getQuestionText()
	 */
	public Question setQuestionText( final LangString questionText )
	{
		this.questionText = questionText;
		return this;
	}

	/**
	 * Get the list of response domains ({@link Representation}) of this Question.
	 * 
	 * @return The list of Representations of this Variable.
	 * @see org.gesis.discovery.Representation
	 * @see org.gesis.skos.ConceptScheme
	 */
	public List<Representation> getResponseDomain()
	{
		return responseDomain;
	}

	/**
	 * Corresponds to disco:responseDomain. Set the list of response domains
	 * ({@link Representation}) of this Question.
	 * 
	 * @param responseDomain
	 * @return This Question object.
	 * @see #getResponseDomain()
	 */
	public Question setResponseDomain( final List<Representation> responseDomain )
	{
		this.responseDomain = responseDomain;
		return this;
	}

	public Question addResponseDomain( final Representation responseDomain )
	{
		if ( this.responseDomain == null )
			this.responseDomain = new ArrayList<Representation>();

		this.responseDomain.add( responseDomain );

		return this;
	}

	/**
	 * @return The list of {@link Concept}s of this Question.
	 * @see org.gesis.skos.Concept
	 */
	public List<Concept> getConcept()
	{
		return concept;
	}

	/**
	 * Corresponds to disco:concept. Sets the list of Concepts for this Question.
	 * Points to the DDI concept of a RepresentedVariable, a Variable, or a
	 * Question.
	 * 
	 * @param concept
	 * @return This Question object.
	 * @see #getConcept()
	 */
	public Question setConcept( final List<Concept> concept )
	{
		this.concept = concept;
		return this;
	}

	public Question addConcept( final Concept concept )
	{
		if ( this.concept == null )
			this.concept = new ArrayList<Concept>();

		this.concept.add( concept );

		return this;
	}

	/**
	 * Indicates the particular {@link Universe}(s) that may be connected to this
	 * Question. For instance, two questions are addressing the universe of persons,
	 * the third question is addressing a specific subset of the universe of
	 * persons.
	 * 
	 * @return The Universe of this Question.
	 * @see org.gesis.discovery.Universe
	 * @see org.gesis.skos.Concept
	 */
	public Universe getUniverse()
	{
		return universe;
	}

	/**
	 * Corresponds to disco:universe. Sets the {@link Universe} for this Question.
	 * For instance, two questions are addressing the universe of persons, the third
	 * question is addressing a specific subset of the universe of persons.
	 * 
	 * @param universe
	 * @return This Question object.
	 * @see #getUniverse()
	 */
	public Question setUniverse( final Universe universe )
	{
		this.universe = universe;
		return this;
	}

	/**
	 * Factory-method to create a Question with the given question text.
	 * 
	 * @param questionText
	 * @return A Question object with the given question text.
	 */
	public static Question withQuestionText( final LangString questionText )
	{
		Question question = new Question();
		question.setQuestionText( questionText );

		return question;
	}
}