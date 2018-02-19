package org.gesis.skos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.gesis.discovery.Question;
import org.gesis.discovery.Representation;
import org.gesis.discovery.Variable;
import org.gesis.rdf.List;

/**
 * In DDI, {@link Variable}s, {@link Question}s, and {@link Concept}s are
 * typically organized themselves in a particular order. For obtaining this
 * order, this OrderedCollections are used. For example, a collection of
 * variables is represented as being of the type OrderedCollection containing
 * multiple {@link Variable}s (each represented as a {@link Concept}) in a
 * skos:memberList.
 * 
 * <p>
 * An ordered collection is a {@link Representation}.
 * </p>
 * 
 * @author matthaeus
 * @see org.gesis.discovery.Representation
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class OrderedCollection extends Representation
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	// relations

	@OneToOne( cascade = CascadeType.ALL )
	private List memberList;

	// getter / setter

	/**
	 * @return The list of members this OrderedCollection has.
	 * @see org.gesis.rdf.List
	 */
	public List getMemberList()
	{
		return memberList;
	}

	/**
	 * Corresponds to skos:memberList.
	 * 
	 * @param memberList
	 * @return This OrderedCollection object.
	 * @see #getMemberList()
	 */
	public OrderedCollection setMemberList( final List memberList )
	{
		this.memberList = memberList;
		return this;
	}

}
