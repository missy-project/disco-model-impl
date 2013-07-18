package org.gesis.skos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.gesis.discovery.Representation;
import org.gesis.rdf.List;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class OrderedCollection extends Representation
{

	// properties

	// relations

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List memberList;

	// getter / setter

	public List getMemberList()
	{
		return memberList;
	}

	public void setMemberList( final List memberList )
	{
		this.memberList = memberList;
	}

}
