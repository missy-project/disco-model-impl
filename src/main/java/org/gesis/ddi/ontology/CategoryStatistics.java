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

import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class CategoryStatistics extends DescriptiveStatistics
{

	// properties

	@Column
	private int frequency;

	@Column
	private int weightedFrequency;

	@Column
	private double cumulativePercentage;

	@Column
	private double weightedCumulativePercentage;

	@Column
	private double percentage;

	@Column
	private double weightedPercentage;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "CategoryStatistics_Concept", 
			joinColumns = @JoinColumn( name = "categoryStatistics_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> statisticsCategory;

	// getter/setter

	public int getFrequency()
	{
		return this.frequency;
	}

	public void setFrequency(final int frequency)
	{
		this.frequency = frequency;
	}

	public int getWeightFrequency()
	{
		return this.weightedFrequency;
	}

	public void setWeightFrequency(final int weightFrequency)
	{
		this.weightedFrequency = weightFrequency;
	}

	public double getCumulativePercentage()
	{
		return this.cumulativePercentage;
	}

	public void setCumulativePercentage(final double cumulativePercentage)
	{
		this.cumulativePercentage = cumulativePercentage;
	}

	public double getWeightedCumulativePercentage()
	{
		return this.weightedCumulativePercentage;
	}

	public void setWeightedCumulativePercentage(final double weightedCumulativePercentage)
	{
		this.weightedCumulativePercentage = weightedCumulativePercentage;
	}

	public double getPercentage()
	{
		return this.percentage;
	}

	public void setPercentage(final double percentage)
	{
		this.percentage = percentage;
	}

	public double getWeightedPercentage()
	{
		return this.weightedPercentage;
	}

	public void setWeightedPercentage(final double weightedPercentage)
	{
		this.weightedPercentage = weightedPercentage;
	}

	public Set<Concept> getStatisticsCategory()
	{
		return this.statisticsCategory;
	}

	public void setStatisticsCategory(final Set<Concept> categories)
	{
		this.statisticsCategory = categories;
	}

	public CategoryStatistics addStatisticsCategory( final Concept category )
	{
		if ( this.statisticsCategory == null )
			this.statisticsCategory = new HashSet<Concept>();

		this.statisticsCategory.add( category );

		return this;
	}

}