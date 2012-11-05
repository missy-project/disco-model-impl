package org.gesis.dcterms;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.gesis.ddi.Identifiable;
import org.gesis.foaf.Document;

@MappedSuperclass
public class AbstractRightsStatement extends Identifiable {

	// properties

	@Column
	private String dcterms_description;

	@Column
	private String skos_prefLabel;

	// relations

	@OneToOne
	private Document rdfs_seeAlso;

	// getter/setter

	public String getDcterms_description() {
		return dcterms_description;
	}

	public void setDcterms_description(String dcterms_description) {
		this.dcterms_description = dcterms_description;
	}

	public String getSkos_prefLabel() {
		return skos_prefLabel;
	}

	public void setSkos_prefLabel(String skos_prefLabel) {
		this.skos_prefLabel = skos_prefLabel;
	}

	public Document getRdfs_seeAlso() {
		return rdfs_seeAlso;
	}

	public void setRdfs_seeAlso(Document rdfs_seeAlso) {
		this.rdfs_seeAlso = rdfs_seeAlso;
	}

}
