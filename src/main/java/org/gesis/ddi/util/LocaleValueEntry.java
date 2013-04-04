package org.gesis.ddi.util;

import java.util.Map.Entry;

public class LocaleValueEntry implements Entry<String, String>
{

	String locale = "";
	String value = "";

	public LocaleValueEntry( final String key, final String value )
	{
		super();
		this.locale = key;
		this.value = value;
	}

	@Override
	public String getKey()
	{
		return this.locale;
	}

	@Override
	public String getValue()
	{
		return this.value;
	}

	@Override
	public String setValue( final String value )
	{
		String old = this.value;
		this.value = value;

		return old;
	}
}
