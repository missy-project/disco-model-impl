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
public abstract class AbstractStudy<I extends AbstractInstrument<?>, V extends AbstractVariable<?, ?, ?>, F extends AbstractDatafile<T, P>, T extends Location, P extends PeriodOfTime, L extends AbstractLogicalDataSet<?, ?, ?, ?, ?>> extends Identifiable {

	// properties

	@Column
	private String dcterms_abstract;

	@Column
	private String dcterms_title;

	@Column
	private String dcterms_identifier;

	// relations

	@ManyToMany
	private Set<I> hasInstrument;

	@ManyToMany
	private Set<V> containsVariable;

	@ManyToMany
	private Set<F> hasDataFile;

	@ManyToOne
	private AbstractUniverse<?> isMeasureOf;

	@ManyToMany
	private Set<L> dcterms_hasPart;

	@ManyToOne
	private AbstractCoverage<T, P> hasConverage;

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

	public Set<F> getHasDataFile() {
		return hasDataFile;
	}

	public void setHasDataFile(Set<F> hasDataFile) {
		this.hasDataFile = hasDataFile;
	}

	public AbstractUniverse<?> getIsMeasureOf() {
		return isMeasureOf;
	}

	public void setIsMeasureOf(AbstractUniverse<?> isMeasureOf) {
		this.isMeasureOf = isMeasureOf;
	}

	public Set<L> getDcterms_hasPart() {
		return dcterms_hasPart;
	}

	public void setDcterms_hasPart(Set<L> dcterms_hasPart) {
		this.dcterms_hasPart = dcterms_hasPart;
	}

	public AbstractCoverage<T, P> getHasConverage() {
		return hasConverage;
	}

	public void setHasConverage(AbstractCoverage<T, P> hasConverage) {
		this.hasConverage = hasConverage;
	}

}
