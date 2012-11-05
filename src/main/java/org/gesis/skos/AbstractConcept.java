package org.gesis.skos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractConcept extends Identifiable {

	// properties

	@Column
	private String skos_definition;

	@Column
	private String skos_notation;

	@Column
	private String skos_prefLabel;

	// relations

	@ManyToMany
	private Set<ConceptScheme> skos_inScheme;

	@ManyToMany
	private Set<AbstractConcept> skos_broader;

	@ManyToMany
	private Set<AbstractConcept> skos_narrower;

	// getter/setter

	public String getSkos_definition() {
		return skos_definition;
	}

	public void setSkos_definition(String skos_definition) {
		this.skos_definition = skos_definition;
	}

	public String getSkos_prefLabel() {
		return skos_prefLabel;
	}

	public void setSkos_prefLabel(String skos_prefLabel) {
		this.skos_prefLabel = skos_prefLabel;
	}

	public String getSkos_notation() {
		return skos_notation;
	}

	public void setSkos_notation(String skos_notation) {
		this.skos_notation = skos_notation;
	}

	public Set<ConceptScheme> getSkos_inScheme() {
		return skos_inScheme;
	}

	public void setSkos_inScheme(Set<ConceptScheme> skos_inScheme) {
		this.skos_inScheme = skos_inScheme;
	}

	public Set<AbstractConcept> getSkos_broader() {
		return skos_broader;
	}

	public void setSkos_broader(Set<AbstractConcept> skos_broader) {
		this.skos_broader = skos_broader;
	}

	public Set<AbstractConcept> getSkos_narrower() {
		return skos_narrower;
	}

	public void setSkos_narrower(Set<AbstractConcept> skos_narrower) {
		this.skos_narrower = skos_narrower;
	}
}
