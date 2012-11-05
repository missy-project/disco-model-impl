package org.gesis.ddi.ontology;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.rdfs.Datatype;
import org.gesis.skos.ConceptScheme;

@MappedSuperclass
public class Representation extends Identifiable {

	// TODO zl document this union relationship, how it is modelled in disco

	// relations

	@ManyToOne(optional = true)
	private ConceptScheme conceptScheme;

	@ManyToOne(optional = true)
	private Datatype datatype;

	// getter/setter

	public ConceptScheme getConceptScheme() {
		return conceptScheme;
	}

	public void setConceptScheme(ConceptScheme conceptScheme) {
		this.conceptScheme = conceptScheme;
	}

	public Datatype getDatatype() {
		return datatype;
	}

	public void setDatatype(Datatype datatype) {
		this.datatype = datatype;
	}

}
