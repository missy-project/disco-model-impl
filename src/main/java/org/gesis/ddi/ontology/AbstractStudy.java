package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.Identifiable;
import org.gesis.foaf.Agent;
import org.gesis.foaf.Document;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractStudy<I extends AbstractInstrument, V extends AbstractVariable<?>, F extends AbstractDataFile<T, P, C>, T extends Location, P extends PeriodOfTime, L extends AbstractLogicalDataSet<?, ?, ?, ?, ?, ?>, U extends AbstractUniverse<?>, C extends AbstractConcept> extends Identifiable {

	// properties

	@Column
	private String dcterms_abstract;

	@Column
	private String dcterms_alternate;

	@Column
	private String dcterms_available;

	@Column
	private String dcterms_title;

	@Column
	private String purpose;

	@Column
	private String subtitle;

	// relations

	@OneToMany
	private Set<I> instrument;

	@ManyToMany
	private Set<V> variable;

	@ManyToMany
	private Set<F> dataFile;

	@ManyToMany
	private Set<U> studyUniverse;

	@ManyToMany
	private Set<L> product;

	@ManyToOne
	private AbstractCoverage<T, P, C> coverage;
	
	@ManyToOne(optional = true)
	private AbstractAnalysisUnit analysisUnit;

	// TODO zl Verifiy against spec: this cardinality might change in future
	@ManyToMany
	private Set<AbstractConcept> kindOfData;

	// TODO zl Verifiy against spec: this cardinality might change in future
	@ManyToMany
	private Set<AbstractConcept> dcterms_subject;

	@OneToOne
	private Document ddiFile;

	@ManyToMany
	private Set<Agent> dcterms_publisher;

	@ManyToMany
	private Set<Agent> dcterms_contributer;

	@ManyToMany
	private Set<Agent> dcterms_creator;

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

	public String getDcterms_alternate() {
		return dcterms_alternate;
	}

	public void setDcterms_alternate(String dcterms_alternate) {
		this.dcterms_alternate = dcterms_alternate;
	}

	public String getDcterms_available() {
		return dcterms_available;
	}

	public void setDcterms_available(String dcterms_available) {
		this.dcterms_available = dcterms_available;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Set<I> getInstrument() {
		return instrument;
	}

	public void setInstrument(Set<I> instrument) {
		this.instrument = instrument;
	}

	public Set<V> getVariable() {
		return variable;
	}

	public void setVariable( Set<V> variable )
	{
		this.variable = variable;
	}

	public Set<F> getDataFile() {
		return dataFile;
	}

	public void setDataFile(Set<F> dataFile) {
		this.dataFile = dataFile;
	}

	public Set<U> getStudyUniverse()
	{
		return studyUniverse;
	}

	public void setStudyUniverse( Set<U> studyUniverse )
	{
		this.studyUniverse = studyUniverse;
	}

	public Set<L> getProduct() {
		return product;
	}

	public void setproduct(Set<L> product) {
		this.product = product;
	}

	public AbstractCoverage<T, P, C> getCoverage()
	{
		return coverage;
	}

	public void setCoverage(AbstractCoverage<T, P, C> coverage)
	{
		this.coverage = coverage;
	}

	public AbstractAnalysisUnit getAnalysisUnit() {
		return analysisUnit;
	}

	public void setAnalysisUnit(AbstractAnalysisUnit analysisUnit) {
		this.analysisUnit = analysisUnit;
	}

	public Set<AbstractConcept> getKindOfData()
	{
		return kindOfData;
	}

	public void setKindOfData( Set<AbstractConcept> kindOfData )
	{
		this.kindOfData = kindOfData;
	}

	public Set<AbstractConcept> getDcterms_subject()
	{
		return dcterms_subject;
	}

	public void setDcterms_subject( Set<AbstractConcept> dcterms_subject )
	{
		this.dcterms_subject = dcterms_subject;
	}

	public Document getDdiFile() {
		return ddiFile;
	}

	public void setDdiFile(Document ddiFile) {
		this.ddiFile = ddiFile;
	}

	public Set<Agent> getDcterms_publisher() {
		return dcterms_publisher;
	}

	public void setDcterms_publisher(Set<Agent> dcterms_publisher) {
		this.dcterms_publisher = dcterms_publisher;
	}

	public Set<Agent> getDcterms_contributer() {
		return dcterms_contributer;
	}

	public void setDcterms_contributer(Set<Agent> dcterms_contributer) {
		this.dcterms_contributer = dcterms_contributer;
	}

	public Set<Agent> getDcterms_creator() {
		return dcterms_creator;
	}

	public void setDcterms_creator(Set<Agent> dcterms_creator) {
		this.dcterms_creator = dcterms_creator;
	}

	public void setProduct( Set<L> product )
	{
		this.product = product;
	}
	
}
