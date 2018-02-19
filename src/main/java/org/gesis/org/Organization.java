package org.gesis.org;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.gesis.foaf.Agent;
import org.gesis.rdf.LangString;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Organization extends Agent
{

	// properties

	private static final long serialVersionUID = -9153662811977414544L;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString altLabel;

	@Column
	private String notation;

	// getter / setter

	/**
	 * Corresponds to skos:altLabel. <br>
	 * <br>
	 * From the specification: <br>
	 * <i>"A lexical label is a string of UNICODE characters ... <br>
	 * <br>
	 * The preferred and alternative labels are useful when generating or creating
	 * human-readable representations of a knowledge organization system. These
	 * labels provide the strongest clues as to the meaning of a SKOS concept."</i>
	 * 
	 * @return The altLabel of this Organization.
	 */
	public LangString getAltLabel()
	{
		return altLabel;
	}

	public void setAltLabel( final LangString altLabel )
	{
		this.altLabel = altLabel;
	}

	/**
	 * @return The notation of this Organization.
	 */
	public String getNotation()
	{
		return notation;
	}

	/**
	 * Corresponds to skos:notation. From the specification:
	 * <p>
	 * <i>"A notation is a string of characters such as "T58.5" or "303.4833" used
	 * to uniquely identify a concept within the scope of a given concept scheme.
	 * </p>
	 * <p>
	 * A notation is different from a lexical label in that a notation is not
	 * normally recognizable as a word or sequence of words in any natural
	 * language."</i>
	 * </p>
	 * 
	 * @param notation
	 * @return This Organization object.
	 * @see #getNotation()
	 */
	public Organization setNotation( final String notation )
	{
		this.notation = notation;
		return this;
	}

}
