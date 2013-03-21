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
	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "SummaryStatistics_Variable", 
			joinColumns = @JoinColumn( name = "summaryStatistics_id" ), 
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected Set<Variable> statisticsVariable;

	// getter/setter

	public SummaryStatistics( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public int getInvalidCases()
	{
		return invalidCases;
	}

	public void setInvalidCases(int invalidCases)
	{
		this.invalidCases = invalidCases;
	}

	public int getValidCases()
	{
		return validCases;
	}

	public void setValidCases(int validCases)
	{
		this.validCases = validCases;
	}

	public int getWeightedInvalidCases()
	{
		return weightedInvalidCases;
	}

	public void setWeightedInvalidCases(int weightedInvalidCases)
	{
		this.weightedInvalidCases = weightedInvalidCases;
	}

	public int getWeightValidCases()
	{
		return weightValidCases;
	}

	public void setWeightValidCases(int weightValidCases)
	{
		this.weightValidCases = weightValidCases;
	}

	public double getMaximum()
	{
		return maximum;
	}

	public void setMaximum(double maximum)
	{
		this.maximum = maximum;
	}

	public double getMean()
	{
		return mean;
	}

	public void setMean(double mean)
	{
		this.mean = mean;
	}

	public double getMedian()
	{
		return median;
	}

	public void setMedian(double median)
	{
		this.median = median;
	}

	public double getMinimum()
	{
		return minimum;
	}

	public void setMinimum(double minimum)
	{
		this.minimum = minimum;
	}

	public double getMode()
	{
		return mode;
	}

	public void setMode(double mode)
	{
		this.mode = mode;
	}

	public double getWeightedMean()
	{
		return weightedMean;
	}

	public void setWeightedMean(double weightedMean)
	{
		this.weightedMean = weightedMean;
	}

	public double getWeightedMedian()
	{
		return weightedMedian;
	}

	public void setWeightedMedian(double weightedMedian)
	{
		this.weightedMedian = weightedMedian;
	}

	public double getWeightedMode()
	{
		return weightedMode;
	}

	public void setWeightedMode(double weightedMode)
	{
		this.weightedMode = weightedMode;
	}

	public Set<Variable> getStatisticsVariable()
	{
		return this.statisticsVariable;
	}

	public void setStatisticsVariable(Set<Variable> variables)
	{
		this.statisticsVariable = variables;
	}

	public double getStandardDeviation()
	{
		return standardDeviation;
	}

	public void setStandardDeviation( double standardDeviation )
	{
		this.standardDeviation = standardDeviation;
	}

}