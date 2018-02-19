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

/**
 * For SummaryStatistics, maximum values, minimum values, and standard
 * deviations can be defined. SummaryStatistics pointing to variables.
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#descriptivestatistics">Definition:
 *      Descriptive Statistics</a>
 * @see org.gesis.discovery.DescriptiveStatistics
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class SummaryStatistics extends DescriptiveStatistics
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	/**
	 * Corresponds to disco:maximum.
	 * 
	 * @return maximum.
	 */
	public double getMaximum()
	{
		return maximum;
	}

	/**
	 * Corresponds to disco:maximum.
	 * 
	 * @param maximum
	 */
	public void setMaximum( final double maximum )
	{
		this.maximum = maximum;
	}

	/**
	 * Corresponds to disco:mean.
	 * 
	 * @return mean.
	 */
	public double getMean()
	{
		return mean;
	}

	/**
	 * Corresponds to disco:mean.
	 * 
	 * @param mean
	 */
	public void setMean( final double mean )
	{
		this.mean = mean;
	}

	/**
	 * Corresponds to disco:median.
	 * 
	 * @return median.
	 */
	public double getMedian()
	{
		return median;
	}

	/**
	 * Corresponds to disco:median.
	 * 
	 * @param median
	 */
	public void setMedian( final double median )
	{
		this.median = median;
	}

	/**
	 * Corresponds to disco:minimum.
	 * 
	 * @return minimum.
	 */
	public double getMinimum()
	{
		return minimum;
	}

	/**
	 * Corresponds to disco:minimum.
	 * 
	 * @param minimum
	 */
	public void setMinimum( final double minimum )
	{
		this.minimum = minimum;
	}

	/**
	 * Corresponds to disco:mode.
	 * 
	 * @return mode.
	 */
	public double getMode()
	{
		return mode;
	}

	/**
	 * Corresponds to disco:mode.
	 * 
	 * @param mode
	 */
	public void setMode( final double mode )
	{
		this.mode = mode;
	}

	/**
	 * Corresponds to disco:numberOfCases.
	 * 
	 * @return numberOfCases.
	 */
	public int getNumberOfCases()
	{
		return numberOfCases;
	}

	/**
	 * Corresponds to disco:numberOfCases.
	 * 
	 * @param numberOfCases
	 */
	public void setNumberOfCases( final int numberOfCases )
	{
		this.numberOfCases = numberOfCases;
	}

	/**
	 * Corresponds to disco:percentage.
	 * 
	 * @return percentage.
	 */
	public double getPercentage()
	{
		return percentage;
	}

	/**
	 * Corresponds to disco:percentage.
	 * 
	 * @param percentage
	 */
	public void setPercentage( final double percentage )
	{
		this.percentage = percentage;
	}

	/**
	 * @return The computation base of this SummaryStatistics.
	 * @see <a href=
	 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#dfn-disco-computationbase">Definition:
	 *      computationbase</a>
	 */
	public LangString getComputationBase()
	{
		return computationBase;
	}

	/**
	 * Corresponds to disco:computationBase. It expresses if the cases - which are
	 * the basis of the computation of a statistics value - are valid, invalid or
	 * the total of both. The usage of computationBase for frequency differs from
	 * the usage for the percentage statistics and the summary statistics. A
	 * distinction regarding computationBase doesn't apply to frequency as category
	 * statistic.
	 * 
	 * @param computationBase
	 * @return This SummaryStatistics object.
	 * @see #getComputationBase()
	 */
	public SummaryStatistics setComputationBase( final LangString computationBase )
	{
		this.computationBase = computationBase;
		return this;
	}

	/**
	 * Indicates the Variable of a specific SummaryStatistics individual.
	 * 
	 * @return The list of Varibles of the SummaryStatistics.
	 */
	public List<Variable> getStatisticsVariable()
	{
		return statisticsVariable;
	}

	/**
	 * Corresponds to disco:statisticsVariable. Indicates the Variables of a
	 * specific SummaryStatistics individual.
	 * 
	 * @param variables
	 */
	public SummaryStatistics setStatisticsVariable( final List<Variable> variables )
	{
		statisticsVariable = variables;
		return this;
	}

	public SummaryStatistics addStatisticsVariable( final Variable variable )
	{
		if ( statisticsVariable == null )
			statisticsVariable = new ArrayList<Variable>();

		statisticsVariable.add( variable );

		return this;
	}

	/**
	 * Corresponds to disco:standardDeviation.
	 * 
	 * @return standardDeviation.
	 */
	public double getStandardDeviation()
	{
		return standardDeviation;
	}

	/**
	 * Corresponds to disco:standardDeviation.
	 * 
	 * @param standardDeviation
	 */
	public void setStandardDeviation( final double standardDeviation )
	{
		this.standardDeviation = standardDeviation;
	}

	/**
	 * @return The Variable this SummaryStatistics is weighted by.
	 */
	public Variable getWeightedBy()
	{
		return weightedBy;
	}

	/**
	 * Corresponds to disco:weightedBy. It defines the weight variable of a category
	 * or summary statistic computation respectively value. It can also be used to
	 * indicate if a weight variable is used but the related variable is not known.
	 * weightedBy may be assigned to a category statistic value or to a summary
	 * statistic value.
	 * 
	 * @param weightedBy
	 * @return This SummaryStatistics object.
	 * @see #getWeightedBy()
	 */
	public SummaryStatistics setWeightedBy( final Variable weightedBy )
	{
		this.weightedBy = weightedBy;
		return this;
	}

}