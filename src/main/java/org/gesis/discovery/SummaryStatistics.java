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
	private int numberOfCases;

	@Column
	private int percentage;

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

	public double getMaximum()
	{
		return this.maximum;
	}

	public void setMaximum(final double maximum)
	{
		this.maximum = maximum;
	}

	public double getMean()
	{
		return this.mean;
	}

	public void setMean(final double mean)
	{
		this.mean = mean;
	}

	public double getMedian()
	{
		return this.median;
	}

	public void setMedian(final double median)
	{
		this.median = median;
	}

	public double getMinimum()
	{
		return this.minimum;
	}

	public void setMinimum(final double minimum)
	{
		this.minimum = minimum;
	}

	public double getMode()
	{
		return this.mode;
	}

	public void setMode(final double mode)
	{
		this.mode = mode;
	}

	public int getNumberOfCases()
	{
		return this.numberOfCases;
	}

	public void setNumberOfCases( final int numberOfCases )
	{
		this.numberOfCases = numberOfCases;
	}

	public int getPercentage()
	{
		return this.percentage;
	}

	public void setPercentage( final int percentage )
	{
		this.percentage = percentage;
	}

	public LangString getComputationBase()
	{
		return this.computationBase;
	}

	public void setComputationBase( final LangString computationBase )
	{
		this.computationBase = computationBase;
	}

	public Set<Variable> getStatisticsVariable()
	{
		return this.statisticsVariable;
	}

	public void setStatisticsVariable(final Set<Variable> variables)
	{
		this.statisticsVariable = variables;
	}

	public SummaryStatistics addStatisticsVariable( final Variable variable )
	{
		if ( this.statisticsVariable == null )
			this.statisticsVariable = new HashSet<Variable>();

		this.statisticsVariable.add( variable );

		return this;
	}

	public double getStandardDeviation()
	{
		return this.standardDeviation;
	}

	public void setStandardDeviation( final double standardDeviation )
	{
		this.standardDeviation = standardDeviation;
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