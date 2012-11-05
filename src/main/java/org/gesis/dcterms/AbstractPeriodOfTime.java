package org.gesis.dcterms;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractPeriodOfTime extends Identifiable {

	// properties

	@Column
	private String skos_prefLabel;

	// relations

	// getter / setter

	public String getSkos_prefLabel() {
		return skos_prefLabel;
	}

	public void setSkos_prefLabel(String skos_prefLabel) {
		this.skos_prefLabel = skos_prefLabel;
	}

}
