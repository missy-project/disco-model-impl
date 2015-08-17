package org.gesis.discovery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.gesis.ddi.util.Locales;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.junit.Test;

public class ResourceTest
{

	@Test
	public void resourceWithPrefLabel()
	{
		Resource resource = Resource.withPrefLabel( Resource.class, LangString.withLocaleAndValue( Locales.UNITED_KINGDOM, "label of the resource" ) );
		assertNotNull( resource );
		assertEquals( "Resource", resource.getClass().getSimpleName() );
		assertNotNull( resource.getPrefLabel() );
		assertEquals( "label of the resource", resource.getPrefLabel().getEn() );
	}

	@Test
	public void studyWithPrefLabel()
	{
		Study study = Resource.withPrefLabel( Study.class, LangString.withLocaleAndValue( Locales.UNITED_KINGDOM, "name of the study" ) );
		assertNotNull( study );
		assertEquals( "Study", study.getClass().getSimpleName() );
		assertNotNull( study.getPrefLabel() );
		assertEquals( "name of the study", study.getPrefLabel().getEn() );
	}

}
