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
import javax.persistence.OneToMany;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Study extends Union_StudyGroupStudy
{

	// properties

	@Column
	private String owl_versionInfo;

	// relations

	@ManyToOne
	@JoinColumn( name = "studyGroup_id" )
	private StudyGroup inGroup;

	@ElementCollection
	@OneToMany
	@JoinTable( 
			name = "Study_Instrument", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "instrument_id" ) )
	protected Set<Instrument> instrument;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Study_Variable", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected Set<Variable> variable;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Study_DataFile", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected Set<DataFile> dataFile;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Study_LogicalDataSet", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "logicalDataSet_id" ) )
	protected Set<LogicalDataSet> product;

	// getter/setter

	public Study( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Set<Instrument> getInstrument()
	{
		return this.instrument;
	}

	public void setInstrument( Set<Instrument> instrument )
	{
		this.instrument = instrument;
	}

	public Set<Variable> getVariable()
	{
		return this.variable;
	}

	public void setVariable( Set<Variable> variable )
	{
		this.variable = variable;
	}

	public Set<DataFile> getDataFile()
	{
		return this.dataFile;
	}

	public void setDataFile( Set<DataFile> dataFile )
	{
		this.dataFile = dataFile;
	}

	public Set<LogicalDataSet> getProduct()
	{
		return this.product;
	}

	public void setProduct( Set<LogicalDataSet> product )
	{
		this.product = product;
	}

	public String getOwl_versionInfo()
	{
		return owl_versionInfo;
	}

	public void setOwl_versionInfo( String owl_versionInfo )
	{
		this.owl_versionInfo = owl_versionInfo;
	}

	public StudyGroup getInGroup()
	{
		return inGroup;
	}

	public void setInGroup( StudyGroup inGroup )
	{
		this.inGroup = inGroup;
	}

}