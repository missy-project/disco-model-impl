package org.gesis.skos;

import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.gesis.ddi.util.IdentifierFactory;
import org.gesis.persistence.IPersistableResource;
import org.gesis.rdf.List;
import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class OrderedCollection extends LinkedHashSet<Resource> implements Collection, IPersistableResource
{

	/**
	 *
	 */
	private static final long serialVersionUID = -1983493043919178783L;

	// properties

	@Column
	@Id
	private String id;

	@Column
	private String urn;

	// relations

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List skos_memberList;

	// getter / setter

	public OrderedCollection()
	{
		id = IdentifierFactory.getNextDefaultIdentifier();
	}

	public List getSkos_memberList()
	{
		return skos_memberList;
	}

	public void setSkos_memberList( final List skos_memberList )
	{
		this.skos_memberList = skos_memberList;
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
