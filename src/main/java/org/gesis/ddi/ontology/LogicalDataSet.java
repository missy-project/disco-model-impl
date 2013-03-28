package org.gesis.ddi.ontology;

import java.util.HashSet;
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

import org.gesis.datacube.DataSet;
import org.gesis.dcterms.LicenseDocument;
import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.dcterms.RightsStatement;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class LogicalDataSet extends Resource
{

	// properties

	@OneToOne
	private LangString dcterms_title;

	@Column
	private int isPublic;

	// relations

	@ElementCollection
	@JoinTable( 
			name = "LogicalDataSet_Location", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	protected Set<Location> dcterms_spatial;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_PeriodOfTime", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	protected Set<PeriodOfTime> dcterms_temporal;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_Concept", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> dcterms_subject;

	@ManyToOne
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name = "LogicalDataSet_Instrument", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "instrument_id" ) )
	protected Set<Instrument> instrument;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_Variable", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected Set<Variable> containsVariable;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_DataFile", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected Set<DataFile> dataFile;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_DataSet", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataSet_id" ) )
	protected Set<DataSet> aggregation;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_LicenseDocument",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "licenseDocument_id" ) )
	protected Set<LicenseDocument> dcterms_license;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_Document", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "rightsStatement_id" ) )
	protected Set<RightsStatement> dcterms_accessRights;

	// getter/setter

	public LogicalDataSet( final String agencyId, final String objectId, final int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public LangString getDcterms_title()
	{
		return this.dcterms_title;
	}

	public void setDcterms_title( final LangString dcterms_title )
	{
		this.dcterms_title = dcterms_title;
	}

	public int isPublic()
	{
		return this.isPublic;
	}

	public void setPublic(final int isPublic)
	{
		this.isPublic = isPublic;
	}

	public Universe getDataSetUniverse()
	{
		return this.universe;
	}

	public void setDataSetUniverse(final Universe dataSetUniverse)
	{
		this.universe = dataSetUniverse;
	}

	public Set<Location> getDcterms_spatial()
	{
		return this.dcterms_spatial;
	}

	public void setDcterms_spatial( final Set<Location> dcterms_spatial )
	{
		this.dcterms_spatial = dcterms_spatial;
	}

	public LogicalDataSet addDcterms_spatial( final Location location )
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

	public LogicalDataSet addDcterms_temporal( final PeriodOfTime periodOfTime )
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

	public LogicalDataSet addDcterms_subject( final Concept concept )
	{
		if ( this.dcterms_subject == null )
			this.dcterms_subject = new HashSet<Concept>();

		this.dcterms_subject.add( concept );

		return this;
	}

	public Set<Instrument> getInstrument()
	{
		return this.instrument;
	}

	public void setInstrument( final Set<Instrument> instrument )
	{
		this.instrument = instrument;
	}

	public LogicalDataSet addInstrument( final Instrument instrument )
	{
		if ( this.instrument == null )
			this.instrument = new HashSet<Instrument>();

		this.instrument.add( instrument );

		return this;
	}

	public Set<Variable> getContainsVariable()
	{
		return this.containsVariable;
	}

	public void setContainsVariable( final Set<Variable> containsVariable )
	{
		this.containsVariable = containsVariable;
	}

	public LogicalDataSet addContainsVariable( final Variable variable )
	{
		if ( this.containsVariable == null )
			this.containsVariable = new HashSet<Variable>();

		this.containsVariable.add( variable );

		return this;
	}

	public Set<DataFile> getDataFile()
	{
		return this.dataFile;
	}

	public void setDataFile( final Set<DataFile> dataFile )
	{
		this.dataFile = dataFile;
	}

	public LogicalDataSet addDataFile( final DataFile dataFile )
	{
		if ( this.dataFile == null )
			this.dataFile = new HashSet<DataFile>();

		this.dataFile.add( dataFile );

		return this;
	}

	public Set<DataSet> getAggregation()
	{
		return this.aggregation;
	}

	public void setAggregation( final Set<DataSet> aggregation )
	{
		this.aggregation = aggregation;
	}

	public LogicalDataSet addAggregation( final DataSet dataSet )
	{
		if ( this.aggregation == null )
			this.aggregation = new HashSet<DataSet>();

		this.aggregation.add( dataSet );

		return this;
	}

	public Set<LicenseDocument> getDcterms_license()
	{
		return this.dcterms_license;
	}

	public void setDcterms_license( final Set<LicenseDocument> dcterms_license )
	{
		this.dcterms_license = dcterms_license;
	}

	public LogicalDataSet addDcterms_license( final LicenseDocument licenseDocument )
	{
		if ( this.dcterms_license == null )
			this.dcterms_license = new HashSet<LicenseDocument>();

		this.dcterms_license.add( licenseDocument );

		return this;
	}

	public Set<RightsStatement> getDcterms_accessRights()
	{
		return this.dcterms_accessRights;
	}

	public void setDcterms_accessRights( final Set<RightsStatement> dcterms_accessRights )
	{
		this.dcterms_accessRights = dcterms_accessRights;
	}

	public LogicalDataSet addDcterms_accessRights( final RightsStatement rightsStatement )
	{
		if ( this.dcterms_accessRights == null )
			this.dcterms_accessRights = new HashSet<RightsStatement>();

		this.dcterms_accessRights.add( rightsStatement );

		return this;
	}

	public void setDataCube(final Set<DataSet> dataCube)
	{
		this.aggregation = dataCube;
	}

	public LogicalDataSet addDataCube( final DataSet dataCube )
	{
		if ( this.aggregation == null )
			this.aggregation = new HashSet<DataSet>();

		this.aggregation.add( dataCube );

		return this;
	}

}