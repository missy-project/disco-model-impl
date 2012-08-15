package org.gesis.ddi.ontology;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.ConceptScheme;

@MappedSuperclass
public class Representation extends Identifiable {

	// relations

	@ManyToOne
	private ConceptScheme hasConceptScheme;

	// getter/setter

	public ConceptScheme getHasConceptScheme() {
		return hasConceptScheme;
	}

	public void setHasConceptScheme(ConceptScheme hasConceptScheme) {
		this.hasConceptScheme = hasConceptScheme;
	}

}
