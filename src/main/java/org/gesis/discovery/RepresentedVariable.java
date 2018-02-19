package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

/**
 * RepresentedVariable encompasse study-independent, re-usable parts of
 * variables like occupation classification.
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#variable-and-variable-definition">Definition:
 *      Variable and Variable Definition</a>
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class RepresentedVariable extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@Column
	@Lob
	private String description;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="VariableDefinition_Universe",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "universe_id" ))
	protected List<Universe> universe;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "concept_id" )
	protected Concept concept;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="VariableDefinition_Representation",
			joinColumns=@JoinColumn(name="variableDefinition_id"),
			inverseJoinColumns=@JoinColumn( name = "representation_id" ))
	protected List<Representation> representation;

	// getter/setter

	/**
	 * @return The description of this RepresentedVariable.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Corresponds to dcterms:description.
	 * 
	 * Variables can be described (dcterms:description), have associated names
	 * (skos:notation), and have labels that are set via the datatype property
	 * prefLabel (skos:prefLabel).
	 * 
	 * @param description
	 * @see #getDescription()
	 * @see org.gesis.discovery.Variable
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Indicates the particular {@link Universe}(s) that may be connected to this
	 * Variable. Any universe of a Variable definition is a subset of the Universe
	 * of the entire {@link Study}.
	 * 
	 * @return The Universe of this RepresentedVariable.
	 * @see org.gesis.discovery.Universe
	 * @see org.gesis.skos.Concept
	 */
	public List<Universe> getUniverse() {
		return this.universe;
	}

	/**
	 * Sets the Universe for this RepresentedVariable. Any universe of a Variable
	 * definition is a subset of the Universe of the entire {@link Study}.
	 * 
	 * @param universe
	 * @return This RepresentedVariable object.
	 * @see #getUniverse()
	 */
	public RepresentedVariable setUniverse( final List<Universe> universe )
	{
		this.universe = universe;
		return this;
	}

	public RepresentedVariable addUniverse( final Universe universe )
	{
		if ( this.universe == null )
			this.universe = new ArrayList<Universe>();

		this.universe.add( universe );

		return this;
	}

	/**
	 * Points to the DDI concept of a RepresentedVariable, a Variable, or a
	 * Question.
	 * 
	 * @return The Concept of this RepresentedVariable.
	 * @see org.gesis.skos.Concept
	 */
	public Concept getConcept()
	{
		return this.concept;
	}

	/**
	 * Sets the Concept for this Variable.
	 * 
	 * @param concept
	 * @return This RepresentedVariable object.
	 * @see #getConcept()
	 */
	public RepresentedVariable setConcept( final Concept concept )
	{
		this.concept = concept;
		return this;
	}

	/**
	 * The {@link Representation} of a variable is the combination of a value
	 * domain, datatype, and, if necessary, a unit of measure or a character set.
	 * 
	 * @return The Representation of this RepresentedVariable.
	 * @see org.gesis.discovery.Representation
	 * @see org.gesis.skos.ConceptScheme
	 */
	public List<Representation> getRepresentation() {
		return this.representation;
	}

	/**
	 * Sets the Representation which is one of a set of values to which a numerical
	 * measure or a category from a classification can be assigned (e.g. income,
	 * age, and sex: male coded as 1).
	 * 
	 * @param representation
	 * @return This RepresentedVariable object.
	 * @see #getRepresentation()
	 */
	public RepresentedVariable setRepresentation( final List<Representation> representation )
	{
		this.representation = representation;
		return this;
	}

	public RepresentedVariable addRepresentation( final Representation representation )
	{
		if ( this.representation == null )
			this.representation = new ArrayList<Representation>();

		this.representation.add( representation );

		return this;
	}

}