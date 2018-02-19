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
	 * From the specification: A lexical label is a string of UNICODE characters,
	 * such as "romantic love", in a given natural language, such as English or
	 * Japanese (written here in hiragana).
	 * 
	 * @return The prefLabel of this Resource.
	 */
	public LangString getPrefLabel()
	{
		return this.prefLabel;
	}

	/**
	 * Corresponds to skos:prefLabel. Sets the prefLabel for this Resource.
	 * <p>
	 * The preferred and alternative labels are useful when generating or creating
	 * human-readable representations of a knowledge organization system. These
	 * labels provide the strongest clues as to the meaning of a SKOS concept.
	 * </p>
	 * 
	 * @param prefLabel
	 * @return this Resource object
	 * @see #getPrefLabel()
	 */
	public Resource setPrefLabel( final LangString prefLabel )
	{
		this.prefLabel = prefLabel;
		return this;
	}

	/**
	 * @return The versionInfo of this Resource.
	 */
	public String getVersionInfo()
	{
		return versionInfo;
	}

	/**
	 * Corresponds to owl:versionInfo. Sets the versionInfo for this Resource.
	 * 
	 * @param versionInfo
	 * @return this Resource object.
	 * @see #getVersionInfo()
	 */
	public Resource setVersionInfo( final String versionInfo )
	{
		this.versionInfo = versionInfo;
		return this;
	}

	/**
	 * In general, such {@link Identifier}s can be added to each entitiy in disco,
	 * since every entity is defined as an rdfs:{@link Resource}.
	 * 
	 * @return A list of {@link Identifier}s this resource is associated with.
	 * @see <a href=
	 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#identification">Identification</a>
	 */
	public List<Identifier> getIdentifier()
	{
		return identifier;
	}

	/**
	 * Corresponds to adms:identifier. Sets the list of Identifiers for this
	 * Resource.
	 * 
	 * @param identifier
	 * @see #getIdentifier()
	 */
	public void setIdentifier( final List<Identifier> identifier )
	{
		this.identifier = identifier;
	}

	/**
	 * Factory-method which returns an object of (sub-)type T with predefined
	 * <i>prefLabel</i>.
	 * 
	 * <p>
	 * Example code:
	 * <code>Resource.withPrefLabel( Questionnaire.class, LangString.withLocaleAndValue( Locale.UK, "name of questionnaire" ) );</code>
	 * </p>
	 * 
	 * @param clazz
	 * @param prefLabel
	 * @return The returned object is of superclass Resource. The concreate subclass
	 *         can be passed as an parameter.
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
