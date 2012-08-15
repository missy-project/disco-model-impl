package org.gesis.skos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public class Concept extends Identifiable {

	// properties

	@Column
	private String skos_prefLabel;

	@Column
	private String skos_notation;

	// relations

	@ManyToMany
	private Set<ConceptScheme> skos_inScheme;

	@ManyToOne(optional = false)
	private Concept skos_broader;

	@ManyToOne(optional = false)
	private Concept category;

	// getter/setter

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

	public Concept getSkos_broader() {
		return skos_broader;
	}

	public void setSkos_broader(Concept skos_broader) {
		this.skos_broader = skos_broader;
	}

	public Concept getCategory() {
		return category;
	}

	public void setCategory(Concept category) {
		this.category = category;
	}

}
