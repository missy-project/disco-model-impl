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

/**
 * Each study has a set of logical metadata associated with the processing of
 * data, at the time of collection or later during cleaning, and re-coding.
 * LogicalDataSet represents the microdata dataset.
 * 
 * <p>
 * You can state a title (dcterms:title) and a flag indicating if the microdata
 * dataset is publicly available (isPublic). You can specify access rights
 * (dcterms:accessRights) and LicenseStatements (dcterms:license) for microdata
 * datasets. For a LogicalDataSet the three dimensions of coverage can be
 * specified: Spatial (dcterms:spatial), temporal (dcterms:temporal), and
 * topical (dcterms:subject).
 * </p>
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#logicaldataset}
 * @see {@link DataFile}
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class LogicalDataSet extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString title;

	@Column( columnDefinition = "bit default 0" )
	private boolean isPublic = false;

	@Column
	private int variableQuantity;

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
	protected List<Variable> variable;

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

	/**
	 * @return The title of this LogicalDataSet.
	 */
	public LangString getTitle()
	{
		return title;
	}

	/**
	 * Corresponds to dcterms:title
	 * 
	 * @param title
	 * @return This LogicalDataSet object.
	 * @see {@link getTitle()}
	 */
	public LogicalDataSet setTitle( final LangString title )
	{
		this.title = title;
		return this;
	}

	/**
	 * A flag indicating if the microdata dataset is publicly available.
	 * 
	 * @return
	 */
	public boolean isPublic()
	{
		return isPublic;
	}

	/**
	 * A flag indicating if the microdata dataset is publicly available.
	 * 
	 * @param isPublic
	 * @return This LogicalDataSet object.
	 * @see {@link isPublic()}
	 */
	public LogicalDataSet setPublic( final boolean isPublic )
	{
		this.isPublic = isPublic;
		return this;
	}

	/**
	 * @return The variable quantity of this LogicalDataSet.
	 * @see {@link DataFile}
	 */
	public int getVariableQuantity()
	{
		return variableQuantity;
	}

	/**
	 * Corresponds to disco:variableQuantity. Just like there is caseQuantity on the
	 * {@link DataFile} there is also variableQuantity on this LogicalDataSet. This
	 * is useful to have when (1) no variable level information is available and
	 * when (2) only a stub of the RDF is requested e.g when returning basic
	 * information on a study of file, we do not need to return information on
	 * potentially hundreds or thousands of variables references or metadata.
	 * 
	 * @param variableQuantity
	 * @return This LogicalDataSet object.
	 * @see {@link getVariableQuantity()}
	 */
	public LogicalDataSet setVariableQuantity( int variableQuantity )
	{
		this.variableQuantity = variableQuantity;
		return this;
	}

	/**
	 * @return The Universe of this LogicalDataSet.
	 * @see {@link Universe}
	 */
	public Universe getUniverse()
	{
		return universe;
	}

	/**
	 * Sets the Universe for this LogicalDataSet. Any universe of a microdata
	 * dataset is a subset of the Universe of the entire {@link Study}.
	 * 
	 * @param universe
	 * @return This LogicalDataSet object.
	 * @see {@link getUniverse()}
	 */
	public LogicalDataSet setUniverse( final Universe universe )
	{
		this.universe = universe;
		return this;
	}

	/**
	 * @return The list of spatial coverages (Location) of this microdata dataset.
	 * @see {@link Location}
	 */
	public List<Location> getSpatial()
	{
		return spatial;
	}

	/**
	 * Corresponds to dcterms:spatial. For a LogicalDataSet the three dimensions of
	 * coverage can be specified: Spatial (dcterms:spatial), temporal
	 * (dcterms:temporal), and topical (dcterms:subject).
	 * 
	 * @param spatial
	 * @return This LogicalDataSet object.
	 * @see {@link getSpatial()}
	 */
	public LogicalDataSet setSpatial( final List<Location> spatial )
	{
		this.spatial = spatial;
		return this;
	}

	public LogicalDataSet addSpatial( final Location location )
	{
		if ( spatial == null )
			spatial = new ArrayList<Location>();

		spatial.add( location );

		return this;
	}

	/**
	 * @return The list of temporal coverages (PeriodOfTime) of this microdata
	 *         dataset.
	 * @see {@link PeriodOfTime}
	 */
	public List<PeriodOfTime> getTemporal()
	{
		return temporal;
	}

	/**
	 * Corresponds to dcterms:temporal. For a LogicalDataSet the three dimensions of
	 * coverage can be specified: Spatial (dcterms:spatial), temporal
	 * (dcterms:temporal), and topical (dcterms:subject).
	 * 
	 * @param temporal
	 * @return This LogicalDataSet object.
	 * @see {@link getTemporal()}
	 */
	public LogicalDataSet setTemporal( final List<PeriodOfTime> temporal )
	{
		this.temporal = temporal;
		return this;
	}

	public LogicalDataSet addTemporal( final PeriodOfTime periodOfTime )
	{
		if ( temporal == null )
			temporal = new ArrayList<PeriodOfTime>();

		temporal.add( periodOfTime );

		return this;
	}

	/**
	 * @return The list of topical coverages (Concept) of this microdata dataset.
	 * @see {@link Concept}
	 */
	public List<Concept> getSubject()
	{
		return subject;
	}

	/**
	 * Corresponds to dcterms:subject. For a LogicalDataSet the three dimensions of
	 * coverage can be specified: Spatial (dcterms:spatial), temporal
	 * (dcterms:temporal), and topical (dcterms:subject).
	 * 
	 * @param subject
	 * @return This LogicalDataSet object.
	 * @see {@link getSubject()}
	 */
	public LogicalDataSet setSubject( final List<Concept> subject )
	{
		this.subject = subject;
		return this;
	}

	public LogicalDataSet addSubject( final Concept concept )
	{
		if ( subject == null )
			subject = new ArrayList<Concept>();

		subject.add( concept );

		return this;
	}

	/**
	 * @return The list of {@link Instrument}s this Study uses to collect data.
	 * @see {@link Instrument}
	 * @see {@link Questionnaire}
	 */
	public List<Instrument> getInstrument()
	{
		return instrument;
	}

	/**
	 * Corresponds to disco:instrument. The data for the study are collected by one
	 * or more {@link Instrument}s. The purpose of an Instrument, i.e. an interview,
	 * a {@link Questionnaire} or another entity used as a means of data collection,
	 * is in the case of a survey to record the flow of a questionnaire, its use of
	 * questions, and additional component parts. A questionnaire contains a flow of
	 * questions.
	 * 
	 * @param instrument
	 * @return This LogicalDataSet object.
	 * @see {@link getInstrument()}
	 */
	public LogicalDataSet setInstrument( final List<Instrument> instrument )
	{
		this.instrument = instrument;
		return this;
	}

	public LogicalDataSet addInstrument( final Instrument instrument )
	{
		if ( this.instrument == null )
			this.instrument = new ArrayList<Instrument>();

		this.instrument.add( instrument );

		return this;
	}

	/**
	 * @return The list of Variables this microdata dataset contains.
	 * @see {@link Variable}
	 */
	public List<Variable> getVariable()
	{
		return variable;
	}

	/**
	 * Corresponds to disco:variable. Sets the list of Variables for this microdata
	 * dataset. A variable might be the answer of a question, have an administrative
	 * source, or be derived from other variables.
	 * 
	 * @param variable
	 * @return This LogicalDataSet object.
	 * @see {@link getVariable()}
	 */
	public void setVariable( final List<Variable> variables )
	{
		this.variable = variables;
	}

	public LogicalDataSet addContainsVariable( final Variable variable )
	{
		if ( this.variable == null )
			this.variable = new ArrayList<Variable>();

		this.variable.add( variable );

		return this;
	}

	/**
	 * The collected data result in the microdata represented by the DataFile.
	 * 
	 * @return The list of DataFiles to represent results of this Study.
	 * @see {@link DataFile}
	 * @see {@link Study}
	 */
	public List<DataFile> getDataFile()
	{
		return dataFile;
	}

	/**
	 * Corresponds to disco:DataFile. A DataFile represents the physical data
	 * storage of the microdata datasets.
	 * 
	 * @param dataFile
	 * @return This LogicalDataSet object.
	 * @see {@link getDataFile()}
	 */
	public LogicalDataSet setDataFile( final List<DataFile> dataFile )
	{
		this.dataFile = dataFile;
		return this;
	}

	public LogicalDataSet addDataFile( final DataFile dataFile )
	{
		if ( this.dataFile == null )
			this.dataFile = new ArrayList<DataFile>();

		this.dataFile.add( dataFile );

		return this;
	}

	/**
	 * @return The list of derived cube datasets from this microdata dataset.
	 * @see {@link DataSet}
	 */
	public List<DataSet> getAggregation()
	{
		return aggregation;
	}

	/**
	 * Corresponds to disco:aggregation. Disco contains this property to indicate
	 * that a cube dataset (from RDF Data Cube Vocabulary) was derived by tabulating
	 * a record-level dataset.
	 * 
	 * @param aggregation
	 * @return This LogicalDataSet object.
	 * @see {@link getAggregation()}
	 */
	public LogicalDataSet setAggregation( final List<DataSet> aggregation )
	{
		this.aggregation = aggregation;
		return this;
	}

	public LogicalDataSet addAggregation( final DataSet dataSet )
	{
		if ( aggregation == null )
			aggregation = new ArrayList<DataSet>();

		aggregation.add( dataSet );

		return this;
	}

	/**
	 * @return The list of LicenseDocuments this logical dataset has attached.
	 * @see {@link LicenseDocument}
	 * @see {@link AccessRights}
	 */
	public List<LicenseDocument> getLicense()
	{
		return license;
	}

	/**
	 * Every logical dataset may have access rights statements and licensing
	 * information attached to it. For those purposes, the Dublin Core properties
	 * dcterms:accessRights and dcterms:license are used.
	 * 
	 * @param license
	 * @return This LogicalDataSet object.
	 * @see {@link getLicense()}
	 * @see {@link getAccessRights()}
	 */
	public LogicalDataSet setLicense( final List<LicenseDocument> license )
	{
		this.license = license;
		return this;
	}

	public LogicalDataSet addLicense( final LicenseDocument licenseDocument )
	{
		if ( license == null )
			license = new ArrayList<LicenseDocument>();

		license.add( licenseDocument );

		return this;
	}

	/**
	 * @return The list of RightsStatements this logical dataset has attached.
	 * @see {@link RightsStatement}
	 * @see {@link LicenseDocument}
	 */
	public List<RightsStatement> getAccessRights()
	{
		return accessRights;
	}

	/**
	 * Every logical dataset may have access rights statements and licensing
	 * information attached to it. For those purposes, the Dublin Core properties
	 * dcterms:accessRights and dcterms:license are used.
	 * 
	 * @param accessRights
	 * @return
	 */
	public LogicalDataSet setAccessRights( final List<RightsStatement> accessRights )
	{
		this.accessRights = accessRights;
		return this;
	}

	public LogicalDataSet addAccessRights( final RightsStatement rightsStatement )
	{
		if ( accessRights == null )
			accessRights = new ArrayList<RightsStatement>();

		accessRights.add( rightsStatement );

		return this;
	}

}