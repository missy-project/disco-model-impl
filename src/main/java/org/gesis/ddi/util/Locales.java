package org.gesis.ddi.util;

import java.util.Locale;

public class Locales
{
	public static final Locale GERMANY = new Locale( "de", "DE" );
	public static final Locale UNITED_KINGDOM = new Locale( "en", "UK" );
	public static final Locale FRANCE = new Locale( "fr", "FR" );

	public static boolean isEqual( final Locale src, final Locale target )
	{
		if ( src == null || target == null )
			return false;

		if ( (src.getLanguage() == null || src.getLanguage() == "") && (src.getCountry() == null || src.getCountry() == "") )
			return false;

		if ( (target.getLanguage() == null || target.getLanguage() == "") && (target.getCountry() == null || target.getCountry() == "") )
			return false;

		// only this condition returns true
		if ( src.getLanguage().equals( target.getLanguage() ) )
			if ( src.getCountry().equals( target.getCountry() ) )
				return true;

		return false;
	}

	public static Locale getLocale( String country )
	{
		if ( country == null )
			return null;

		country = country.toLowerCase();

		if ( country.equals( "de" ) )
			return GERMANY;

		if ( country.equals( "uk" ) )
			return UNITED_KINGDOM;

		if ( country.equals( "fr" ) )
			return FRANCE;

		return new Locale( country, country );
	}
}
