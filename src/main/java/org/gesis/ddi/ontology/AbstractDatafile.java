package org.gesis.ddi.ontology;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractDatafile<L extends Location, P extends PeriodOfTime> extends Identifiable {

	// properties

	@Column
	private String dcterms_identifier;

	@Column
	private String dcterms_description;

	@Column
	private int caseQuantity;

	@Column
	private String dcterms_format;

	@Column
	private String dcterms_provenance;

	@Column
	private String owl_versionInfo;

	// relations

	@ManyToOne
	private AbstractCoverage<L, P> hasCoverage;

	// getter/setter

	public String getDcterms_identifier() {
		return dcterms_identifier;
	}

	public void setDcterms_identifier(String dcterms_identifier) {
		this.dcterms_identifier = dcterms_identifier;
	}

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

	public String getDcterms_format() {
		return dcterms_format;
	}

	public void setDcterms_format(String dcterms_format) {
		this.dcterms_format = dcterms_format;
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

	public AbstractCoverage<L, P> getHasCoverage() {
		return hasCoverage;
	}

	public void setHasCoverage(AbstractCoverage<L, P> hasCoverage) {
		this.hasCoverage = hasCoverage;
	}

}
