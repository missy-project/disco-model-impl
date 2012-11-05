package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.skos.AbstractConcept;


@MappedSuperclass
public abstract class AbstractCategoryStatistics<F extends AbstractDataFile<?, ?, ?>, C extends AbstractConcept> extends AbstractDescriptiveStatistics<F> {

	// properties

	@Column
	private int frequency;

	@Column
	private int weightFrequency;

	@Column
	private double cumulativePercentage;

	@Column
	private double weightedCumulativePercentage;

	@Column
	private double percentage;

	@Column
	private double weightedPercentage;

	// relations

	@ManyToMany
	private Set<C> statisticsCategory;

	// getter/setter

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getWeightFrequency() {
		return weightFrequency;
	}

	public void setWeightFrequency(int weightFrequency) {
		this.weightFrequency = weightFrequency;
	}

	public double getCumulativePercentage() {
		return cumulativePercentage;
	}

	public void setCumulativePercentage(double cumulativePercentage) {
		this.cumulativePercentage = cumulativePercentage;
	}

	public double getWeightedCumulativePercentage() {
		return weightedCumulativePercentage;
	}

	public void setWeightedCumulativePercentage(double weightedCumulativePercentage) {
		this.weightedCumulativePercentage = weightedCumulativePercentage;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public double getWeightedPercentage() {
		return weightedPercentage;
	}

	public void setWeightedPercentage(double weightedPercentage) {
		this.weightedPercentage = weightedPercentage;
	}

	public Set<C> getStatisticsCategory() {
		return statisticsCategory;
	}

	public void setStatisticsCategory(Set<C> statisticsCategory) {
		this.statisticsCategory = statisticsCategory;
	}

}
