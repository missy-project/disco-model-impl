package org.gesis.ddi.util;

import java.util.Locale;

public class LangStringKeyBuilder
{
	public static final String separator = "_";

	public static String buildFrom( final Locale locale )
	{
		if ( locale == null )
			return null;

		return locale.getLanguage() + separator + locale.getCountry();
	}
}
