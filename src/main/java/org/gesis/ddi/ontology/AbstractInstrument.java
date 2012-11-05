package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractInstrument extends Identifiable {

	// relations

	@Column
	private String dcterms_description;

	@Column
	private String skos_prefLabel;

	// TODO zl Verifiy against spec: this cardinality might change in future
	@ManyToMany
	private Set<AbstractConcept> externalDocumentation;

	// getter/setter

	public Set<AbstractConcept> getExternalDocumentation() {
		return externalDocumentation;
	}

	public void setExternalDocumentation(Set<AbstractConcept> externalDocumentation) {
		this.externalDocumentation = externalDocumentation;
	}

	public String getDcterms_description() {
		return dcterms_description;
	}

	public void setDcterms_description(String dcterms_description) {
		this.dcterms_description = dcterms_description;
	}

	public String getSkos_prefLabel() {
		return skos_prefLabel;
	}

	public void setSkos_prefLabel(String skos_prefLabel) {
		this.skos_prefLabel = skos_prefLabel;
	}

}
