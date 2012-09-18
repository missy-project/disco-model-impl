package org.gesis.skos;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractConceptScheme {

	// relations

	@ManyToMany
	private Set<Concept> skos_hasTopConcept;

	// getter/setter

	public Set<Concept> getSkos_hasTopConcept() {
		return skos_hasTopConcept;
	}

	public void setSkos_hasTopConcept(Set<Concept> skos_hasTopConcept) {
		this.skos_hasTopConcept = skos_hasTopConcept;
	}
}
