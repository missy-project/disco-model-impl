package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractLogicalDataSet<I extends AbstractInstrument<?>, V extends AbstractVariable<I, D, Q>, Q extends AbstractQuestion<?>, F extends AbstractDatafile<?, ?>, D extends AbstractDataElement<Q>> extends Identifiable {

	// properties

	@Column
	private String dcterms_title;

	// relations

	@ManyToMany
	private Set<I> hasInstrument;

	@ManyToMany
	private Set<V> containsVariable;

	@ManyToOne
	private AbstractUniverse<Q> isMeasureOf;

	@ManyToOne
	private AbstractCoverage<Location, PeriodOfTime> hasCoverage; // TODO zl declare Location and PeriodOfTime also as generic types?

	@ManyToMany
	private Set<F> hasDatafile;

	@ManyToMany
	private Set<D> hasNCube;

	// getter/setter

	public String getDcterms_title() {
		return dcterms_title;
	}

	public void setDcterms_title(String dcterms_title) {
		this.dcterms_title = dcterms_title;
	}

	public Set<I> getHasInstrument() {
		return hasInstrument;
	}

	public void setHasInstrument(Set<I> hasInstrument) {
		this.hasInstrument = hasInstrument;
	}

	public Set<V> getContainsVariable() {
		return containsVariable;
	}

	public void setContainsVariable(Set<V> containsVariable) {
		this.containsVariable = containsVariable;
	}

	public AbstractUniverse<Q> getIsMeasureOf() {
		return isMeasureOf;
	}

	public void setIsMeasureOf(AbstractUniverse<Q> isMeasureOf) {
		this.isMeasureOf = isMeasureOf;
	}

	public AbstractCoverage<Location, PeriodOfTime> getHasCoverage() {
		return hasCoverage;
	}

	public void setHasCoverage(AbstractCoverage<Location, PeriodOfTime> hasCoverage) {
		this.hasCoverage = hasCoverage;
	}

	public Set<F> getHasDatafile() {
		return hasDatafile;
	}

	public void setHasDatafile(Set<F> hasDatafile) {
		this.hasDatafile = hasDatafile;
	}

	public Set<D> getHasNCube() {
		return hasNCube;
	}

	public void setHasNCube(Set<D> hasNCube) {
		this.hasNCube = hasNCube;
	}

}
