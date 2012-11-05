package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractDescriptiveStatistics<F extends AbstractDataFile<?, ?, ?>> extends Identifiable {

	// properties

	// relations

	@ManyToMany
	private Set<F> statisticsDatafile;

	// getter/setter

	public Set<F> getStatisticsDatafile() {
		return statisticsDatafile;
	}

	public void setStatisticsDatafile(Set<F> statisticsDatafile) {
		this.statisticsDatafile = statisticsDatafile;
	}

}
