package org.gesis.ddi.ontology;

import org.gesis.datacube.DataSet;
import org.gesis.skos.Concept;

public class LogicalDataSet extends AbstractLogicalDataSet<Instrument, Variable, Question, DataFile, DataSet, Concept> {

	@Override
	public Coverage getCoverage() {
		return (Coverage) super.getCoverage();
	}

	@Override
	public Universe getDataSetUniverse() {
		return (Universe) super.getDataSetUniverse();
	}
}
