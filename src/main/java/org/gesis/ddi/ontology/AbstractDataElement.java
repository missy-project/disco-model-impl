package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractDataElement<U extends AbstractUniverse<?>, C extends AbstractConcept, R extends Representation> extends Identifiable {

	// properties

	@Column
	private String skos_prefLabel;

	@Column
	private String dcterms_description;

	// relations

	@ManyToMany
	private Set<U> universe;

	@ManyToMany
	private Set<C> concept;

	@ManyToMany
	private Set<R> representation;

	// getter/setter

	public String getSkos_prefLabel() {
		return skos_prefLabel;
	}

	public void setSkos_prefLabel(String skos_prefLabel) {
		this.skos_prefLabel = skos_prefLabel;
	}

	public String getDcterms_description() {
		return dcterms_description;
	}

	public void setDcterms_description(String dcterms_description) {
		this.dcterms_description = dcterms_description;
	}

	public Set<U> getUniverse() {
		return universe;
	}

	public void setUniverse(Set<U> universe) {
		this.universe = universe;
	}

	public Set<C> getConcept() {
		return concept;
	}

	public void setConcept(Set<C> concept) {
		this.concept = concept;
	}

	public Set<R> getRepresentation() {
		return representation;
	}

	public void setRepresentation(Set<R> representation) {
		this.representation = representation;
	}

}
