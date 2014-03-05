package org.gesis.rdf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.gesis.ddi.util.Locales;
import org.junit.Test;

public class LangStringTest
{

	@Test
	public void init()
	{
		LangString langString;

		// init with de locale
		langString = new LangString( Locales.GERMANY, "de value" );

		assertEquals( "de value", langString.getValue( Locales.GERMANY ) );

		// others must be null
		assertNull( langString.getValue( Locales.UNITED_KINGDOM ) );
		assertNull( langString.getValue( Locales.FRANCE ) );

		// init with uk locale
		langString = new LangString( Locales.UNITED_KINGDOM, "uk value" );

		assertEquals( "uk value", langString.getValue( Locales.UNITED_KINGDOM ) );

		// other value must be empty
		assertNull( langString.getValue( Locales.GERMANY ) );
		assertNull( langString.getValue( Locales.FRANCE ) );

		// init with fr locale
		langString = new LangString( Locales.FRANCE, "fr value" );

		assertEquals( "fr value", langString.getValue( Locales.FRANCE ) );

		// other value must be empty
		assertNull( langString.getValue( Locales.GERMANY ) );
		assertNull( langString.getValue( Locales.UNITED_KINGDOM ) );
	}

	@Test
	public void addLocaleValue_DE()
	{
		LangString langString = new LangString().setValue( Locales.GERMANY, "de value" );

		assertEquals( "de value", langString.getValue( Locales.GERMANY ) );

		// other values must be null
		assertNull( langString.getValue( Locales.UNITED_KINGDOM ) );
		assertNull( langString.getValue( Locales.FRANCE ) );
	}

	@Test
	public void addLocaleValue_UK()
	{
		LangString langString = new LangString().setValue( Locales.UNITED_KINGDOM, "uk value" );

		assertEquals( "uk value", langString.getValue( Locales.UNITED_KINGDOM ) );

		// other values must be null
		assertNull( langString.getValue( Locales.GERMANY ) );
		assertNull( langString.getValue( Locales.FRANCE ) );
	}

	@Test
	public void addLocaleValue_FR()
	{
		LangString langString = new LangString().setValue( Locales.FRANCE, "fr value" );

		assertEquals( "fr value", langString.getValue( Locales.FRANCE ) );

		// other values must be null
		assertNull( langString.getValue( Locales.GERMANY ) );
		assertNull( langString.getValue( Locales.UNITED_KINGDOM ) );
	}

	@Test
	public void addLocaleValue_UKandNL()
	{
		LangString langString = new LangString( Locales.UNITED_KINGDOM, "some value" );

		String uk_value = langString.getValue( Locales.UNITED_KINGDOM );
		assertNotNull( uk_value );
		assertEquals( "some value", uk_value );

		// add other value
		langString.setValue( new Locale( "nl", "NL" ), "nl value" );

		String nl_value = langString.getValue( new Locale( "nl", "NL" ) );
		assertNotNull( nl_value );
		assertEquals( "nl value", nl_value );

		// others are empty
		assertNull( langString.getValue( Locales.GERMANY ) );
		assertNull( langString.getValue( Locales.FRANCE ) );
	}

	@Test
	public void addValuesWithKnownLocales()
	{
		Map<Locale, String> values = new HashMap<Locale, String>();
		values.put( Locales.GERMANY, "de value" );
		values.put( Locales.UNITED_KINGDOM, "en value" );

		LangString langString = new LangString( values );

		// map is not empty
		assertFalse( langString.getValues().isEmpty() );
	}

	@Test
	public void addNullValues()
	{
		LangString langString;

		// null everything
		langString = new LangString( null, null );
		assertTrue( langString.getValues().isEmpty() );

		assertNull( langString.getValue( Locales.GERMANY ) );

		// null locale
		langString = new LangString( null, "somevalue" );
		assertTrue( langString.getValues().isEmpty() );

		assertNull( langString.getValue( Locales.UNITED_KINGDOM ) );

		// null value
		langString = new LangString( Locales.FRANCE, null );
		assertTrue( langString.getValues().isEmpty() );

		assertNull( langString.getValue( Locales.FRANCE ) );
	}

	@Test
	public void createUKLangString()
	{
		LangString ls = LangString.uk( "some value" );
		assertNotNull( ls );
		assertEquals( "some value", ls.getEn() );
		assertNull( ls.getDe() );
	}

	@Test
	public void createDELangString()
	{
		LangString ls = LangString.de( "some value" );
		assertNotNull( ls );
		assertEquals( "some value", ls.getDe() );
		assertNull( ls.getEn() );
	}

	@Test
	public void createFRLangString()
	{
		LangString ls = LangString.fr( "some value" );
		assertNotNull( ls );
		assertEquals( "some value", ls.getFr() );
		assertNull( ls.getDe() );
	}

	@Test
	public void createLangString()
	{
		LangString ls = LangString.createLangString( Locales.GERMANY, "a value" );
		assertNotNull( ls );
		assertEquals( "a value", ls.getDe() );
		assertNull( ls.getEn() );
	}

	@Test
	public void createNullLangString()
	{
		LangString ls = LangString.createLangString( Locales.GERMANY, null );
		assertNull( ls );
	}

	@Test
	public void createDECountryCodeLangString()
	{
		LangString ls = LangString.createLangString( "de", "value" );
		assertNotNull( ls );
		assertEquals( "value", ls.getDe() );
		assertNull( ls.getEn() );
	}

	@Test
	public void createUKCountryCodeLangString()
	{
		LangString ls = LangString.createLangString( "uk", "value" );
		assertNotNull( ls );
		assertEquals( "value", ls.getEn() );
		assertNull( ls.getDe() );
	}

	@Test
	public void createFRCountryCodeLangString()
	{
		LangString ls = LangString.createLangString( "fr", "value" );
		assertNotNull( ls );
		assertEquals( "value", ls.getFr() );
		assertNull( ls.getEn() );
	}

	@Test
	public void createNLCountryCodeLangString()
	{
		LangString ls = LangString.createLangString( "nl", "value" );
		assertNotNull( ls );
		assertEquals( "value", ls.getValue( Locales.getLocale( "nl" ) ) );
		assertNull( ls.getEn() );
	}

}