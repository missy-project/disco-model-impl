package org.gesis.skos;

import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.gesis.rdf.List;
import org.gesis.rdfs.Resource;

@Entity
public class OrderedCollection extends LinkedHashSet<Resource> implements Collection
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1983493043919178783L;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List skos_memberList;
}
