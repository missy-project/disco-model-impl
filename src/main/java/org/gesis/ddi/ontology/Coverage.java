package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.Identifiable;

@MappedSuperclass
public class Coverage extends Identifiable {

	// properties

	@Column
	private String dcterms_subject;

	// relations

	@ManyToMany
	private Set<Location> dcterms_spatial;

	@ManyToMany
	private Set<PeriodOfTime> dcterms_temporal;

	// getter/setter

	public String getDcterms_subject() {
		return dcterms_subject;
	}

	public void setDcterms_subject(String dcterms_subject) {
		this.dcterms_subject = dcterms_subject;
	}

	public Set<PeriodOfTime> getDcterms_temporal() {
		return dcterms_temporal;
	}

	public void setDcterms_temporal(Set<PeriodOfTime> dcterms_temporal) {
		this.dcterms_temporal = dcterms_temporal;
	}

	public Set<Location> getDcterms_spatial() {
		return dcterms_spatial;
	}

	public void setDcterms_spatial(Set<Location> dcterms_spatial) {
		this.dcterms_spatial = dcterms_spatial;
	}

}
