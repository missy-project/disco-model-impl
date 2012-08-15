package org.gesis.ddi;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.ontology.DescriptiveStatistics;

@MappedSuperclass
public class SummaryStatistics extends DescriptiveStatistics {

	// properties

	@Column
	private float value;

	// getter/setter

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
