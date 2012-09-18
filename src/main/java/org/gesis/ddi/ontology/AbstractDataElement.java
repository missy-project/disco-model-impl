package org.gesis.ddi.ontology;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.Concept;

@MappedSuperclass
public abstract class AbstractDataElement<Q extends AbstractQuestion<?>> extends Identifiable {

	// properties

	@Column
	private String skos_prefLabel;

	@Column
	private String dcterms_description;

	// relations

	@ManyToOne
	private AbstractUniverse<Q> holdsMeasurementOf;

	@ManyToOne
	private Concept hasConcept;

	@ManyToOne
	private Representation hasRepresentation;

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

	public AbstractUniverse<Q> getHoldsMeasurementOf() {
		return holdsMeasurementOf;
	}

	public void setHoldsMeasurementOf(AbstractUniverse<Q> holdsMeasurementOf) {
		this.holdsMeasurementOf = holdsMeasurementOf;
	}

	public Concept getHasConcept() {
		return hasConcept;
	}

	public void setHasConcept(Concept hasConcept) {
		this.hasConcept = hasConcept;
	}

	public Representation getHasRepresentation() {
		return hasRepresentation;
	}

	public void setHasRepresentation(Representation hasRepresentation) {
		this.hasRepresentation = hasRepresentation;
	}

}
