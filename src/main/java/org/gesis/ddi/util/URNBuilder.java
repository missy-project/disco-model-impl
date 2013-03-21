package org.gesis.ddi.util;

import org.gesis.ddi.Identifiable;

public class URNBuilder
{

	public static String buildFrom( Identifiable identifiable )
	{
		if ( identifiable == null )
			return "";

		StringBuilder urnBuilder = new StringBuilder();
		urnBuilder.append( identifiable.getAgencyId() );
		urnBuilder.append( ":" );
		urnBuilder.append( identifiable.getObjectId() );
		urnBuilder.append( ":" );
		urnBuilder.append( identifiable.getMajorVersion() );

		return urnBuilder.toString().trim();
	}
}
