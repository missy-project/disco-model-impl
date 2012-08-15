package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.Concept;

@MappedSuperclass
public class DescriptiveStatistics extends Identifiable {

	// properties

	@Column
	private int frequency;

	@Column
	private float percentage;

	@Column
	private int weightedFrequency;

	@Column
	private int weightedBy;

	// relations

	@ManyToOne
	private Variable hasStatisticsVariable;

	@ManyToMany
	private Set<Datafile> hasStatisticsDatafile;

	@ManyToOne
	private Concept hasStatisticsCategory;

	// getter/setter

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public int getWeightedFrequency() {
		return weightedFrequency;
	}

	public void setWeightedFrequency(int weightedFrequency) {
		this.weightedFrequency = weightedFrequency;
	}

	public int getWeightedBy() {
		return weightedBy;
	}

	public void setWeightedBy(int weightedBy) {
		this.weightedBy = weightedBy;
	}

	public Variable getHasStatisticsVariable() {
		return hasStatisticsVariable;
	}

	public void setHasStatisticsVariable(Variable hasStatisticsVariable) {
		this.hasStatisticsVariable = hasStatisticsVariable;
	}

	public Set<Datafile> getHasStatisticsDatafile() {
		return hasStatisticsDatafile;
	}

	public void setHasStatisticsDatafile(Set<Datafile> hasStatisticsDatafile) {
		this.hasStatisticsDatafile = hasStatisticsDatafile;
	}

	public Concept getHasStatisticsCategory() {
		return hasStatisticsCategory;
	}

	public void setHasStatisticsCategory(Concept hasStatisticsCategory) {
		this.hasStatisticsCategory = hasStatisticsCategory;
	}

}
