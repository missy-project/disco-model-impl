package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.gesis.datacube.DataSet;
import org.gesis.dcterms.LicenseDocument;
import org.gesis.dcterms.Location;
import org.gesis.dcterms.PeriodOfTime;
import org.gesis.dcterms.RightsStatement;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class LogicalDataSet extends Resource
{

	// properties

	@OneToOne
	private LangString dcterms_title;

	@Column
	private int isPublic;

	// relations

	@ElementCollection
	@JoinTable( 
			name = "LogicalDataSet_Location", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "location_id" ) )
	protected Set<Location> dcterms_spatial;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_PeriodOfTime", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "periodOfTime_id" ) )
	protected Set<PeriodOfTime> dcterms_temporal;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_Concept", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "concept_id" ) )
	protected Set<Concept> dcterms_subject;

	@ManyToOne
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	@ElementCollection
	@ManyToMany
	@JoinTable(
			name = "LogicalDataSet_Instrument", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "instrument_id" ) )
	protected Set<Instrument> instrument;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_Variable", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected Set<Variable> containsVariable;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_DataFile", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected Set<DataFile> dataFile;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_DataSet", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataSet_id" ) )
	protected Set<DataSet> aggregation;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_LicenseDocument",
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ), 
			inverseJoinColumns = @JoinColumn( name = "licenseDocument_id" ) )
	protected Set<LicenseDocument> dcterms_license;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "LogicalDataSet_Document", 
			joinColumns = @JoinColumn( name = "logicalDataSet_id" ),
			inverseJoinColumns = @JoinColumn( name = "rightsStatement_id" ) )
	protected Set<RightsStatement> dcterms_accessRights;

	// getter/setter

	public LogicalDataSet( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public LangString getDcterms_title()
	{
		return dcterms_title;
	}

	public void setDcterms_title( LangString dcterms_title )
	{
		this.dcterms_title = dcterms_title;
	}

	public int isPublic()
	{
		return isPublic;
	}

	public void setPublic(int isPublic)
	{
		this.isPublic = isPublic;
	}

	public Universe getDataSetUniverse()
	{
		return universe;
	}

	public void setDataSetUniverse(Universe dataSetUniverse)
	{
		this.universe = dataSetUniverse;
	}

	public Set<Location> getDcterms_spatial()
	{
		return dcterms_spatial;
	}

	public void setDcterms_spatial( Set<Location> dcterms_spatial )
	{
		this.dcterms_spatial = dcterms_spatial;
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

	public Set<Instrument> getInstrument()
	{
		return this.instrument;
	}

	public Set<Variable> getContainsVariable()
	{
		return this.containsVariable;
	}

	public Set<DataFile> getDataFile()
	{
		return this.dataFile;
	}

	public Set<DataSet> getAggregation()
	{
		return this.aggregation;
	}

	public void setAggregation( Set<DataSet> aggregation )
	{
		this.aggregation = aggregation;
	}

	public Set<LicenseDocument> getDcterms_license()
	{
		return this.dcterms_license;
	}

	public Set<RightsStatement> getDcterms_accessRights()
	{
		return this.dcterms_accessRights;
	}

	public void setInstrument(Set<Instrument> instrument)
	{
		this.instrument = instrument;
	}

	public void setContainsVariable(Set<Variable> containsVariable)
	{
		this.containsVariable = containsVariable;
	}

	public void setDataFile(Set<DataFile> dataFile)
	{
		this.dataFile = dataFile;
	}

	public void setDataCube(Set<DataSet> dataCube)
	{
		this.aggregation = dataCube;
	}

	public void setDcterms_license( Set<LicenseDocument> dcterms_license )
	{
		this.dcterms_license = dcterms_license;
	}

	public void setDcterms_accessRights( Set<RightsStatement> dcterms_accessRights )
	{
		this.dcterms_accessRights = dcterms_accessRights;
	}

}