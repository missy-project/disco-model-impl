package org.gesis.ddi.util;

import java.util.UUID;

public class IdentifierFactory
{

	public static String getNextDefaultIdentifier()
	{
		return UUID.randomUUID().toString();
	}
	
	public static String getNextDefaultIdentifier(String prefix)
	{
		return prefix + "-" + UUID.randomUUID().toString();
	}
}
