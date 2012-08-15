package org.gesis.ddi;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Identifiable {

	// properties

	@Column
	@Id
	// TODO zl implement generator for URN consisting of agencyId + objectId + version
	private String URN;

	@Column
	private String agencyId;

	@Column
	private String objectId;

	@Column
	private String majorVersion;

	@Column
	private String minorVersion;

	// relations

	@ManyToMany
	private Set<Note> note;

	// getter/setter

	public String getURN() {
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

	public String getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}

	public String getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}

	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

}
