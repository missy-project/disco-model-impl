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

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class SummaryStatistics extends DescriptiveStatistics
{

	// properties

	@Column
	private double maximum;

	@Column
	private double mean;

	@Column
	private double median;

	@Column
	private double minimum;

	@Column
	private double mode;

	@Column
	private double standardDeviation;

	@Column
	private int numberOfCases = -1;

	@Column
	private double percentage = -1;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString computationBase;

	// relations
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "SummaryStatistics_Variable",
			joinColumns = @JoinColumn( name = "summaryStatistics_id" ),
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected List<Variable> statisticsVariable;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "variable_id" )
	protected Variable weightedBy;

	// getter/setter

	public double getMaximum()
	{
		return maximum;
	}

	public void setMaximum( final double maximum )
	{
		this.maximum = maximum;
	}

	public double getMean()
	{
		return mean;
	}

	public void setMean( final double mean )
	{
		this.mean = mean;
	}

	public double getMedian()
	{
		return median;
	}

	public void setMedian( final double median )
	{
		this.median = median;
	}

	public double getMinimum()
	{
		return minimum;
	}

	public void setMinimum( final double minimum )
	{
		this.minimum = minimum;
	}

	public double getMode()
	{
		return mode;
	}

	public void setMode( final double mode )
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

	public List<Variable> getStatisticsVariable()
	{
		return statisticsVariable;
	}

	public void setStatisticsVariable(final List<Variable> variables)
	{
		statisticsVariable = variables;
	}

	public SummaryStatistics addStatisticsVariable( final Variable variable )
	{
		if ( statisticsVariable == null )
			statisticsVariable = new ArrayList<Variable>();

		statisticsVariable.add( variable );

		return this;
	}

	public double getStandardDeviation()
	{
		return standardDeviation;
	}

	public void setStandardDeviation( final double standardDeviation )
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