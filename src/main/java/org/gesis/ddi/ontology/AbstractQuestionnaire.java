package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public class AbstractQuestionnaire<C extends AbstractConcept, Q extends AbstractQuestion<?, ?>> extends AbstractInstrument {

	@ManyToMany
	private Set<C> collectionMode;

	@ManyToMany
	private Set<Q> question;

	public Set<C> getCollectionMode()
	{
		return collectionMode;
	}

	public void setCollectionMode( Set<C> collectionMode )
	{
		this.collectionMode = collectionMode;
	}

	public Set<Q> getQuestion()
	{
		return question;
	}

	public void setQuestion( Set<Q> question )
	{
		this.question = question;
	}

}
