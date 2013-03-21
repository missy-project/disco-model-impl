package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.MediaTypeOrExtend;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.dcterms.ProvenanceStatement;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class DataFile extends Resource
{

	// properties

	@OneToOne
	private LangString dcterms_description;

	@Column
	private int caseQuantity;

	@Column
	private String owl_versionInfo;
	
	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "DataFile_ProvenanceStatement", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "provenanceStatement_id" ) )
	private Set<ProvenanceStatement> dcterms_provenance;

	// relations

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "DataFile_Location", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	protected Set<Location> dcterms_spatial;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "DataFile_PeriodOfTime", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	protected Set<PeriodOfTime> dcterms_temporal;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "DataFile_Concept", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> dcterms_subject;

	@ManyToOne
	@JoinColumn( name = "mediaTypeOrExtend_id" )
	protected MediaTypeOrExtend dcterms_format;

	// getter/setter

	public DataFile( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public LangString getDcterms_description()
	{
		return dcterms_description;
	}

	public void setDcterms_description( LangString dcterms_description )
	{
		this.dcterms_description = dcterms_description;
	}

	public int getCaseQuantity()
	{
		return caseQuantity;
	}

	public void setCaseQuantity(int caseQuantity)
	{
		this.caseQuantity = caseQuantity;
	}

	public String getOwl_versionInfo()
	{
		return owl_versionInfo;
	}

	public void setOwl_versionInfo(String owl_versionInfo)
	{
		this.owl_versionInfo = owl_versionInfo;
	}

	public Set<Location> getDcterms_spatial()
	{
		return dcterms_spatial;
	}

	public void setDcterms_spatial( Set<Location> dcterms_spatial )
	{
		this.dcterms_spatial = dcterms_spatial;
	}

	public Set<PeriodOfTime> getDcterms_temporal()
	{
		return dcterms_temporal;
	}

	public void setDcterms_temporal( Set<PeriodOfTime> dcterms_temporal )
	{
		this.dcterms_temporal = dcterms_temporal;
	}

	public Set<Concept> getDcterms_subject()
	{
		return dcterms_subject;
	}

	public void setDcterms_subject( Set<Concept> dcterms_subject )
	{
		this.dcterms_subject = dcterms_subject;
	}

	public Set<ProvenanceStatement> getDcterms_provenance()
	{
		return dcterms_provenance;
	}

	public void setDcterms_provenance( Set<ProvenanceStatement> dcterms_provenance )
	{
		this.dcterms_provenance = dcterms_provenance;
	}

	public MediaTypeOrExtend getDcterms_format()
	{
		return dcterms_format;
	}

	public void setDcterms_format( MediaTypeOrExtend dcterms_format )
	{
		this.dcterms_format = dcterms_format;
	}

}
