package org.gesis.ddi.ontology;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.dcterms.AbstractDataset;
import org.gesis.dcterms.AbstractMediaTypeOrExtend;
import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractDataFile<L extends Location, P extends PeriodOfTime, C extends AbstractConcept> extends AbstractDataset {

	// properties

	@Column
	private String dcterms_description;

	@Column
	private int caseQuantity;

	@Column
	private String dcterms_provenance;

	@Column
	private String owl_versionInfo;

	// relations

	@ManyToOne
	private AbstractCoverage<L, P, C> coverage;

	@ManyToOne
	private AbstractMediaTypeOrExtend dcterms_format;

	// getter/setter

	public String getDcterms_description() {
		return dcterms_description;
	}

	public void setDcterms_description(String dcterms_description) {
		this.dcterms_description = dcterms_description;
	}

	public int getCaseQuantity() {
		return caseQuantity;
	}

	public void setCaseQuantity(int caseQuantity) {
		this.caseQuantity = caseQuantity;
	}

	public String getDcterms_provenance() {
		return dcterms_provenance;
	}

	public void setDcterms_provenance(String dcterms_provenance) {
		this.dcterms_provenance = dcterms_provenance;
	}

	public String getOwl_versionInfo() {
		return owl_versionInfo;
	}

	public void setOwl_versionInfo(String owl_versionInfo) {
		this.owl_versionInfo = owl_versionInfo;
	}

	public AbstractCoverage<L, P, C> getCoverage()
	{
		return coverage;
	}

	public void setCoverage(AbstractCoverage<L, P, C> coverage)
	{
		this.coverage = coverage;
	}

	public AbstractMediaTypeOrExtend getDcterms_format() {
		return dcterms_format;
	}

	public void setDcterms_format(AbstractMediaTypeOrExtend dcterms_format) {
		this.dcterms_format = dcterms_format;
	}

}
