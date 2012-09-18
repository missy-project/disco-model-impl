package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.skos.Concept;
import org.gesis.skos.ConceptScheme;

@MappedSuperclass
public abstract class AbstractQuestion<C extends Concept> extends Identifiable {

	// properties

	@Column
	private String literalText;

	// relations

	@ManyToOne
	private ConceptScheme hasResponseDomain_;

	@ManyToOne
	private Representation hasResponseDomain;

	@ManyToMany
	private Set<C> hasConcept;

	// getter/setter

	public Object getLiteralText() {
		return literalText;
	}

	public void setLiteralText(String literalText) {
		this.literalText = literalText;
	}

	public ConceptScheme getHasResponseDomain_() {
		return hasResponseDomain_;
	}

	public void setHasResponseDomain_(ConceptScheme hasResponseDomain_) {
		this.hasResponseDomain_ = hasResponseDomain_;
	}

	public Representation getHasResponseDomain() {
		return hasResponseDomain;
	}

	public void setHasResponseDomain(Representation hasResponseDomain) {
		this.hasResponseDomain = hasResponseDomain;
	}

	public Set<C> getHasConcept() {
		return hasConcept;
	}

	public void setHasConcept(Set<C> hasConcept) {
		this.hasConcept = hasConcept;
	}

}
