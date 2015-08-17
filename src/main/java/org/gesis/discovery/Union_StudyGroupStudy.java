package org.gesis.discovery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.gesis.foaf.Document;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@MappedSuperclass
public abstract class Union_StudyGroupStudy extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "abstract_id" )
	private LangString abstract_;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString alternative;

	@Column
	private Date available;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString title;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString purpose;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString subtitle;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<PeriodOfTime> temporal;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<Concept> subject;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<Location> spacial;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<Document> ddiFile;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "concept_id" )
	private Concept kindOfData;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<AnalysisUnit> analysisUnit;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<Universe> universe;

	/* For relationships to Agent please see the corresponding subtypes. */

	// getter/setter

	public LangString getAbstract()
	{
		return abstract_;
	}

	public void setAbstract( final LangString abstract_ )
	{
		this.abstract_ = abstract_;
	}

	public LangString getAlternative()
	{
		return alternative;
	}

	public void setAlternative( final LangString alternative )
	{
		this.alternative = alternative;
	}

	public Date getAvailable()
	{
		return available;
	}

	public void setAvailable( final Date available )
	{
		this.available = available;
	}

	public LangString getTitle()
	{
		return title;
	}

	public void setTitle( final LangString title )
	{
		this.title = title;
	}

	public LangString getPurpose()
	{
		return purpose;
	}

	public void setPurpose( final LangString purpose )
	{
		this.purpose = purpose;
	}

	public LangString getSubtitle()
	{
		return subtitle;
	}

	public void setSubtitle( final LangString subtitle )
	{
		this.subtitle = subtitle;
	}

	public List<PeriodOfTime> getTemporal()
	{
		return temporal;
	}

	public void setTemporal( final List<PeriodOfTime> temporal )
	{
		this.temporal = temporal;
	}

	public Union_StudyGroupStudy addTemporal( final PeriodOfTime periodOfTime )
	{
		if ( temporal == null )
			temporal = new ArrayList<PeriodOfTime>();

		temporal.add( periodOfTime );

		return this;
	}

	public List<Concept> getSubject()
	{
		return subject;
	}

	public void setSubject( final List<Concept> subject )
	{
		this.subject = subject;
	}

	public Union_StudyGroupStudy addSubject( final Concept concept )
	{
		if ( subject == null )
			subject = new ArrayList<Concept>();

		subject.add( concept );

		return this;
	}

	public List<Location> getSpacial()
	{
		return spacial;
	}

	public void setSpacial( final List<Location> spacial )
	{
		this.spacial = spacial;
	}

	public Union_StudyGroupStudy addSpatial( final Location location )
	{
		if ( spacial == null )
			spacial = new ArrayList<Location>();

		spacial.add( location );

		return this;
	}

	public List<Document> getDdiFile()
	{
		return ddiFile;
	}

	public void setDdiFile( final List<Document> ddiFile )
	{
		this.ddiFile = ddiFile;
	}

	public Union_StudyGroupStudy addDdiFile( final Document document )
	{
		if ( ddiFile == null )
			ddiFile = new ArrayList<Document>();

		ddiFile.add( document );

		return this;
	}

	public Concept getKindOfData()
	{
		return kindOfData;
	}

	public void setKindOfData( final Concept kindOfData )
	{
		this.kindOfData = kindOfData;
	}

	public List<Universe> getUniverse()
	{
		return universe;
	}

	public void setUniverse( final List<Universe> universe )
	{
		this.universe = universe;
	}

	public Union_StudyGroupStudy addUniverse( final Universe universe )
	{
		if ( this.universe == null )
			this.universe = new ArrayList<Universe>();

		this.universe.add( universe );

		return this;
	}

	public List<AnalysisUnit> getAnalysisUnit()
	{
		return analysisUnit;
	}

	public void setAnalysisUnit( final List<AnalysisUnit> analysisUnit )
	{
		this.analysisUnit = analysisUnit;
	}

	public Union_StudyGroupStudy addAnalysisUnit( final AnalysisUnit analysisUnit )
	{
		if ( this.analysisUnit == null )
			this.analysisUnit = new ArrayList<AnalysisUnit>();

		this.analysisUnit.add( analysisUnit );

		return this;
	}

}
