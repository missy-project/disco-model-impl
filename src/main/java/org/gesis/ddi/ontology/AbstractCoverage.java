package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.dcterms.AbstractLocation;
import org.gesis.dcterms.AbstractPeriodOfTime;
import org.gesis.ddi.Identifiable;
import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractCoverage<L extends AbstractLocation, P extends AbstractPeriodOfTime, C extends AbstractConcept> extends Identifiable {

	// properties

	// relations

	@ManyToMany
	private Set<L> dcterms_spatial;

	@ManyToMany
	private Set<P> dcterms_temporal;

	@ManyToMany
	private Set<C> dcterms_subject;

	// getter/setter

	public Set<C> getDcterms_subject()
	{
		return dcterms_subject;
	}

	public void setDcterms_subject( Set<C> dcterms_subject )
	{
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
