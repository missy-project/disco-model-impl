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
import javax.persistence.OneToMany;

import org.gesis.foaf.Agent;

/**
 * In some cases, where data collection is cyclic or on-going, data sets may be
 * released as a StudyGroup, where each cycle or wave of the data collection
 * activity produces one or more data sets. This is typical for longitudinal
 * studies, panel studies, and other types of series (to use the DDI term). In
 * this case, a number of objects would be collected into a single StudyGroup.
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#study">Definition:
 *      Studies and StudyGroups</a>
 * @see org.gesis.discovery.Study
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class StudyGroup extends Union_StudyGroupStudy
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// relations

	@OneToMany( mappedBy = "inGroup" )
	private List<Study> studies;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "StudyGroup_Publisher",
			joinColumns = @JoinColumn( name = "studyGroup_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> publisher;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "StudyGroup_Contributor",
			joinColumns = @JoinColumn( name = "studyGroup_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> contributor;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "StudyGroup_Creator",
			joinColumns = @JoinColumn( name = "studyGroup_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> creator;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "StudyGroup_FundedBy",
			joinColumns = @JoinColumn( name = "studyGroup_id" ),
			inverseJoinColumns = @JoinColumn( name = "agent_id" ) )
	private List<Agent> fundedBy;

	// getter / setter

	/**
	 * @return The list of Studies this StudyGroup contains, where each cycle or
	 *         "wave" of the data collection activity produces one or more data sets
	 */
	public List<Study> getStudies()
	{
		return studies;
	}

	/**
	 * A Study represents the process by which a data set was generated or
	 * collected. In some cases, where data collection is cyclic or on-going,
	 * several data sets may be released in one StudyGroup, where each cycle or
	 * "wave" of the data collection activity produces one or more data sets.
	 * 
	 * @param studies
	 * @return This StudyGroup object.
	 * @see #getStudies()
	 */
	public StudyGroup setStudies( final List<Study> studies )
	{
		this.studies = studies;
		return this;
	}

	/**
	 * @return The list of Agents of this StudyGroup.
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
	 * @return This StudyGroup object.
	 * @see #getPublisher()
	 */
	public StudyGroup setPublisher( final List<Agent> publisher )
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
	 * @return The list of Agents of this StudyGroup functioning as contributors.
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
	 * @return This StudyGroup object.
	 * @see #getContributor()
	 */
	public StudyGroup setContributor( final List<Agent> contributor )
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
	 * @return The list of Agents of this StudyGroup functioning as creators.
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
	 * @return This StudyGroup object.
	 * @see #getCreator()
	 */
	public StudyGroup setCreator( final List<Agent> creator )
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
	 * @return The list of Agents of this StudyGroup functioning as contributors
	 *         that funded this StudyGroup.
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
	 * @return This StudyGroup object.
	 * @see #getFundedBy()
	 */
	public StudyGroup setFundedBy( final List<Agent> fundedBy )
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
