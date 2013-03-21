package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "CategoryStatistics_Concept", 
			joinColumns = @JoinColumn( name = "categoryStatistics_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> statisticsCategory;

	// getter/setter

	public CategoryStatistics( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public int getFrequency()
	{
		return frequency;
	}

	public void setFrequency(int frequency)
	{
		this.frequency = frequency;
	}

	public int getWeightFrequency()
	{
		return weightedFrequency;
	}

	public void setWeightFrequency(int weightFrequency)
	{
		this.weightedFrequency = weightFrequency;
	}

	public double getCumulativePercentage()
	{
		return cumulativePercentage;
	}

	public void setCumulativePercentage(double cumulativePercentage)
	{
		this.cumulativePercentage = cumulativePercentage;
	}

	public double getWeightedCumulativePercentage()
	{
		return weightedCumulativePercentage;
	}

	public void setWeightedCumulativePercentage(double weightedCumulativePercentage)
	{
		this.weightedCumulativePercentage = weightedCumulativePercentage;
	}

	public double getPercentage()
	{
		return percentage;
	}

	public void setPercentage(double percentage)
	{
		this.percentage = percentage;
	}

	public double getWeightedPercentage()
	{
		return weightedPercentage;
	}

	public void setWeightedPercentage(double weightedPercentage)
	{
		this.weightedPercentage = weightedPercentage;
	}

	public Set<Concept> getStatisticsCategory()
	{
		return this.statisticsCategory;
	}

	public void setStatisticsCategory(Set<Concept> categories)
	{
		this.statisticsCategory = categories;
	}

}