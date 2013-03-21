package org.gesis.ddi.ontology;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.foaf.Agent;
import org.gesis.foaf.Document;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@MappedSuperclass
public abstract class Union_StudyGroupStudy extends Resource
{
	// properties

	public Union_StudyGroupStudy( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	@OneToOne
	private LangString dcterms_abstract;

	@OneToOne
	private LangString dcterms_alternative;

	@Column
	private Date dcterms_available;

	@OneToOne
	private LangString dcterms_title;

	@OneToOne
	private LangString purpose;

	@OneToOne
	private LangString subtitle;

	// relations

	@ManyToMany
	@JoinTable( 
			name = "Union_StudyGroupStudy", 
			joinColumns = @JoinColumn( name = "union_id" ), 
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	private Set<PeriodOfTime> dcterms_temporal;

	@ManyToMany
	@JoinTable( 
			name = "Union_StudyGroupStudy", 
			joinColumns = @JoinColumn( name = "union_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	private Set<Concept> dcterms_subject;

	@ManyToMany
	@JoinTable( 
			name = "Union_StudyGroupStudy", 
			joinColumns = @JoinColumn( name = "union_id" ), 
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	private Set<Location> dcterms_spacial;

	@ManyToMany
	@JoinTable( 
			name = "Union_StudyGroupStudy", 
			joinColumns = @JoinColumn( name = "union_id" ), 
			inverseJoinColumns = @JoinColumn( name = "document_id" ) )
	private Set<Document> ddiFile;

	@ManyToOne
	@JoinColumn( name="concept_id" )
	private Concept kindOfData;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Union_StudyGroupStudy", 
			joinColumns = @JoinColumn( name = "union_id" ), 
			inverseJoinColumns = @JoinColumn( name = "analysisUnit_id" ) )
	protected Set<AnalysisUnit> analysisUnit;
	
	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Union_StudyGroupStudy", 
			joinColumns = @JoinColumn( name = "union_id" ), 
			inverseJoinColumns = @JoinColumn( name = "universe_id" ) )
	protected Set<Universe> universe;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Study_Agent", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "publisher_id" ) )
	protected Set<Agent> dcterms_publisher;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Study_Agent", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "contributor_id" ) )
	protected Set<Agent> dcterms_contributer;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Study_Agent", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "creator_id" ) )
	protected Set<Agent> dcterms_creator;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Study_Agent", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "fundedBy_id" ) )
	protected Set<Agent> fundedBy;

	// getter/setter

	public LangString getDcterms_abstract()
	{
		return dcterms_abstract;
	}

	public void setDcterms_abstract( LangString dcterms_abstract )
	{
		this.dcterms_abstract = dcterms_abstract;
	}

	public LangString getDcterms_alternative()
	{
		return dcterms_alternative;
	}

	public void setDcterms_alternative( LangString dcterms_alternative )
	{
		this.dcterms_alternative = dcterms_alternative;
	}

	public Date getDcterms_available()
	{
		return dcterms_available;
	}

	public void setDcterms_available( Date dcterms_available )
	{
		this.dcterms_available = dcterms_available;
	}

	public LangString getDcterms_title()
	{
		return dcterms_title;
	}

	public void setDcterms_title( LangString dcterms_title )
	{
		this.dcterms_title = dcterms_title;
	}

	public LangString getPurpose()
	{
		return purpose;
	}

	public void setPurpose( LangString purpose )
	{
		this.purpose = purpose;
	}

	public LangString getSubtitle()
	{
		return subtitle;
	}

	public void setSubtitle( LangString subtitle )
	{
		this.subtitle = subtitle;
	}

	public Set<PeriodOfTime> getDcterms_temporal()
	{
		return dcterms_temporal;
	}

	public void setDcterms_temporal( Set<PeriodOfTime> dcterms_temporal )
	{
		this.dcterms_temporal = dcterms_temporal;
	}

	public Set<Concept> getDcterms_subject()
	{
		return dcterms_subject;
	}

	public void setDcterms_subject( Set<Concept> dcterms_subject )
	{
		this.dcterms_subject = dcterms_subject;
	}

	public Set<Location> getDcterms_spacial()
	{
		return dcterms_spacial;
	}

	public void setDcterms_spacial( Set<Location> dcterms_spacial )
	{
		this.dcterms_spacial = dcterms_spacial;
	}

	public Set<Document> getDdiFile()
	{
		return ddiFile;
	}

	public void setDdiFile( Set<Document> ddiFile )
	{
		this.ddiFile = ddiFile;
	}

	public Concept getKindOfData()
	{
		return kindOfData;
	}

	public void setKindOfData( Concept kindOfData )
	{
		this.kindOfData = kindOfData;
	}

	public Set<Universe> getUniverse()
	{
		return universe;
	}

	public void setUniverse( Set<Universe> universe )
	{
		this.universe = universe;
	}

	public Set<AnalysisUnit> getAnalysisUnit()
	{
		return analysisUnit;
	}

	public void setAnalysisUnit( Set<AnalysisUnit> analysisUnit )
	{
		this.analysisUnit = analysisUnit;
	}

	public Set<Agent> getDcterms_publisher()
	{
		return this.dcterms_publisher;
	}

	public void setDcterms_publisher( Set<Agent> publisher )
	{
		this.dcterms_publisher = publisher;
	}

	public Set<Agent> getDcterms_contributer()
	{
		return this.dcterms_contributer;
	}

	public void setDcterms_contributer( Set<Agent> contributor )
	{
		this.dcterms_contributer = contributor;
	}

	public Set<Agent> getDcterms_creator()
	{
		return this.dcterms_creator;
	}

	public void setDcterms_creator( Set<Agent> creator )
	{
		this.dcterms_creator = creator;
	}

	public Set<Agent> getFundedBy()
	{
		return fundedBy;
	}

	public void setFundedBy( Set<Agent> fundedBy )
	{
		this.fundedBy = fundedBy;
	}

}
