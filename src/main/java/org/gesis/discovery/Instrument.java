package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.gesis.foaf.Document;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;

/**
 * The data for the study are collected by an instrument. The purpose of an
 * Instrument, i.e. an interview, a questionnaire or another entity used as a
 * means of data collection, is in the case of a survey to record the flow of a
 * questionnaire, its use of questions, and additional component parts.
 * 
 * @author matthaeus
 * @see http://rdf-vocabulary.ddialliance.org/discovery.html#instrument
 *
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Instrument extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString description;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Instrument_Document",
			joinColumns = @JoinColumn( name = "instrument_id" ),
			inverseJoinColumns = @JoinColumn( name = "document_id" ) )
	protected List<Document> externalDocumentation;

	// getter/setter

	/**
	 * <p>
	 * Corresponds to dcterms:description.
	 * </p>
	 * <p>
	 * Instruments can be labeled and described using dcterms:description and
	 * skos:prefLabel.
	 * </p>
	 * 
	 * @return The description of this Instrument.
	 * @see {@link setDescription()}
	 * @see {@link setPrefLabel()}
	 */
	public LangString getDescription()
	{
		return this.description;
	}

	/**
	 * <p>
	 * Sets the description of this Instrument.
	 * </p>
	 * 
	 * <p>
	 * Instruments can be labeled and described using dcterms:description and
	 * skos:prefLabel.
	 * </p>
	 * 
	 * @param description
	 * @see {@link setPrefLabel()}
	 */
	public void setDescription( final LangString description )
	{
		this.description = description;
	}

	/**
	 * Points from an {@link Instrument} to a {@link Document}, which is the
	 * external documentation of this {@link Instrument}.
	 * 
	 * @return The list of {@link Documents}s of this Instrument.
	 * @see http://rdf-vocabulary.ddialliance.org/discovery.html#dfn-disco-externaldocumentation
	 */
	public List<Document> getExternalDocumentation()
	{
		return this.externalDocumentation;
	}

	/**
	 * Sets the list of Documents for this Instrument.
	 * 
	 * @param externalDocumentation
	 * @see getExternalDocumentation()
	 */
	public void setExternalDocumentation( final List<Document> externalDocumentation )
	{
		this.externalDocumentation = externalDocumentation;
	}

	public Instrument addExternalDocumentation( final Document document )
	{
		if ( this.externalDocumentation == null )
			this.externalDocumentation = new ArrayList<Document>();

		this.externalDocumentation.add( document );

		return this;
	}

}