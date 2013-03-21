package org.gesis.rdf;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LangString
{

	@Id
	@GeneratedValue
	private int id;

	@Column( unique = true, name = "key_" )
	private String key;

	@Column
	private String de_DE;

	@Column
	private String en_US;

	@Column
	private String fr_FR;

	public LangString()
	{

	}

	public LangString( String key, String de )
	{
		this.key = key;
		this.de_DE = de;
	}

	public LangString( String key, String de, String en )
	{
		this( key, de );
		this.en_US = en;
	}

	public LangString( String key, String de, String en, String fr )
	{
		this( key, de, en );
		this.fr_FR = fr;
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getKey_()
	{
		return key;
	}

	public void setKey_( String key )
	{
		this.key = key;
	}

	public String getDe_DE()
	{
		return de_DE;
	}

	public void setDe_DE( String de )
	{
		this.de_DE = de;
	}

	public String getEn_US()
	{
		return en_US;
	}

	public void setEn_US( String en )
	{
		this.en_US = en;
	}

	public String getFr_FR()
	{
		return fr_FR;
	}

	public void setFr_FR( String fr )
	{
		this.fr_FR = fr;
	}

	public String getMessage( Locale locale )
	{
		if ( locale == null || locale.getLanguage() == null )
			return null;

		if ( locale.getLanguage().equals( Locale.GERMAN.getLanguage() ) )
			return de_DE;
		else if ( locale.getLanguage().equals( Locale.ENGLISH.getLanguage() ) )
			return en_US;
		else
			return fr_FR;
	}
}
