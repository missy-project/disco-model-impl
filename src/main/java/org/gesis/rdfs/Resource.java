package org.gesis.rdfs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.gesis.adms.Identifier;
import org.gesis.persistence.PersistableResource;
import org.gesis.rdf.LangString;

/**
 * In disco, every entity is defined as an rdfs:Resource.
 * 
 * Extends {@link PersistableResource} with rdfs:Resource specific properties.
 * 
 * @author matthaeus
 *
 */
@MappedSuperclass
public class Resource extends PersistableResource
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@Column
	private String versionInfo;

	// relations

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "resource_id" )
	private List<Identifier> identifier;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString prefLabel;

	// getter/setter

	public Resource()
	{
		super();
	}

	/**
	 * <p>
	 * Corresponds to skos:prefLabel.
	 * </p>
	 * 
	 * <p>
	 * From the specification: <i>"A lexical label is a string of UNICODE
	 * characters, such as "romantic love", in a given natural language, such as
	 * English or Japanese (written here in hiragana). <br>
	 * <br>
	 * The preferred and alternative labels are useful when generating or creating
	 * human-readable representations of a knowledge organization system. These
	 * labels provide the strongest clues as to the meaning of a SKOS concept."</i>
	 * </p>
	 * 
	 * @return The prefLabel of this Resource.
	 */
	public LangString getPrefLabel()
	{
		return this.prefLabel;
	}

	/**
	 * Sets the prefLabel for this Resource.
	 * 
	 * @param prefLabel
	 * @return this Resource object
	 * @see {@link getPrefLabel()}
	 */
	public Resource setPrefLabel( final LangString prefLabel )
	{
		this.prefLabel = prefLabel;
		return this;
	}

	/**
	 * Corresponds to owl:versionInfo
	 * 
	 * @return
	 */
	public String getVersionInfo()
	{
		return versionInfo;
	}

	/**
	 * Sets the versionInfo for this Resource.
	 * 
	 * @param versionInfo
	 * @return this Resource object.
	 * @see {@link getVersionInfo()}
	 */
	public Resource setVersionInfo( final String versionInfo )
	{
		this.versionInfo = versionInfo;
		return this;
	}

	/**
	 * <p>
	 * Corresponds to adms:identifier.
	 * </p>
	 * <p>
	 * In general, such {@link Identifiers} can be added to each entitiy in disco,
	 * since every entity is defined as an rdfs:{@link Resource}.
	 * </p>
	 * 
	 * @see http://rdf-vocabulary.ddialliance.org/discovery.html#identification
	 * 
	 * @return A list of {@link Identifiers} this resource is associated with.
	 */
	public List<Identifier> getIdentifier()
	{
		return identifier;
	}

	/**
	 * Sets the list of Identifiers for this Resource.
	 * 
	 * @param identifier
	 * @see {@link getIdentifier()}
	 */
	public void setIdentifier( final List<Identifier> identifier )
	{
		this.identifier = identifier;
	}

	/**
	 * Factory-method which returns an object of type T (of Class-type
	 * <i>clazz</i>) with predefined <i>prefLabel</i>. The returned object is of
	 * superclass Resource. The concreate subclass can be passed as an
	 * parameter. <br>
	 * <br>
	 * E.g.
	 * <code>Resource.withPrefLabel( Questionnaire.class, LangString.withLocaleAndValue( Locale.UK, "name of questionnaire" ) );</code>
	 * 
	 * @param clazz
	 * @param prefLabel
	 * @return
	 */
	public static <T extends Resource> T withPrefLabel( final Class<T> clazz, final LangString prefLabel )
	{
		try
		{
			T resource = clazz.newInstance();
			resource.setPrefLabel( prefLabel );

			return resource;
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
}
