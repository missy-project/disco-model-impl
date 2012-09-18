package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractCoverage<L extends Location, P extends PeriodOfTime> extends Identifiable {

	// properties

	@Column
	private String dcterms_subject;

	// relations

	@ManyToMany
	private Set<L> dcterms_spatial;

	@ManyToMany
	private Set<P> dcterms_temporal;

	// getter/setter

	public String getDcterms_subject() {
		return dcterms_subject;
	}

	public void setDcterms_subject(String dcterms_subject) {
		this.dcterms_subject = dcterms_subject;
	}

	public Set<P> getDcterms_temporal() {
		return dcterms_temporal;
	}

	public void setDcterms_temporal(Set<P> dcterms_temporal) {
		this.dcterms_temporal = dcterms_temporal;
	}

	public Set<L> getDcterms_spatial() {
		return dcterms_spatial;
	}

	public void setDcterms_spatial(Set<L> dcterms_spatial) {
		this.dcterms_spatial = dcterms_spatial;
	}

}
