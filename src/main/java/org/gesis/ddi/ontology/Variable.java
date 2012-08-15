package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.Concept;

@MappedSuperclass
public class Variable extends Identifiable {

	// properties

	@Column
	private String dcterms_identifier;

	@Column
	private String skos_prefLabel;

	@Column
	private String dcterms_description;

	// relations

	@ManyToOne
	private Set<Instrument> isPopulatedBy;

	@ManyToMany
	private Set<DataElement> usesDataElement;

	@ManyToOne
	private Universe holdsMeasurementOf;

	@ManyToOne
	private Representation hasRepresentation;

	@ManyToOne
	private Concept hasConcept;

	@ManyToOne
	private Question hasQuestion;

	// getter/setter

	public String getDcterms_identifier() {
		return dcterms_identifier;
	}

	public void setDcterms_identifier(String dcterms_identifier) {
		this.dcterms_identifier = dcterms_identifier;
	}

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

	public Set<Instrument> getIsPopulatedBy() {
		return isPopulatedBy;
	}

	public void setIsPopulatedBy(Set<Instrument> isPopulatedBy) {
		this.isPopulatedBy = isPopulatedBy;
	}

	public Set<DataElement> getUsesDataElement() {
		return usesDataElement;
	}

	public void setUsesDataElement(Set<DataElement> usesDataElement) {
		this.usesDataElement = usesDataElement;
	}

	public Universe getHoldsMeasurementOf() {
		return holdsMeasurementOf;
	}

	public void setHoldsMeasurementOf(Universe holdsMeasurementOf) {
		this.holdsMeasurementOf = holdsMeasurementOf;
	}

	public Representation getHasRepresentation() {
		return hasRepresentation;
	}

	public void setHasRepresentation(Representation hasRepresentation) {
		this.hasRepresentation = hasRepresentation;
	}

	public Concept getHasConcept() {
		return hasConcept;
	}

	public void setHasConcept(Concept hasConcept) {
		this.hasConcept = hasConcept;
	}

	public Question getHasQuestion() {
		return hasQuestion;
	}

	public void setHasQuestion(Question hasQuestion) {
		this.hasQuestion = hasQuestion;
	}

}
