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

import org.gesis.rdf.LangString;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class CategoryStatistics extends DescriptiveStatistics
{

	// properties

	@Column
	private int frequency;

	@Column
	private double cumulativePercentage;

	@Column
	private double percentage;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString typeOfCases;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "CategoryStatistics_Concept", 
			joinColumns = @JoinColumn( name = "categoryStatistics_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> statisticsCategory;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "variable_id" )
	protected Variable weightedBy;

	// getter/setter

	public int getFrequency()
	{
		return this.frequency;
	}

	public void setFrequency(final int frequency)
	{
		this.frequency = frequency;
	}

	public double getCumulativePercentage()
	{
		return this.cumulativePercentage;
	}

	public void setCumulativePercentage(final double cumulativePercentage)
	{
		this.cumulativePercentage = cumulativePercentage;
	}

	public double getPercentage()
	{
		return this.percentage;
	}

	public void setPercentage(final double percentage)
	{
		this.percentage = percentage;
	}

	public LangString getTypeOfCases()
	{
		return this.typeOfCases;
	}

	public void setTypeOfCases( final LangString typeOfCases )
	{
		this.typeOfCases = typeOfCases;
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

	public Variable getWeightedBy()
	{
		return this.weightedBy;
	}

	public void setWeightedBy( final Variable weightedBy )
	{
		this.weightedBy = weightedBy;
	}

}