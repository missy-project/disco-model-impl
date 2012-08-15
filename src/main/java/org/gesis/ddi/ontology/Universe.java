package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public class Universe extends Identifiable {

	// properties

	@Column
	private String skos_definition;

	// relations

	@ManyToOne
	private Universe dcterns_hasPart;

	@OneToMany
	private Set<Question> hasQuestion;

	// getter/setter

	public String getSkos_definition() {
		return skos_definition;
	}

	public void setSkos_definition(String skos_definition) {
		this.skos_definition = skos_definition;
	}

	public Universe getDcterms_hasPart() {
		return dcterns_hasPart;
	}

	public void setDcterms_hasPart(Universe dc_hasPart) {
		this.dcterns_hasPart = dc_hasPart;
	}

	public Set<Question> getHasQuestion() {
		return hasQuestion;
	}

	public void setHasQuestion(Set<Question> hasQuestion) {
		this.hasQuestion = hasQuestion;
	}

}
