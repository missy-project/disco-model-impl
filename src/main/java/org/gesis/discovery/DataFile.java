package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.gesis.dcterms.Location;
import org.gesis.dcterms.MediaTypeOrExtend;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.dcterms.ProvenanceStatement;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

/**
 * The collected data of a Study results in the microdata represented by the
 * DataFile. Data sets have a logical representation, which describes the
 * contents of the data set, and a physical representation, which is a
 * distributed file holding that data. It is possible to format data files in
 * many different ways, even if the logical content is the same. data files
 * (DataFile), which are also dcterms:Datasets as well as dcat:Distributions,
 * represents all the physical distributed data files containing the microdata
 * datasets.
 * 
 * <p>
 * It is possible to describe data files (DataFile) (dcterms:description). Data
 * files (DataFile), case quantities (disco:caseQuantity) and versions
 * (owl:versionInfo) can also be stated. Using the object property
 * dcterms:format, data files (DataFile) formats can be defined.
 * </p>
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#datafile}
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class DataFile extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString description;

	@Column
	private int caseQuantity;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_ProvenanceStatement",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "provenanceStatement_id" ) )
	private List<ProvenanceStatement> provenance;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_Location",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	protected List<Location> spatial;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_PeriodOfTime",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	protected List<PeriodOfTime> temporal;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DataFile_Concept",
			joinColumns = @JoinColumn( name = "dataFile_id" ),
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected List<Concept> subject;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "mediaTypeOrExtend_id" )
	protected MediaTypeOrExtend format;

	// getter/setter

	/**
	 * @return The description of this DataFile.
	 */
	public LangString getDescription()
	{
		return description;
	}

	/**
	 * Corresponds to dcterms:description.
	 * 
	 * @param description
	 * @return This DateFile object.
	 * @see {@link getDescription()}
	 */
	public DataFile setDescription( final LangString description )
	{
		this.description = description;
		return this;
	}

	/**
	 * @return The case quantity of this DataFile.
	 * @see {@link LogicalDataSet}
	 */
	public int getCaseQuantity()
	{
		return caseQuantity;
	}

	/**
	 * Corresponds to disco:caseQuantity. Just like there is variableQuantity on the
	 * {@link LogicalDataSet} there is also caseQuantity on this DataFile. This is
	 * useful to have when (1) no variable level information is available and when
	 * (2) only a stub of the RDF is requested e.g when returning basic information
	 * on a study of file, we do not need to return information on potentially
	 * hundreds or thousands of variables references or metadata.
	 * 
	 * @param caseQuantity
	 * @return This DataFile object.
	 * @see {@link getCaseQuantity()}
	 */
	public DataFile setCaseQuantity( final int caseQuantity )
	{
		this.caseQuantity = caseQuantity;
		return this;
	}

	/**
	 * @return The list of geographical coverages (Location) this DataFile is
	 *         attached to.
	 * @see {@link Location}
	 */
	public List<Location> getSpatial()
	{
		return spatial;
	}

	/**
	 * Corresponds to dcterms:spatial. For a DataFile the three dimensions of
	 * coverage can be specified: Spatial (dcterms:spatial), temporal
	 * (dcterms:temporal), and topical (dcterms:subject).
	 * 
	 * @param spatial
	 * @return This DataFile object.
	 * @see {@link getSpatial()}
	 */
	public void setSpatial( final List<Location> spatial )
	{
		this.spatial = spatial;
	}

	public DataFile addSpatial( final Location location )
	{
		if ( spatial == null )
			spatial = new ArrayList<Location>();

		spatial.add( location );

		return this;
	}

	/**
	 * @return The list of temporal coverages (PeriodOfTime) this DataFile is
	 *         attached to.
	 * @see {@link PeriodOfTime}
	 */
	public List<PeriodOfTime> getTemporal()
	{
		return temporal;
	}

	/**
	 * Corresponds to dcterms:temporal. For a DataFile the three dimensions of
	 * coverage can be specified: Spatial (dcterms:spatial), temporal
	 * (dcterms:temporal), and topical (dcterms:subject).
	 * 
	 * @param temporal
	 * @return This DataFile object. {@link getTemporal()}
	 * @see {@link getTemporal()}
	 */
	public void setTemporal( final List<PeriodOfTime> temporal )
	{
		this.temporal = temporal;
	}

	public DataFile addTemporal( final PeriodOfTime periodOfTime )
	{
		if ( temporal == null )
			temporal = new ArrayList<PeriodOfTime>();

		temporal.add( periodOfTime );

		return this;
	}

	/**
	 * @return The list of topical coverages (Concept) this DataFile is attached to.
	 * @see {@link Concept}
	 */
	public List<Concept> getSubject()
	{
		return subject;
	}

	/**
	 * Corresponds to dcterms:subject. For a DataFile the three dimensions of
	 * coverage can be specified: Spatial (dcterms:spatial), temporal
	 * (dcterms:temporal), and topical (dcterms:subject).
	 * 
	 * @param subject
	 * @return This DataFile object.
	 * @see {@link getSubject()}
	 */
	public void setSubject( final List<Concept> subject )
	{
		this.subject = subject;
	}

	public DataFile addSubject( final Concept concept )
	{
		if ( subject == null )
			subject = new ArrayList<Concept>();

		subject.add( concept );

		return this;
	}

	/**
	 * @return The list of ProvenanceStatement attached to this DataFile.
	 * @see {@link ProvenanceStatement}
	 */
	public List<ProvenanceStatement> getProvenance()
	{
		return provenance;
	}

	/**
	 * Corresponds to dcterms:provenance. Defines the provenance information for
	 * this data file.
	 * 
	 * @param provenance
	 * @return This DataFile object.
	 * @see {@link getProvenanceStatement()}
	 */
	public DataFile setProvenance( final List<ProvenanceStatement> provenance )
	{
		this.provenance = provenance;
		return this;
	}

	public DataFile addProvenance( final ProvenanceStatement provenanceStatement )
	{
		if ( this.provenance == null )
			this.provenance = new ArrayList<ProvenanceStatement>();

		this.provenance.add( provenanceStatement );

		return this;
	}

	/**
	 * @return The format for this DataFile.
	 */
	public MediaTypeOrExtend getFormat()
	{
		return format;
	}

	/**
	 * Corresponds to dcterms:format.
	 * 
	 * @param format
	 * @return This DataFile object.
	 * @see {@link getFormat()}
	 */
	public DataFile setFormat( final MediaTypeOrExtend format )
	{
		this.format = format;
		return this;
	}

}
