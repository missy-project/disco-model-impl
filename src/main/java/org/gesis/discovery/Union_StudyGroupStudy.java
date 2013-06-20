package org.gesis.discovery;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.Identifiable;
import org.gesis.foaf.Agent;
import org.gesis.foaf.Document;
import org.gesis.rdf.LangString;
import org.gesis.skos.Concept;

@MappedSuperclass
public abstract class Union_StudyGroupStudy extends Identifiable
{
	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString dcterms_abstract;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString dcterms_alternative;

	@Column
	private Date dcterms_available;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString dcterms_title;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString purpose;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString subtitle;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Set<PeriodOfTime> dcterms_temporal;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Set<Concept> dcterms_subject;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Set<Location> dcterms_spacial;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Set<Document> ddiFile;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name="concept_id" )
	private Concept kindOfData;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected Set<AnalysisUnit> analysisUnit;
	
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected Set<Universe> universe;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected Set<Agent> dcterms_publisher;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected Set<Agent> dcterms_contributer;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected Set<Agent> dcterms_creator;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected Set<Agent> fundedBy;

	// getter/setter

	public LangString getDcterms_abstract()
	{
		return this.dcterms_abstract;
	}

	public void setDcterms_abstract( final LangString dcterms_abstract )
	{
		this.dcterms_abstract = dcterms_abstract;
	}

	public LangString getDcterms_alternative()
	{
		return this.dcterms_alternative;
	}

	public void setDcterms_alternative( final LangString dcterms_alternative )
	{
		this.dcterms_alternative = dcterms_alternative;
	}

	public Date getDcterms_available()
	{
		return this.dcterms_available;
	}

	public void setDcterms_available( final Date dcterms_available )
	{
		this.dcterms_available = dcterms_available;
	}

	public LangString getDcterms_title()
	{
		return this.dcterms_title;
	}

	public void setDcterms_title( final LangString dcterms_title )
	{
		this.dcterms_title = dcterms_title;
	}

	public LangString getPurpose()
	{
		return this.purpose;
	}

	public void setPurpose( final LangString purpose )
	{
		this.purpose = purpose;
	}

	public LangString getSubtitle()
	{
		return this.subtitle;
	}

	public void setSubtitle( final LangString subtitle )
	{
		this.subtitle = subtitle;
	}

	public Set<PeriodOfTime> getDcterms_temporal()
	{
		return this.dcterms_temporal;
	}

	public void setDcterms_temporal( final Set<PeriodOfTime> dcterms_temporal )
	{
		this.dcterms_temporal = dcterms_temporal;
	}

	public Union_StudyGroupStudy addDcterms_temporal( final PeriodOfTime periodOfTime )
	{
		if ( this.dcterms_temporal == null )
			this.dcterms_temporal = new HashSet<PeriodOfTime>();

		this.dcterms_temporal.add( periodOfTime );

		return this;
	}

	public Set<Concept> getDcterms_subject()
	{
		return this.dcterms_subject;
	}

	public void setDcterms_subject( final Set<Concept> dcterms_subject )
	{
		this.dcterms_subject = dcterms_subject;
	}

	public Union_StudyGroupStudy addDcterms_subject( final Concept concept )
	{
		if ( this.dcterms_subject == null )
			this.dcterms_subject = new HashSet<Concept>();

		this.dcterms_subject.add( concept );

		return this;
	}

	public Set<Location> getDcterms_spacial()
	{
		return this.dcterms_spacial;
	}

	public void setDcterms_spacial( final Set<Location> dcterms_spacial )
	{
		this.dcterms_spacial = dcterms_spacial;
	}

	public Union_StudyGroupStudy addDcterms_spatial( final Location location )
	{
		if ( this.dcterms_spacial == null )
			this.dcterms_spacial = new HashSet<Location>();

		this.dcterms_spacial.add( location );

		return this;
	}

	public Set<Document> getDdiFile()
	{
		return this.ddiFile;
	}

	public void setDdiFile( final Set<Document> ddiFile )
	{
		this.ddiFile = ddiFile;
	}

	public Union_StudyGroupStudy addDdiFile( final Document document )
	{
		if ( this.ddiFile == null )
			this.ddiFile = new HashSet<Document>();

		this.ddiFile.add( document );

		return this;
	}

	public Concept getKindOfData()
	{
		return this.kindOfData;
	}

	public void setKindOfData( final Concept kindOfData )
	{
		this.kindOfData = kindOfData;
	}

	public Set<Universe> getUniverse()
	{
		return this.universe;
	}

	public void setUniverse( final Set<Universe> universe )
	{
		this.universe = universe;
	}

	public Union_StudyGroupStudy addUniverse( final Universe universe )
	{
		if ( this.universe == null )
			this.universe = new HashSet<Universe>();

		this.universe.add( universe );

		return this;
	}

	public Set<AnalysisUnit> getAnalysisUnit()
	{
		return this.analysisUnit;
	}

	public void setAnalysisUnit( final Set<AnalysisUnit> analysisUnit )
	{
		this.analysisUnit = analysisUnit;
	}

	public Union_StudyGroupStudy addAnalysisUnit( final AnalysisUnit analysisUnit )
	{
		if ( this.analysisUnit == null )
			this.analysisUnit = new HashSet<AnalysisUnit>();

		this.analysisUnit.add( analysisUnit );

		return this;
	}

	public Set<Agent> getDcterms_publisher()
	{
		return this.dcterms_publisher;
	}

	public void setDcterms_publisher( final Set<Agent> publisher )
	{
		this.dcterms_publisher = publisher;
	}

	public Union_StudyGroupStudy addDcterms_publisher( final Agent agent )
	{
		if ( this.dcterms_publisher == null )
			this.dcterms_publisher = new HashSet<Agent>();

		this.dcterms_publisher.add( agent );

		return this;
	}

	public Set<Agent> getDcterms_contributer()
	{
		return this.dcterms_contributer;
	}

	public void setDcterms_contributer( final Set<Agent> contributor )
	{
		this.dcterms_contributer = contributor;
	}

	public Union_StudyGroupStudy addDcterms_contributor( final Agent agent )
	{
		if ( this.dcterms_contributer == null )
			this.dcterms_contributer = new HashSet<Agent>();

		this.dcterms_contributer.add( agent );

		return this;
	}

	public Set<Agent> getDcterms_creator()
	{
		return this.dcterms_creator;
	}

	public void setDcterms_creator( final Set<Agent> creator )
	{
		this.dcterms_creator = creator;
	}

	public Union_StudyGroupStudy addDcterms_creator( final Agent agent )
	{
		if ( this.dcterms_creator == null )
			this.dcterms_creator = new HashSet<Agent>();

		this.dcterms_creator.add( agent );

		return this;
	}

	public Set<Agent> getFundedBy()
	{
		return this.fundedBy;
	}

	public void setFundedBy( final Set<Agent> fundedBy )
	{
		this.fundedBy = fundedBy;
	}

	public Union_StudyGroupStudy addFundedBy( final Agent agent )
	{
		if ( this.fundedBy == null )
			this.fundedBy = new HashSet<Agent>();

		this.fundedBy.add( agent );

		return this;
	}

}
