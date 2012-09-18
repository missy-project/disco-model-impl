package org.gesis.ddi;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.ontology.AbstractDataElement;
import org.gesis.ddi.ontology.AbstractDatafile;
import org.gesis.ddi.ontology.AbstractDescriptiveStatistics;
import org.gesis.ddi.ontology.AbstractInstrument;
import org.gesis.ddi.ontology.AbstractQuestion;

@MappedSuperclass
public abstract class AbstractSummaryStatistics<I extends AbstractInstrument<?>, D extends AbstractDataElement<Q>, F extends AbstractDatafile<?, ?>, Q extends AbstractQuestion<?>> extends AbstractDescriptiveStatistics<I, D, F, Q> {

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
