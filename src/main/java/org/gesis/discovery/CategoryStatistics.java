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

import org.gesis.rdf.LangString;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class CategoryStatistics extends DescriptiveStatistics
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@Column
	private int frequency = -1;

	@Column
	private double cumulativePercentage = -1;

	@Column
	private double percentage = -1;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString computationBase;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "CategoryStatistics_Concept",
			joinColumns = @JoinColumn( name = "categoryStatistics_id" ),
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected List<Concept> statisticsCategory;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "variable_id" )
	protected Variable weightedBy;

	// getter/setter

	public int getFrequency()
	{
		return frequency;
	}

	public void setFrequency( final int frequency )
	{
		this.frequency = frequency;
	}

	public double getCumulativePercentage()
	{
		return cumulativePercentage;
	}

	public void setCumulativePercentage( final double cumulativePercentage )
	{
		this.cumulativePercentage = cumulativePercentage;
	}

	public double getPercentage()
	{
		return percentage;
	}

	public void setPercentage( final double percentage )
	{
		this.percentage = percentage;
	}

	public LangString getComputationBase()
	{
		return computationBase;
	}

	public void setComputationBase( final LangString computationBase )
	{
		this.computationBase = computationBase;
	}

	public List<Concept> getStatisticsCategory()
	{
		return statisticsCategory;
	}

	public void setStatisticsCategory( final List<Concept> categories )
	{
		statisticsCategory = categories;
	}

	public CategoryStatistics addStatisticsCategory( final Concept category )
	{
		if ( statisticsCategory == null )
			statisticsCategory = new ArrayList<Concept>();

		statisticsCategory.add( category );

		return this;
	}

	public Variable getWeightedBy()
	{
		return weightedBy;
	}

	public void setWeightedBy( final Variable weightedBy )
	{
		this.weightedBy = weightedBy;
	}

}