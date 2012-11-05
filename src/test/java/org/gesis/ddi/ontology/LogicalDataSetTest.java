package org.gesis.ddi.ontology;

import junit.framework.Assert;

import org.junit.Test;

public class LogicalDataSetTest {

	LogicalDataSet dataSet = new LogicalDataSet();

	@Test
	public void testCoverage() {
		dataSet.setCoverage( new Coverage() );

		Coverage coverage = dataSet.getCoverage();
		Assert.assertNotNull( coverage );
	}
}
