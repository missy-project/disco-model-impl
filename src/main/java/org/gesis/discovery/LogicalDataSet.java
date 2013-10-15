package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

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

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString title;

	@Column( columnDefinition = "bit default 0" )
	private boolean isPublic;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_Location",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	protected List<Location> spatial;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_PeriodOfTime",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	protected List<PeriodOfTime> temporal;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_Concept",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected List<Concept> subject;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_Instrument",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "instrument_id" ) )
	protected List<Instrument> instrument;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_Variable",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected List<Variable> containsVariable;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_DataFile",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected List<DataFile> dataFile;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_DataSet",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "dataSet_id" ) )
	protected List<DataSet> aggregation;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_LicenseDocument",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "licenseDocument_id" ) )
	protected List<LicenseDocument> license;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "LogicalDataSet_Document",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "rightsStatement_id" ) )
	protected List<RightsStatement> accessRights;

	// getter/setter

	public LangString getTitle()
	{
		return title;
	}

	public void setTitle( final LangString dcterms_title )
	{
		title = dcterms_title;
	}

	public boolean isPublic()
	{
		return isPublic;
	}

	public void setPublic( final boolean isPublic )
	{
		this.isPublic = isPublic;
	}

	public Universe getUniverse()
	{
		return universe;
	}

	public void setUniverse( final Universe universe )
	{
		this.universe = universe;
	}

	public List<Location> getSpatial()
	{
		return spatial;
	}

	public void setSpatial( final List<Location> dcterms_spatial )
	{
		spatial = dcterms_spatial;
	}

	public LogicalDataSet addSpatial( final Location location )
	{
		if ( spatial == null )
			spatial = new ArrayList<Location>();

		spatial.add( location );

		return this;
	}

	public List<PeriodOfTime> getTemporal()
	{
		return temporal;
	}

	public void setTemporal( final List<PeriodOfTime> dcterms_temporal )
	{
		temporal = dcterms_temporal;
	}

	public LogicalDataSet addTemporal( final PeriodOfTime periodOfTime )
	{
		if ( temporal == null )
			temporal = new ArrayList<PeriodOfTime>();

		temporal.add( periodOfTime );

		return this;
	}

	public List<Concept> getSubject()
	{
		return subject;
	}

	public void setSubject( final List<Concept> dcterms_subject )
	{
		subject = dcterms_subject;
	}

	public LogicalDataSet addSubject( final Concept concept )
	{
		if ( subject == null )
			subject = new ArrayList<Concept>();

		subject.add( concept );

		return this;
	}

	public List<Instrument> getInstrument()
	{
		return instrument;
	}

	public void setInstrument( final List<Instrument> instrument )
	{
		this.instrument = instrument;
	}

	public LogicalDataSet addInstrument( final Instrument instrument )
	{
		if ( this.instrument == null )
			this.instrument = new ArrayList<Instrument>();

		this.instrument.add( instrument );

		return this;
	}

	public List<Variable> getContainsVariable()
	{
		return containsVariable;
	}

	public void setContainsVariable( final List<Variable> containsVariable )
	{
		this.containsVariable = containsVariable;
	}

	public LogicalDataSet addContainsVariable( final Variable variable )
	{
		if ( containsVariable == null )
			containsVariable = new ArrayList<Variable>();

		containsVariable.add( variable );

		return this;
	}

	public List<DataFile> getDataFile()
	{
		return dataFile;
	}

	public void setDataFile( final List<DataFile> dataFile )
	{
		this.dataFile = dataFile;
	}

	public LogicalDataSet addDataFile( final DataFile dataFile )
	{
		if ( this.dataFile == null )
			this.dataFile = new ArrayList<DataFile>();

		this.dataFile.add( dataFile );

		return this;
	}

	public List<DataSet> getAggregation()
	{
		return aggregation;
	}

	public void setAggregation( final List<DataSet> aggregation )
	{
		this.aggregation = aggregation;
	}

	public LogicalDataSet addAggregation( final DataSet dataSet )
	{
		if ( aggregation == null )
			aggregation = new ArrayList<DataSet>();

		aggregation.add( dataSet );

		return this;
	}

	public List<LicenseDocument> getLicense()
	{
		return license;
	}

	public void setLicense( final List<LicenseDocument> dcterms_license )
	{
		license = dcterms_license;
	}

	public LogicalDataSet addLicense( final LicenseDocument licenseDocument )
	{
		if ( license == null )
			license = new ArrayList<LicenseDocument>();

		license.add( licenseDocument );

		return this;
	}

	public List<RightsStatement> getAccessRights()
	{
		return accessRights;
	}

	public void setAccessRights( final List<RightsStatement> dcterms_accessRights )
	{
		accessRights = dcterms_accessRights;
	}

	public LogicalDataSet addAccessRights( final RightsStatement rightsStatement )
	{
		if ( accessRights == null )
			accessRights = new ArrayList<RightsStatement>();

		accessRights.add( rightsStatement );

		return this;
	}

	public void setDataCube( final List<DataSet> dataCube )
	{
		aggregation = dataCube;
	}

	public LogicalDataSet addDataCube( final DataSet dataCube )
	{
		if ( aggregation == null )
			aggregation = new ArrayList<DataSet>();

		aggregation.add( dataCube );

		return this;
	}

}