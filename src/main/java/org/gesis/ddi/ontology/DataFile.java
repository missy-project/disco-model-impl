package org.gesis.ddi.ontology;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString dcterms_description;

	@Column
	private int caseQuantity;

	@Column
	private String owl_versionInfo;
	
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "DataFile_ProvenanceStatement", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "provenanceStatement_id" ) )
	private Set<ProvenanceStatement> dcterms_provenance;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "DataFile_Location", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	protected Set<Location> dcterms_spatial;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "DataFile_PeriodOfTime", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	protected Set<PeriodOfTime> dcterms_temporal;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "DataFile_Concept", 
			joinColumns = @JoinColumn( name = "dataFile_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> dcterms_subject;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "mediaTypeOrExtend_id" )
	protected MediaTypeOrExtend dcterms_format;

	// getter/setter

	public LangString getDcterms_description()
	{
		return this.dcterms_description;
	}

	public void setDcterms_description( final LangString dcterms_description )
	{
		this.dcterms_description = dcterms_description;
	}

	public int getCaseQuantity()
	{
		return this.caseQuantity;
	}

	public void setCaseQuantity(final int caseQuantity)
	{
		this.caseQuantity = caseQuantity;
	}

	public String getOwl_versionInfo()
	{
		return this.owl_versionInfo;
	}

	public void setOwl_versionInfo(final String owl_versionInfo)
	{
		this.owl_versionInfo = owl_versionInfo;
	}

	public Set<Location> getDcterms_spatial()
	{
		return this.dcterms_spatial;
	}

	public void setDcterms_spatial( final Set<Location> dcterms_spatial )
	{
		this.dcterms_spatial = dcterms_spatial;
	}

	public DataFile addDcterms_spatial( final Location location )
	{
		if ( this.dcterms_spatial == null )
			this.dcterms_spatial = new HashSet<Location>();

		this.dcterms_spatial.add( location );

		return this;
	}

	public Set<PeriodOfTime> getDcterms_temporal()
	{
		return this.dcterms_temporal;
	}

	public void setDcterms_temporal( final Set<PeriodOfTime> dcterms_temporal )
	{
		this.dcterms_temporal = dcterms_temporal;
	}

	public DataFile addDcterms_temporal( final PeriodOfTime periodOfTime )
	{
		if ( this.dcterms_temporal == null )
			this.dcterms_temporal = new HashSet<PeriodOfTime>();

		this.dcterms_temporal.add( periodOfTime );

		return this;
	}

	public Set<Concept> getDcterms_subject()
	{
		return this.dcterms_subject;
	}

	public void setDcterms_subject( final Set<Concept> dcterms_subject )
	{
		this.dcterms_subject = dcterms_subject;
	}

	public DataFile addDcterms_subject( final Concept dcterms_subject )
	{
		if ( this.dcterms_subject == null )
			this.dcterms_subject = new HashSet<Concept>();

		this.dcterms_subject.add( dcterms_subject );

		return this;
	}

	public Set<ProvenanceStatement> getDcterms_provenance()
	{
		return this.dcterms_provenance;
	}

	public void setDcterms_provenance( final Set<ProvenanceStatement> dcterms_provenance )
	{
		this.dcterms_provenance = dcterms_provenance;
	}

	public DataFile addDcterms_provenance( final ProvenanceStatement provenanceStatement )
	{
		if ( this.dcterms_provenance == null )
			this.dcterms_provenance = new HashSet<ProvenanceStatement>();

		this.dcterms_provenance.add( provenanceStatement );

		return this;
	}

	public MediaTypeOrExtend getDcterms_format()
	{
		return this.dcterms_format;
	}

	public void setDcterms_format( final MediaTypeOrExtend dcterms_format )
	{
		this.dcterms_format = dcterms_format;
	}

}
