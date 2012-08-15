package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public class Study extends Identifiable {

	// properties

	@Column
	private String dcterms_abstract;

	@Column
	private String dcterms_title;

	@Column
	private String dcterms_identifier;

	// relations

	@ManyToMany
	private Set<Instrument> hasInstrument;

	@ManyToMany
	private Set<Variable> containsVariable;

	@ManyToMany
	private Set<Datafile> hasDataFile;

	@ManyToOne
	private Universe isMeasureOf;

	@ManyToMany
	private Set<LogicalDataSet> dcterms_hasPart;

	@ManyToOne
	private Coverage hasConverage;

	// getter/setter

	public String getDcterms_abstract() {
		return dcterms_abstract;
	}

	public void setDcterms_abstract(String dcterms_abstract) {
		this.dcterms_abstract = dcterms_abstract;
	}

	public String getDcterms_title() {
		return dcterms_title;
	}

	public void setDcterms_title(String dcterms_title) {
		this.dcterms_title = dcterms_title;
	}

	public String getDcterms_identifier() {
		return dcterms_identifier;
	}

	public void setDcterms_identifier(String dcterms_identifier) {
		this.dcterms_identifier = dcterms_identifier;
	}

	public Set<Instrument> getHasInstrument() {
		return hasInstrument;
	}

	public void setHasInstrument(Set<Instrument> hasInstrument) {
		this.hasInstrument = hasInstrument;
	}

	public Set<Variable> getContainsVariable() {
		return containsVariable;
	}

	public void setContainsVariable(Set<Variable> containsVariable) {
		this.containsVariable = containsVariable;
	}

	public Set<Datafile> getHasDataFile() {
		return hasDataFile;
	}

	public void setHasDataFile(Set<Datafile> hasDataFile) {
		this.hasDataFile = hasDataFile;
	}

	public Universe getIsMeasureOf() {
		return isMeasureOf;
	}

	public void setIsMeasureOf(Universe isMeasureOf) {
		this.isMeasureOf = isMeasureOf;
	}

	public Set<LogicalDataSet> getDcterms_hasPart() {
		return dcterms_hasPart;
	}

	public void setDcterms_hasPart(Set<LogicalDataSet> dcterms_hasPart) {
		this.dcterms_hasPart = dcterms_hasPart;
	}

	public Coverage getHasConverage() {
		return hasConverage;
	}

	public void setHasConverage(Coverage hasConverage) {
		this.hasConverage = hasConverage;
	}

}
