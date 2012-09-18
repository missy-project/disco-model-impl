package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractUniverse<Q extends AbstractQuestion<?>> extends Identifiable {

	// properties

	@Column
	private String skos_definition;

	// relations

	@ManyToOne
	private AbstractUniverse<Q> dcterns_hasPart;

	@OneToMany
	private Set<Q> hasQuestion;

	// getter/setter

	public String getSkos_definition() {
		return skos_definition;
	}

	public void setSkos_definition(String skos_definition) {
		this.skos_definition = skos_definition;
	}

	public AbstractUniverse<Q> getDcterms_hasPart() {
		return dcterns_hasPart;
	}

	public void setDcterms_hasPart(AbstractUniverse<Q> dc_hasPart) {
		this.dcterns_hasPart = dc_hasPart;
	}

	public Set<Q> getHasQuestion() {
		return hasQuestion;
	}

	public void setHasQuestion(Set<Q> hasQuestion) {
		this.hasQuestion = hasQuestion;
	}

}
