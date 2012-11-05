package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.datacube.AbstractDataSet;
import org.gesis.dcterms.AbstractLicenseDocument;
import org.gesis.dcterms.AbstractRightsStatement;
import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.Identifiable;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractLogicalDataSet<I extends AbstractInstrument, V extends AbstractVariable<Q>, Q extends AbstractQuestion<C, ?>, F extends AbstractDataFile<?, ?, ?>, D extends AbstractDataSet<?>, C extends AbstractConcept> extends Identifiable {

	// properties

	@Column
	private String dcterms_title;

	@Column
	private boolean isPublic;

	// relations

	@ManyToMany
	private Set<I> instrument;

	@ManyToMany
	private Set<V> containsVariable;

	@ManyToOne
	private AbstractUniverse<?> dataSetUniverse;

	@ManyToOne
	private AbstractCoverage<Location, PeriodOfTime, ?> coverage;

	@ManyToMany
	private Set<F> dataFile;

	@ManyToMany
	private Set<D> dataCube;

	@ManyToMany
	private Set<AbstractLicenseDocument> dcterms_license;

	@ManyToMany
	private Set<AbstractRightsStatement> dcterms_accessRights;

	// getter/setter

	public String getDcterms_title() {
		return dcterms_title;
	}

	public void setDcterms_title(String dcterms_title) {
		this.dcterms_title = dcterms_title;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Set<I> getInstrument() {
		return instrument;
	}

	public void setInstrument(Set<I> instrument) {
		this.instrument = instrument;
	}

	public Set<V> getContainsVariable() {
		return containsVariable;
	}

	public void setContainsVariable(Set<V> containsVariable) {
		this.containsVariable = containsVariable;
	}

	public AbstractUniverse<?> getDataSetUniverse() {
		return dataSetUniverse;
	}

	public void setDataSetUniverse(AbstractUniverse<?> dataSetUniverse) {
		this.dataSetUniverse = dataSetUniverse;
	}

	public AbstractCoverage<Location, PeriodOfTime, ?> getCoverage()
	{
		return coverage;
	}

	public void setCoverage(AbstractCoverage<Location, PeriodOfTime, ?> coverage)
	{
		this.coverage = coverage;
	}

	public Set<F> getDataFile() {
		return dataFile;
	}

	public void setDataFile(Set<F> dataFile) {
		this.dataFile = dataFile;
	}

	public Set<D> getDataCube()
	{
		return dataCube;
	}

	public void setDataCube( Set<D> dataCube )
	{
		this.dataCube = dataCube;
	}

	public Set<AbstractLicenseDocument> getDcterms_license() {
		return dcterms_license;
	}

	public void setDcterms_license(Set<AbstractLicenseDocument> dcterms_license) {
		this.dcterms_license = dcterms_license;
	}

	public Set<AbstractRightsStatement> getDcterms_accessRights() {
		return dcterms_accessRights;
	}

	public void setDcterms_accessRights(Set<AbstractRightsStatement> dcterms_accessRights) {
		this.dcterms_accessRights = dcterms_accessRights;
	}

}
