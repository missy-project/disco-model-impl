package org.gesis.rdf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.gesis.ddi.util.Locales;
import org.junit.Test;

public class LocalesTest
{

	@Test
	public void identify()
	{
		assertTrue( Locales.isEqual( Locales.GERMANY, Locales.GERMANY ) );
	}

	@Test
	public void isEqualGermanLocale()
	{
		Locale de = Locales.GERMANY;
		Locale newDe = new Locale( "de", "DE" );

		assertTrue( Locales.isEqual( de, newDe ) );
	}

	@Test
	public void isEqualUnitedKingdomLocale()
	{
		Locale uk = Locales.UNITED_KINGDOM;
		Locale newUk = new Locale( "en", "UK" );

		assertTrue( Locales.isEqual( uk, newUk ) );
	}

	@Test
	public void isEqualFranceLocale()
	{
		Locale fr = Locales.FRANCE;
		Locale newFr = new Locale( "fr", "FR" );

		assertTrue( Locales.isEqual( fr, newFr ) );
	}

	@Test
	public void isEqualNetherlandsLocale()
	{
		Locale nl1 = new Locale( "nl", "NL" );
		Locale nl2 = new Locale( "nl", "NL" );

		assertTrue( Locales.isEqual( nl1, nl2 ) );
	}

	@Test
	public void getLocaleKnown()
	{
		Locale de = Locales.getLocale( "DE" );
		assertNotNull( de );
		assertTrue( Locales.isEqual( Locales.GERMANY, de ) );

		Locale uk = Locales.getLocale( "uk" );
		assertNotNull( uk );
		assertTrue( Locales.isEqual( Locales.UNITED_KINGDOM, uk ) );

		Locale fr = Locales.getLocale( "fr" );
		assertNotNull( fr );
		assertTrue( Locales.isEqual( Locales.FRANCE, fr ) );
	}

	@Test
	public void getLocaleOther()
	{
		Locale austria = Locales.getLocale( "a" );

		assertNotNull( austria );
		assertFalse( Locales.isEqual( Locales.GERMANY, austria ) );
		assertEquals( "A", austria.getCountry() );
	}
}
