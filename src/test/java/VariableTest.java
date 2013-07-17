import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.gesis.discovery.Representation;
import org.gesis.discovery.Variable;
import org.gesis.rdfs.Datatype;
import org.gesis.skos.ConceptScheme;
import org.gesis.skos.OrderedCollection;
import org.junit.Test;


public class VariableTest
{

	@Test
	public void setOrderedCollection()
	{
		Representation representation = new OrderedCollection();

		Variable variable = new Variable();
		variable.setRepresentation( representation );

		assertNotNull( variable.getRepresentation() );
		assertTrue( variable.getRepresentation() instanceof OrderedCollection );
	}

	@Test
	public void setDatatype()
	{
		Representation representation = new Datatype();

		Variable variable = new Variable();
		variable.setRepresentation( representation );

		assertNotNull( variable.getRepresentation() );
		assertTrue( variable.getRepresentation() instanceof Datatype );
	}

	@Test
	public void setConecptScheme()
	{
		Representation representation = new ConceptScheme();

		Variable variable = new Variable();
		variable.setRepresentation( representation );

		assertNotNull( variable.getRepresentation() );
		assertTrue( variable.getRepresentation() instanceof ConceptScheme );
	}
}
