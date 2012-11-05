package org.gesis.dcterms;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.gesis.skos.AbstractConcept;

@MappedSuperclass
public abstract class AbstractLocation extends AbstractConcept {

	// properties

	@Column
	private String rdfs_label;

	// getter/setter

	public String getRdfs_label() {
		return rdfs_label;
	}

	public void setRdfs_label(String rdfs_label) {
		this.rdfs_label = rdfs_label;
	}
}
