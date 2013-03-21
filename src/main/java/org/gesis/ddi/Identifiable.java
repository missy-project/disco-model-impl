package org.gesis.ddi;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name="Identifiable_Note",
			joinColumns=@JoinColumn(name="identifiable_id"),
			inverseJoinColumns=@JoinColumn( name = "note_id" ))
	private Set<Note> note;

	// getter/setter

	public Identifiable( String agencyId, String objectId, int majorVersion )
	{
		super();
		this.agencyId = agencyId;
		this.objectId = objectId;
		this.majorVersion = majorVersion;

		this.URN = URNBuilder.buildFrom( this );
	}

	public String getURN()
	{
		return URN;
	}

	public void setURN(String uRN) {
		URN = uRN;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public int getMajorVersion()
	{
		return majorVersion;
	}

	public void setMajorVersion( int majorVersion )
	{
		this.majorVersion = majorVersion;
	}

	public int getMinorVersion()
	{
		return minorVersion;
	}

	public void setMinorVersion( int minorVersion )
	{
		this.minorVersion = minorVersion;
	}

	public Set<Note> getNote()
	{
		return note;
	}

	public void setNote(Set<Note> note)
	{
		this.note = note;
	}

}
