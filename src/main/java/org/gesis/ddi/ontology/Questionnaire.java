package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name="Questionnaire_Concept", 
			joinColumns=@JoinColumn(name="questionnaire_id"), 
			inverseJoinColumns=@JoinColumn(name="concept_id"))
	protected Set<Concept> collectionMode;

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name="Questionnaire_Question", 
			joinColumns=@JoinColumn(name="questionnaire_id"), 
			inverseJoinColumns=@JoinColumn(name="question_id"))
	protected Set<Question> question;

	// getter/setter

	public Questionnaire( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Set<Concept> getCollectionMode() {
		return this.collectionMode;
	}

	public void setCollectionMode(Set<Concept> collectionMode) {
		this.collectionMode = collectionMode;
	}

	public Set<Question> getQuestion() {
		return this.question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

}