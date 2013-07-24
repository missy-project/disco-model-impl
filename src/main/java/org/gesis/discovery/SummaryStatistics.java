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

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class SummaryStatistics extends DescriptiveStatistics
{

	// properties

	@Column
	private float maximum;

	@Column
	private float mean;

	@Column
	private float median;

	@Column
	private float minimum;

	@Column
	private float mode;

	@Column
	private float standardDeviation;

	@Column
	private int numberOfCases = -1;

	@Column
	private float percentage = -1;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString computationBase;

	// relations
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "SummaryStatistics_Variable",
			joinColumns = @JoinColumn( name = "summaryStatistics_id" ),
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected Set<Variable> statisticsVariable;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "variable_id" )
	protected Variable weightedBy;

	// getter/setter

	public float getMaximum()
	{
		return maximum;
	}

	public void setMaximum( final float maximum )
	{
		this.maximum = maximum;
	}

	public float getMean()
	{
		return mean;
	}

	public void setMean( final float mean )
	{
		this.mean = mean;
	}

	public float getMedian()
	{
		return median;
	}

	public void setMedian( final float median )
	{
		this.median = median;
	}

	public float getMinimum()
	{
		return minimum;
	}

	public void setMinimum( final float minimum )
	{
		this.minimum = minimum;
	}

	public float getMode()
	{
		return mode;
	}

	public void setMode( final float mode )
	{
		this.mode = mode;
	}

	public int getNumberOfCases()
	{
		return numberOfCases;
	}

	public void setNumberOfCases( final int numberOfCases )
	{
		this.numberOfCases = numberOfCases;
	}

	public float getPercentage()
	{
		return percentage;
	}

	public void setPercentage( final float percentage )
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

	public Set<Variable> getStatisticsVariable()
	{
		return statisticsVariable;
	}

	public void setStatisticsVariable(final Set<Variable> variables)
	{
		statisticsVariable = variables;
	}

	public SummaryStatistics addStatisticsVariable( final Variable variable )
	{
		if ( statisticsVariable == null )
			statisticsVariable = new HashSet<Variable>();

		statisticsVariable.add( variable );

		return this;
	}

	public float getStandardDeviation()
	{
		return standardDeviation;
	}

	public void setStandardDeviation( final float standardDeviation )
	{
		this.standardDeviation = standardDeviation;
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