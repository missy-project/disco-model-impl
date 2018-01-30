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

/**
 * CategoryStatistics are pointing to categories and codes. For
 * CategoryStatistics, frequencies, percentages, and weighted percentages can be
 * defined.
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#descriptivestatistics}
 * @see {@link DescriptiveStatistics}
 */
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

	/**
	 * Corresponds to disco:frequency.
	 * 
	 * @return
	 */
	public int getFrequency()
	{
		return frequency;
	}

	/**
	 * Corresponds to disco:frequency.
	 * 
	 * @param frequency
	 */
	public void setFrequency( final int frequency )
	{
		this.frequency = frequency;
	}

	/**
	 * Corresponds to disco:cumulativePercentage.
	 * 
	 * @return
	 */
	public double getCumulativePercentage()
	{
		return cumulativePercentage;
	}

	/**
	 * Corresponds to disco:cumulativePercentage.
	 * 
	 * @param cumulativePercentage
	 */
	public void setCumulativePercentage( final double cumulativePercentage )
	{
		this.cumulativePercentage = cumulativePercentage;
	}

	/**
	 * Corresponds to disco:percentage.
	 * 
	 * @return
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
	 * @return The computation base of this CategoryStatistics.
	 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#dfn-disco-computationbase}
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
	 * @return This CategoryStatistics object.
	 * @see {@link getComputationBase()}
	 */
	public CategoryStatistics setComputationBase( final LangString computationBase )
	{
		this.computationBase = computationBase;
		return this;
	}

	/**
	 * @return The list of Concepts (representing codes and categories) of this
	 *         CategoryStatistics.
	 * @see {@link Concept}
	 */
	public List<Concept> getStatisticsCategory()
	{
		return statisticsCategory;
	}

	/**
	 * Corresponds to disco:statisticsCategory. Indicates the Concepts (representing
	 * codes and categories) of this specific CategoryStatistics individual.
	 * 
	 * @param categories
	 * @see {@link getStatisticsCategory()}
	 */
	public CategoryStatistics setStatisticsCategory( final List<Concept> categories )
	{
		statisticsCategory = categories;
		return this;
	}

	public CategoryStatistics addStatisticsCategory( final Concept category )
	{
		if ( statisticsCategory == null )
			statisticsCategory = new ArrayList<Concept>();

		statisticsCategory.add( category );

		return this;
	}

	/**
	 * @return The Variable this CategoryStatistics is weighted by.
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
	 * @return This CategoryStatistics object.
	 * @see {@link getWeightedBy()}
	 */
	public CategoryStatistics setWeightedBy( final Variable weightedBy )
	{
		this.weightedBy = weightedBy;
		return this;
	}

}