package org.gesis.discovery;

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
	private LangString description;

	@Column
	private int caseQuantity;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_ProvenanceStatement",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "provenanceStatement_id" ) )
	private Set<ProvenanceStatement> provenance;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_Location",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	protected Set<Location> spatial;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_PeriodOfTime",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	protected Set<PeriodOfTime> temporal;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_Concept",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> subject;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "mediaTypeOrExtend_id" )
	protected MediaTypeOrExtend format;

	// getter/setter

	public LangString getDescription()
	{
		return description;
	}

	public void setDescription( final LangString description )
	{
		this.description = description;
	}

	public int getCaseQuantity()
	{
		return caseQuantity;
	}

	public void setCaseQuantity(final int caseQuantity)
	{
		this.caseQuantity = caseQuantity;
	}

	public Set<Location> getSpatial()
	{
		return spatial;
	}

	public void setSpatial( final Set<Location> spatial )
	{
		this.spatial = spatial;
	}

	public DataFile addSpatial( final Location location )
	{
		if ( spatial == null )
			spatial = new HashSet<Location>();

		spatial.add( location );

		return this;
	}

	public Set<PeriodOfTime> getTemporal()
	{
		return temporal;
	}

	public void setTemporal( final Set<PeriodOfTime> temporal )
	{
		this.temporal = temporal;
	}

	public DataFile addTemporal( final PeriodOfTime periodOfTime )
	{
		if ( temporal == null )
			temporal = new HashSet<PeriodOfTime>();

		temporal.add( periodOfTime );

		return this;
	}

	public Set<Concept> getSubject()
	{
		return subject;
	}

	public void setSubject( final Set<Concept> subject )
	{
		this.subject = subject;
	}

	public DataFile addSubject( final Concept concept )
	{
		if ( subject == null )
			subject = new HashSet<Concept>();

		subject.add( concept );

		return this;
	}

	public Set<ProvenanceStatement> getProvenance()
	{
		return provenance;
	}

	public void setProvenance( final Set<ProvenanceStatement> provenance )
	{
		this.provenance = provenance;
	}

	public DataFile addProvenance( final ProvenanceStatement provenanceStatement )
	{
		if ( provenance == null )
			provenance = new HashSet<ProvenanceStatement>();

		provenance.add( provenanceStatement );

		return this;
	}

	public MediaTypeOrExtend getFormat()
	{
		return format;
	}

	public void setFormat( final MediaTypeOrExtend format )
	{
		this.format = format;
	}

}
