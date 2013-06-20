package org.gesis.discovery;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToMany;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Study extends Union_StudyGroupStudy
{

	// properties

	@Column
	private String owl_versionInfo;

	// relations

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "studyGroup_id" )
	private StudyGroup inGroup;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Study_Instrument", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "instrument_id" ) )
	protected Set<Instrument> instrument;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Study_Variable", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	protected Set<Variable> variable;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Study_DataFile", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected Set<DataFile> dataFile;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Study_LogicalDataSet", 
			joinColumns = @JoinColumn( name = "study_id" ), 
			inverseJoinColumns = @JoinColumn( name = "logicalDataSet_id" ) )
	protected Set<LogicalDataSet> product;

	// getter/setter

	public Set<Instrument> getInstrument()
	{
		return this.instrument;
	}

	public void setInstrument( final Set<Instrument> instrument )
	{
		this.instrument = instrument;
	}

	public Study addInstrument( final Instrument instrument )
	{
		if ( this.instrument == null )
			this.instrument = new HashSet<Instrument>();

		this.instrument.add( instrument );

		return this;
	}

	public Set<Variable> getVariable()
	{
		return this.variable;
	}

	public void setVariable( final Set<Variable> variable )
	{
		this.variable = variable;
	}

	public Study addVariable( final Variable variable )
	{
		if ( this.variable == null )
			this.variable = new HashSet<Variable>();

		this.variable.add( variable );

		return this;
	}

	public Set<DataFile> getDataFile()
	{
		return this.dataFile;
	}

	public void setDataFile( final Set<DataFile> dataFile )
	{
		this.dataFile = dataFile;
	}

	public Study addDataFile( final DataFile dataFile )
	{
		if ( this.dataFile == null )
			this.dataFile = new HashSet<DataFile>();

		this.dataFile.add( dataFile );

		return this;
	}

	public Set<LogicalDataSet> getProduct()
	{
		return this.product;
	}

	public void setProduct( final Set<LogicalDataSet> product )
	{
		this.product = product;
	}

	public Study addProduct( final LogicalDataSet logicalDataSet )
	{
		if ( this.product == null )
			this.product = new HashSet<LogicalDataSet>();

		this.product.add( logicalDataSet );

		return this;
	}

	public String getOwl_versionInfo()
	{
		return this.owl_versionInfo;
	}

	public void setOwl_versionInfo( final String owl_versionInfo )
	{
		this.owl_versionInfo = owl_versionInfo;
	}

	public StudyGroup getInGroup()
	{
		return this.inGroup;
	}

	public void setInGroup( final StudyGroup inGroup )
	{
		this.inGroup = inGroup;
	}

}