package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractVariable<Q extends AbstractQuestion<?, ?>> extends Identifiable {

	// properties

	@Column
	private String skos_notation;

	@Column
	private String skos_prefLabel;

	@Column
	private String dcterms_description;

	// relations

	@ManyToOne(optional = true)
	private AbstractDataElement<?, ?, ?> basedOn;

	@ManyToOne(optional = false)
	private AbstractUniverse<Q> universe;

	@ManyToOne(optional = false)
	private Representation representation;

	@ManyToOne(optional = false)
	private AbstractConcept concept;

	@ManyToMany
	private Set<Q> question;

	@ManyToOne(optional = true)
	private AbstractAnalysisUnit analysisUnit;

	// getter/setter

	public String getSkos_notation() {
		return skos_notation;
	}

	public void setSkos_notation(String skos_notation) {
		this.skos_notation = skos_notation;
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

	public AbstractDataElement<?, ?, ?> getBasedOn() {
		return basedOn;
	}

	public void setBasedOn(AbstractDataElement<?, ?, ?> basedOn) {
		this.basedOn = basedOn;
	}

	public AbstractUniverse<Q> getUniverse() {
		return universe;
	}

	public void setUniverse(AbstractUniverse<Q> universe) {
		this.universe = universe;
	}

	public Representation getRepresentation() {
		return representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}

	public AbstractConcept getConcept() {
		return concept;
	}

	public void setConcept(AbstractConcept concept) {
		this.concept = concept;
	}

	public Set<Q> getQuestion()
	{
		return question;
	}

	public void setQuestion( Set<Q> question )
	{
		this.question = question;
	}

	public AbstractAnalysisUnit getAnalysisUnit()
	{
		return analysisUnit;
	}

	public void setAnalysisUnit(AbstractAnalysisUnit analysisUnit)
	{
		this.analysisUnit = analysisUnit;
	}

}
