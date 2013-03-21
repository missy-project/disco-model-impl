package org.gesis.dcterms;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.gesis.foaf.Document;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class RightsStatement extends Resource
{

	// properties
	
	@OneToOne
	private LangString dcterms_description;

	// relations

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "RightsStatement_Document",
			joinColumns = @JoinColumn( name = "rightsStatement_id" ), 
			inverseJoinColumns = @JoinColumn( name = "document_id" ) )
	protected Set<Document> rdfs_seeAlso;
	
	// getter/setter
	
	public RightsStatement( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Set<Document> getRdfs_seeAlso()
	{
		return rdfs_seeAlso;
	}

	public void setRdfs_seeAlso( Set<Document> rdfs_seeAlso )
	{
		this.rdfs_seeAlso = rdfs_seeAlso;
	}

	public LangString getDcterms_description()
	{
		return dcterms_description;
	}

	public void setDcterms_description( LangString dcterms_description )
	{
		this.dcterms_description = dcterms_description;
	}
	
}