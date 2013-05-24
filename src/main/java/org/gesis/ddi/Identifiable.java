package org.gesis.ddi;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.gesis.ddi.util.URNBuilder;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Identifiable
{

	// properties

	@Column
	@Id
	private String URN;

	@Column( nullable = false )
	private String agencyId;

	@Column( nullable = false )
	private String objectId;

	@Column( nullable = false )
	private int majorVersion;

	@Column( nullable = false, updatable = false )
	@Version
	private int minorVersion;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Identifiable_Note", 
			joinColumns = @JoinColumn( name = "identifiable_id" ), 
			inverseJoinColumns = @JoinColumn( name = "note_id" ) )
	private Set<Note> note;

	// getter/setter

	public Identifiable( final String agencyId, final String objectId, final int majorVersion )
	{
		super();
		this.agencyId = agencyId;
		this.objectId = objectId;
		this.majorVersion = majorVersion;

		this.URN = URNBuilder.buildFrom( this );
	}

	public String getURN()
	{
		return this.URN;
	}

	public void setURN( final String uRN )
	{
		this.URN = uRN;
	}

	public String getAgencyId()
	{
		return this.agencyId;
	}

	public void setAgencyId( final String agencyId )
	{
		this.agencyId = agencyId;
	}

	public String getObjectId()
	{
		return this.objectId;
	}

	public void setObjectId( final String objectId )
	{
		this.objectId = objectId;
	}

	public int getMajorVersion()
	{
		return this.majorVersion;
	}

	public void setMajorVersion( final int majorVersion )
	{
		this.majorVersion = majorVersion;
	}

	public int getMinorVersion()
	{
		return this.minorVersion;
	}

	public void setMinorVersion( final int minorVersion )
	{
		this.minorVersion = minorVersion;
	}

	public Identifiable addNote( final Note note )
	{
		if ( this.note == null )
			this.note = new LinkedHashSet<Note>();

		this.note.add( note );

		return this;
	}

	public Set<Note> getNote()
	{
		return this.note;
	}

	public void setNote( final Set<Note> note )
	{
		this.note = note;
	}

}
