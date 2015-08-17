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

	public List<Study> getStudies()
	{
		return studies;
	}

	public void setStudies( final List<Study> studies )
	{
		this.studies = studies;
	}

	public List<Agent> getPublisher()
	{
		return publisher;
	}

	public void setPublisher( final List<Agent> publisher )
	{
		this.publisher = publisher;
	}

	public Union_StudyGroupStudy addPublisher( final Agent agent )
	{
		if ( publisher == null )
			publisher = new ArrayList<Agent>();

		publisher.add( agent );

		return this;
	}

	public List<Agent> getContributor()
	{
		return contributor;
	}

	public void setContributor( final List<Agent> contributor )
	{
		this.contributor = contributor;
	}

	public Union_StudyGroupStudy addContributor( final Agent agent )
	{
		if ( contributor == null )
			contributor = new ArrayList<Agent>();

		contributor.add( agent );

		return this;
	}

	public List<Agent> getCreator()
	{
		return creator;
	}

	public void setCreator( final List<Agent> creator )
	{
		this.creator = creator;
	}

	public Union_StudyGroupStudy addCreator( final Agent agent )
	{
		if ( creator == null )
			creator = new ArrayList<Agent>();

		creator.add( agent );

		return this;
	}

	public List<Agent> getFundedBy()
	{
		return fundedBy;
	}

	public void setFundedBy( final List<Agent> fundedBy )
	{
		this.fundedBy = fundedBy;
	}

	public Union_StudyGroupStudy addFundedBy( final Agent agent )
	{
		if ( fundedBy == null )
			fundedBy = new ArrayList<Agent>();

		fundedBy.add( agent );

		return this;
	}
}
