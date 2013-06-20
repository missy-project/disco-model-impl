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

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class SummaryStatistics extends DescriptiveStatistics
{

	// properties

	@Column
	private int invalidCases;

	@Column
	private int validCases;

	@Column
	private int weightedInvalidCases;

	@Column
	private int weightValidCases;

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
	private double weightedMean;

	@Column
	private double weightedMedian;

	@Column
	private double weightedMode;

	@Column
	private double standardDeviation;

	// relations
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "SummaryStatistics_Variable", 
			joinColumns = @JoinColumn( name = "summaryStatistics_id" ), 
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected Set<Variable> statisticsVariable;

	// getter/setter

	public int getInvalidCases()
	{
		return this.invalidCases;
	}

	public void setInvalidCases(final int invalidCases)
	{
		this.invalidCases = invalidCases;
	}

	public int getValidCases()
	{
		return this.validCases;
	}

	public void setValidCases(final int validCases)
	{
		this.validCases = validCases;
	}

	public int getWeightedInvalidCases()
	{
		return this.weightedInvalidCases;
	}

	public void setWeightedInvalidCases(final int weightedInvalidCases)
	{
		this.weightedInvalidCases = weightedInvalidCases;
	}

	public int getWeightValidCases()
	{
		return this.weightValidCases;
	}

	public void setWeightValidCases(final int weightValidCases)
	{
		this.weightValidCases = weightValidCases;
	}

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

	public double getWeightedMean()
	{
		return this.weightedMean;
	}

	public void setWeightedMean(final double weightedMean)
	{
		this.weightedMean = weightedMean;
	}

	public double getWeightedMedian()
	{
		return this.weightedMedian;
	}

	public void setWeightedMedian(final double weightedMedian)
	{
		this.weightedMedian = weightedMedian;
	}

	public double getWeightedMode()
	{
		return this.weightedMode;
	}

	public void setWeightedMode(final double weightedMode)
	{
		this.weightedMode = weightedMode;
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

}