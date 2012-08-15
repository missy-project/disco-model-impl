package org.gesis.dcterms;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public class Location extends Identifiable {

	@Column
	private String rdfs_label;

	public String getRdfs_label() {
		return rdfs_label;
	}

	public void setRdfs_label(String rdfs_label) {
		this.rdfs_label = rdfs_label;
	}

}
