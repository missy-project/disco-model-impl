package org.gesis.skos;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;

/**
 * <p>
 * skos:Concept is reused to a large extent to represent DDI concepts, codes,
 * and categories. SKOS defines the term skos:Concept, which is a unit of
 * knowledge created by a unique combination of characteristics. In context of
 * statistical (meta)data, concepts are abstract summaries, general notions,
 * knowledge of a whole set of behaviours, attitudes or characteristics which
 * are seen as having something in common. Skos:Concepts may be associated with
 * variables, variable definitions, and questions and are reused to a large
 * extent to represent DDI concepts (skos:prefLabel), codes (skos:notation), and
 * category labels (skos:prefLabel). Skos:Concepts may be organized in
 * skos:ConceptSchemes (skos:inScheme), sets of metadata describing statistical
 * concepts. Hierarchies of DDI concepts can be built using the object
 * properties skos:broader and skos:narrower. Topical coverage can be expressed
 * using dcterms:subject. Disco foresees the use of skos:Concept for the
 * description of topical coverage. Spatial, temporal, and topical coverage are
 * directly attached to studies, logical datasets, and datafiles. Universes and
 * AnalysisUnits are also skos:Concepts. Therefore the properties defined for
 * skos:Concept can be reused. KindOfData, pointing to a skos:Concept ,
 * describes, with a string or a term from a controlled vocabulary, the kind of
 * data documented in the logical product(s) of a Study. Using dcterms:format,
 * DataFiles formats can be defined.
 * </p>
 * <p>
 * Required classes of SKOS are:
 * <ul>
 * <li>skos:Concept,</li>
 * <li>skos:ConceptScheme,</li>
 * <li>skos:OrderedCollection</li>
 * </ul>
 * </p>
 * <p>
 * Required properties of SKOS are:
 * <ul>
 * <li>skos:prefLabel,</li>
 * <li>skos:definition,</li>
 * <li>skos:notation,</li>
 * <li>skos:hasTopConcept,</li>
 * <li>skos:inScheme,</li>
 * <li>skos:broader,</li>
 * <li>skos:narrower,</li>
 * <li>skos:memberList</li>
 * </ul>
 * </p>
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#simple-knowledge-organization-system-skos}
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Concept extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString definition;

	@Column
	private String notation;

	@Column( columnDefinition = "bit default 0" )
	private Boolean isValid = false;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Concept_ConceptScheme",
			joinColumns = @JoinColumn( name = "concept_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn( name = "inScheme_id" ) )
	private List<ConceptScheme> inScheme;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Concept_ConceptBroader",
			joinColumns = @JoinColumn( name = "concept_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn( name = "broader_id" ) )
	private List<Concept> broader;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Concept_ConceptNarrower",
			joinColumns = @JoinColumn( name = "concept_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn( name = "narrower_id" ) )
	private List<Concept> narrower;

	// getter/setter

	/**
	 * A skos:definition is a "documentation property (note property)", which in
	 * skos refers to <i>"... information relating to SKOS concepts. There is no
	 * restriction on the nature of this information, e.g., it could be plain text,
	 * hypertext, or an image; it could be a definition, information about the scope
	 * of a concept, editorial information, or any other type of information."</i>
	 * (from the specification).
	 * 
	 * @return The definition of this Concept.
	 */
	public LangString getDefinition()
	{
		return definition;
	}

	/**
	 * Corresponds to skos:definition. Sets the definition for this Concept.
	 * 
	 * @param definition
	 * @return This Concept object.
	 * @see {@link getDefinition()}
	 */
	public Concept setDefinition( final LangString definition )
	{
		this.definition = definition;
		return this;
	}

	/**
	 * @return The notation of this Concept.
	 */
	public String getNotation()
	{
		return notation;
	}

	/**
	 * Corresponds to skos:notation. Sets the notation for this Concept.
	 * skos:notation is used e.g.
	 * <ul>
	 * <li>to associate names to Variables, and</li>
	 * <li>to describe code values of CategoryStatistics</li>
	 * </ul>
	 * 
	 * @param notation
	 * @return This Concept object.
	 * @see {@link getNotation()}
	 */
	public Concept setNotation( final String notation )
	{
		this.notation = notation;
		return this;
	}

	/**
	 * @return A Boolean-box class.
	 */
	public Boolean isValid()
	{
		return isValid;
	}

	/**
	 * Please note that the property isValid is a feature at risk, since the domain
	 * is not Disco. Maintainers of the domain ontology may introduce their own
	 * property for this or a similar purpose
	 * 
	 * @param isValid
	 * @return This Concept object.
	 */
	public Concept setValid( final Boolean isValid )
	{
		this.isValid = isValid;
		return this;
	}

	/**
	 * @return The list of ConceptSchemes this Concept is contained in.
	 */
	public List<ConceptScheme> getInScheme()
	{
		return inScheme;
	}

	/**
	 * Corresponds to skos:inScheme. Concepts may be organized in ConceptSchemes,
	 * which are sets of metadata describing statistical concepts. Hierarchies of
	 * DDI concepts can be built using the object properties skos:broader and
	 * skos:narrower.
	 * 
	 * @param inScheme
	 * @return This Concept object.
	 */
	public Concept setInScheme( final List<ConceptScheme> inScheme )
	{
		this.inScheme = inScheme;
		return this;
	}

	public Concept addInScheme( final ConceptScheme conceptScheme )
	{
		if ( inScheme == null )
			inScheme = new ArrayList<ConceptScheme>();

		inScheme.add( conceptScheme );

		return this;
	}

	/**
	 * @return The list of broader Concepts of this Concept.
	 */
	public List<Concept> getBroader()
	{
		return broader;
	}

	/**
	 * Corresponds to skos:broader, which is used to express the hierarchical
	 * relations between the items. Sets the list of broader Concepts for this
	 * Concept.
	 * 
	 * @param broader
	 * @return This Concept object.
	 * @see {@link getBroader()}
	 */
	public Concept setBroader( final List<Concept> broader )
	{
		this.broader = broader;
		return this;
	}

	public Concept addBroader( final Concept concept )
	{
		if ( broader == null )
			broader = new ArrayList<Concept>();

		broader.add( concept );

		return this;
	}

	/**
	 * @return The list of narrower Concepts of this Concept.
	 */
	public List<Concept> getNarrower()
	{
		return narrower;
	}

	/**
	 * Corresponds to skos:narrower, which is used to express the hierarchical
	 * relations between the items. Sets the list of narrower Concepts for this
	 * Concept.
	 * 
	 * @param narrower
	 * @return This Concept object.
	 * @see {@link getNarrower()}
	 */
	public Concept setNarrower( final List<Concept> narrower )
	{
		this.narrower = narrower;
		return this;
	}

	public Concept addNarrower( final Concept concept )
	{
		if ( narrower == null )
			narrower = new ArrayList<Concept>();

		narrower.add( concept );

		return this;
	}

	/**
	 * Factory-method which returns an object of (sub-)type T with predefined
	 * <i>notation</i>.
	 * <p>
	 * Example code:
	 * <code>Concept.withNotation( Question.class, "question notation" );</code>
	 * </p>
	 * 
	 * @param notation
	 * @return The returned object is of superclass Concept. The concrete subclass
	 *         can be passed as an parameter.
	 */
	public static <T extends Concept> T withNotation( final Class<T> clazz, final String notation )
	{
		try
		{
			T c = clazz.newInstance();
			c.setNotation( notation );

			return c;
		}
		catch ( InstantiationException e )
		{
			return null;
		}
		catch ( IllegalAccessException e )
		{
			return null;
		}
	}

	/**
	 * Factory-method which returns an object of (sub-)type T with predefined
	 * <i>notation</i> and <i>prefLabel</i>. For instance, this method may be a
	 * convenient way to instantiate a Variable with a name and a label.
	 * <p>
	 * Example code:
	 * <code>Concept.withNotationAndPrefLabel( Variable.class, "EF1", "EF1 variable label" );</code>
	 * </p>
	 * 
	 * @param clazz
	 * @param notation
	 * @param prefLabel
	 * @return The returned object is of superclass Concept. The concrete subclass
	 *         can be passed as an parameter.
	 */
	public static <T extends Concept> T withNotationAndPrefLabel( final Class<T> clazz, final String notation,
			final LangString prefLabel )
	{
		try
		{
			T c = clazz.newInstance();
			c.setNotation( notation );
			c.setPrefLabel( prefLabel );

			return c;
		} catch ( InstantiationException e )
		{
			return null;
		} catch ( IllegalAccessException e )
		{
			return null;
		}
	}
}