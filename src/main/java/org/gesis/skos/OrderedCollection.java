package org.gesis.skos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.gesis.ddi.util.IdentifierFactory;
import org.gesis.discovery.Representation;
import org.gesis.rdf.List;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class OrderedCollection extends Representation
{

	// properties

	@Column
	@Id
	private String id;

	@Column
	private String urn;

	// relations

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List memberList;

	// getter / setter

	public OrderedCollection()
	{
		id = IdentifierFactory.getNextDefaultIdentifier();
	}

	public List getMemberList()
	{
		return memberList;
	}

	public void setMemberList( final List memberList )
	{
		this.memberList = memberList;
	}

	@Override
	public String getId()
	{
		return id;
	}

	public void setId( final String id )
	{
		this.id = id;
	}

	@Override
	public String getURN()
	{
		return urn;
	}

	public void setUrn( final String urn )
	{
		this.urn = urn;
	}

}
