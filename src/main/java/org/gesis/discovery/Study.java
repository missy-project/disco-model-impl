package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.gesis.foaf.Agent;

/**
 * A Study represents the process by which a data set was generated or
 * collected.
 * 
 * <p>
 * A simple Study supports the stages of the full data lifecycle in a modular
 * manner. A Study represents the process by which a data set was generated or
 * collected. Literal properties include information about the funding,
 * organizational affiliation, abstract, title, version, and other such
 * high-level information. The key criteria for a study are: a single conceptual
 * model (e.g. survey research concept), a single instrument (e.g.
 * questionnaire) made up of one or more parts (ex. employer survey, worker
 * survey), and a single logical data structure of the initial raw data
 * (multiple data files can be created from this such as a public use microdata
 * file or aggregate data files). In some cases, where data collection is cyclic
 * or on-going, data sets may be released as a StudyGroup, where each cycle or
 * "wave" of the data collection activity produces one or more data sets. This
 * is typical for longitudinal studies, panel studies, and other types of
 * "series" (to use the DDI term). In this case, a number of Study objects would
 * be collected into a single StudyGroup.
 * </p>
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#study">Definition:
 *      Studies and StudyGroups</a>
 *
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Study extends Union_StudyGroupStudy
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	// relations

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "studyGroup_id" )
	private StudyGroup inGroup;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "study_id" )
	private List<Instrument> instrument;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_Variable",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	private List<Variable> variable;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_DataFile",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	private List<DataFile> dataFile;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_LogicalDataSet",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "logicalDataSet_id" ) )
	private List<LogicalDataSet> product;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_Publisher",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> publisher;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_Contributor",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> contributor;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_Creator",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> creator;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_FundedBy",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> fundedBy;

	// getter/setter

	/**
	 * @return The list of Instruments this Study uses to collect data.
	 * @see org.gesis.discovery.Instrument
	 * @see org.gesis.discovery.Questionnaire
	 */
	public List<Instrument> getInstrument()
	{
		return this.instrument;
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
	 * @return This Study object.
	 * @see #getInstrument()
	 */
	public Study setInstrument( final List<Instrument> instrument )
	{
		this.instrument = instrument;
		return this;
	}

	public Study addInstrument( final Instrument instrument )
	{
		if ( this.instrument == null )
			this.instrument = new ArrayList<Instrument>();

		this.instrument.add( instrument );

		return this;
	}

	/**
	 * @return The list of Variables this Study contains.
	 * @see org.gesis.discovery.Variable
	 */
	public List<Variable> getVariable()
	{
		return this.variable;
	}

	/**
	 * Corresponds to disco:variable. Sets the list of Variables for this Study. A
	 * variable might be the answer of a question, have an administrative source, or
	 * be derived from other variables.
	 * 
	 * @param variable
	 * @return This Study object.
	 * @see #getVariable()
	 */
	public Study setVariable( final List<Variable> variable )
	{
		this.variable = variable;
		return this;
	}

	public Study addVariable( final Variable variable )
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
	 * @see org.gesis.discovery.DataFile
	 * @see org.gesis.discovery.LogicalDataSet
	 */
	public List<DataFile> getDataFile()
	{
		return this.dataFile;
	}

	/**
	 * Corresponds to disco:dataFile. Data sets have a logical representation, which
	 * describes the contents of the data set, and a physical representation, which
	 * is a distributed file holding that data.
	 * 
	 * @param dataFile
	 * @return This Study object.
	 * @see #getDataFile()
	 */
	public Study setDataFile( final List<DataFile> dataFile )
	{
		this.dataFile = dataFile;
		return this;
	}

	public Study addDataFile( final DataFile dataFile )
	{
		if ( this.dataFile == null )
			this.dataFile = new ArrayList<DataFile>();

		this.dataFile.add( dataFile );

		return this;
	}

	/**
	 * @return The list of LogicalDataSets this Study uses to express logical
	 *         metadata.
	 * @see org.gesis.discovery.LogicalDataSet
	 */
	public List<LogicalDataSet> getProduct()
	{
		return this.product;
	}

	/**
	 * Corresponds to disco:product. Each Study has a set of logical metadata
	 * associated with the processing of data, at the time of collection or later
	 * during cleaning, and re-coding. LogicalDataSet represents the microdata
	 * dataset.
	 * 
	 * @param product
	 * @return This Study object.
	 * @see #getProduct()
	 */
	public Study setProduct( final List<LogicalDataSet> product )
	{
		this.product = product;
		return this;
	}

	public Study addProduct( final LogicalDataSet logicalDataSet )
	{
		if ( this.product == null )
			this.product = new ArrayList<LogicalDataSet>();

		this.product.add( logicalDataSet );

		return this;
	}

	/**
	 * @return The StudyGroup this Study is contained in.
	 */
	public StudyGroup getInGroup()
	{
		return this.inGroup;
	}

	/**
	 * Corresponds to disco:inGroup. Sets the StudyGroup which contains this Study.
	 * 
	 * @param inGroup
	 * @return This Study object.
	 * @see #getInGroup()
	 */
	public Study setInGroup( final StudyGroup inGroup )
	{
		this.inGroup = inGroup;
		return this;
	}

	/**
	 * @return The list of Agents of this Study functioning as publishers.
	 * @see org.gesis.foaf.Agent
	 */
	public List<Agent> getPublisher()
	{
		return publisher;
	}

	/**
	 * Corresponds to dcterms:publisher. Creators, contributors, and publishers of
	 * Studies and groups of studies (StudyGroup) are foaf:Agents, which are either
	 * foaf:Persons or org:Organizations whose members are foaf:Persons.
	 * 
	 * @param publisher
	 * @return This Study object.
	 * @see #getPublisher()
	 */
	public Study setPublisher( final List<Agent> publisher )
	{
		this.publisher = publisher;
		return this;
	}

	public Union_StudyGroupStudy addPublisher( final Agent agent )
	{
		if ( publisher == null )
			publisher = new ArrayList<Agent>();

		publisher.add( agent );

		return this;
	}

	/**
	 * @return The list of Agents of this Study functioning as contributors.
	 * @see org.gesis.foaf.Agent
	 */
	public List<Agent> getContributor()
	{
		return contributor;
	}

	/**
	 * Corresponds to dcterms:contributor. Creators, contributors, and publishers of
	 * Studies and groups of studies (StudyGroup) are foaf:Agents, which are either
	 * foaf:Persons or org:Organizations whose members are foaf:Persons.
	 * 
	 * @param contributor
	 * @return This Study object.
	 * @see #getContributor()
	 */
	public Study setContributor( final List<Agent> contributor )
	{
		this.contributor = contributor;
		return this;
	}

	public Union_StudyGroupStudy addContributor( final Agent agent )
	{
		if ( contributor == null )
			contributor = new ArrayList<Agent>();

		contributor.add( agent );

		return this;
	}

	/**
	 * @return The list of Agents of this Study functioning as creators.
	 * @see org.gesis.foaf.Agent
	 */
	public List<Agent> getCreator()
	{
		return creator;
	}

	/**
	 * Corresponds to dcterms:creator. Creators, contributors, and publishers of
	 * Studies and groups of studies (StudyGroup) are foaf:Agents, which are either
	 * foaf:Persons or org:Organizations whose members are foaf:Persons.
	 * 
	 * @param creator
	 * @return This Study object.
	 * @see #getCreator()
	 */
	public Study setCreator( final List<Agent> creator )
	{
		this.creator = creator;
		return this;
	}

	public Union_StudyGroupStudy addCreator( final Agent agent )
	{
		if ( creator == null )
			creator = new ArrayList<Agent>();

		creator.add( agent );

		return this;
	}

	/**
	 * @return The list of Agents of this Study functioning as contributors that
	 *         funded this Study.
	 * @see org.gesis.foaf.Agent
	 */
	public List<Agent> getFundedBy()
	{
		return fundedBy;
	}

	/**
	 * Corresponds to disco:fundedBy. Studies or groups of studies (StudyGroup) may
	 * be funded by foaf:Agents. The object property fundedBy is defined as
	 * sub-property of dcterms:contributor.
	 * 
	 * @param fundedBy
	 * @return This Study object.
	 * @see #getFundedBy()
	 */
	public Study setFundedBy( final List<Agent> fundedBy )
	{
		this.fundedBy = fundedBy;
		return this;
	}

	public Union_StudyGroupStudy addFundedBy( final Agent agent )
	{
		if ( fundedBy == null )
			fundedBy = new ArrayList<Agent>();

		fundedBy.add( agent );

		return this;
	}

}
