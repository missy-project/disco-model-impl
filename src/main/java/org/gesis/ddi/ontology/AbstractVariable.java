package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.Concept;

@MappedSuperclass
public abstract class AbstractVariable<I extends AbstractInstrument<?>, D extends AbstractDataElement<Q>, Q extends AbstractQuestion<?>> extends Identifiable {

	// properties

	@Column
	private String dcterms_identifier;

	@Column
	private String skos_prefLabel;

	@Column
	private String dcterms_description;

	// relations

	@ManyToMany
	private Set<I> isPopulatedBy;

	@ManyToMany
	private Set<D> usesDataElement;

	@ManyToOne
	private AbstractUniverse<Q> holdsMeasurementOf;

	@ManyToOne
	private Representation hasRepresentation;

	@ManyToOne
	private Concept hasConcept;

	@ManyToOne
	private Q hasQuestion;

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

	public Set<I> getIsPopulatedBy() {
		return isPopulatedBy;
	}

	public void setIsPopulatedBy(Set<I> isPopulatedBy) {
		this.isPopulatedBy = isPopulatedBy;
	}

	public Set<D> getUsesDataElement() {
		return usesDataElement;
	}

	public void setUsesDataElement(Set<D> usesDataElement) {
		this.usesDataElement = usesDataElement;
	}

	public AbstractUniverse<Q> getHoldsMeasurementOf() {
		return holdsMeasurementOf;
	}

	public void setHoldsMeasurementOf(AbstractUniverse<Q> holdsMeasurementOf) {
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

	public Q getHasQuestion() {
		return hasQuestion;
	}

	public void setHasQuestion(Q hasQuestion) {
		this.hasQuestion = hasQuestion;
	}

}
