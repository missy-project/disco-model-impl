package org.gesis.discovery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.gesis.skos.Concept;
import org.junit.Test;

public class ConceptTest
{

	@Test
	public void concept()
	{
		Concept concept = Concept.withNotation( Concept.class, "some notation" );
		assertNotNull( concept );
		assertEquals( "some notation", concept.getNotation() );
	}

	@Test
	public void variable()
	{
		Variable variable = Concept.withNotation( Variable.class, "variable notation" );
		assertNotNull( variable );
		assertEquals( "Variable", variable.getClass().getSimpleName() );
		assertEquals( "variable notation", variable.getNotation() );
	}

	@Test
	public void question()
	{
		Question question = Concept.withNotation( Question.class, "question notation" );
		assertNotNull( question );
		assertEquals( "Question", question.getClass().getSimpleName() );
		assertEquals( "question notation", question.getNotation() );
	}
}
