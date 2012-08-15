package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.qb.Dataset;

@MappedSuperclass
public class LogicalDataSet extends Identifiable {

	// properties

	@Column
	private String dcterms_title;

	// relations

	@ManyToMany
	private Set<Instrument> hasInstrument;

	@ManyToMany
	private Set<Variable> containsVariable;

	@ManyToOne
	private Universe isMeasureOf;

	@ManyToOne
	private Coverage hasCoverage;

	@ManyToMany
	private Set<Datafile> hasDatafile;

	@ManyToMany
	private Set<Dataset> hasNCube;

	// getter/setter

	public String getDcterms_title() {
		return dcterms_title;
	}

	public void setDcterms_title(String dcterms_title) {
		this.dcterms_title = dcterms_title;
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

	public Universe getIsMeasureOf() {
		return isMeasureOf;
	}

	public void setIsMeasureOf(Universe isMeasureOf) {
		this.isMeasureOf = isMeasureOf;
	}

	public Coverage getHasCoverage() {
		return hasCoverage;
	}

	public void setHasCoverage(Coverage hasCoverage) {
		this.hasCoverage = hasCoverage;
	}

	public Set<Datafile> getHasDatafile() {
		return hasDatafile;
	}

	public void setHasDatafile(Set<Datafile> hasDatafile) {
		this.hasDatafile = hasDatafile;
	}

	public Set<Dataset> getHasNCube() {
		return hasNCube;
	}

	public void setHasNCube(Set<Dataset> hasNCube) {
		this.hasNCube = hasNCube;
	}

}
