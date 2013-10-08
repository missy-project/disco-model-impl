package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

	// relations

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "studyGroup_id" )
	private StudyGroup inGroup;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "study_id" )
	private List<Instrument> instrument;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_Variable",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "variable_id" ) )
	private List<Variable> variable;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_DataFile",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	private List<DataFile> dataFile;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Study_LogicalDataSet",
			joinColumns = @JoinColumn( name = "study_id" ),
			inverseJoinColumns = @JoinColumn( name = "logicalDataSet_id" ) )
	private List<LogicalDataSet> product;

	// getter/setter

	public List<Instrument> getInstrument()
	{
		return this.instrument;
	}

	public void setInstrument( final List<Instrument> instrument )
	{
		this.instrument = instrument;
	}

	public Study addInstrument( final Instrument instrument )
	{
		if ( this.instrument == null )
			this.instrument = new ArrayList<Instrument>();

		this.instrument.add( instrument );

		return this;
	}

	public List<Variable> getVariable()
	{
		return this.variable;
	}

	public void setVariable( final List<Variable> variable )
	{
		this.variable = variable;
	}

	public Study addVariable( final Variable variable )
	{
		if ( this.variable == null )
			this.variable = new ArrayList<Variable>();

		this.variable.add( variable );

		return this;
	}

	public List<DataFile> getDataFile()
	{
		return this.dataFile;
	}

	public void setDataFile( final List<DataFile> dataFile )
	{
		this.dataFile = dataFile;
	}

	public Study addDataFile( final DataFile dataFile )
	{
		if ( this.dataFile == null )
			this.dataFile = new ArrayList<DataFile>();

		this.dataFile.add( dataFile );

		return this;
	}

	public List<LogicalDataSet> getProduct()
	{
		return this.product;
	}

	public void setProduct( final List<LogicalDataSet> product )
	{
		this.product = product;
	}

	public Study addProduct( final LogicalDataSet logicalDataSet )
	{
		if ( this.product == null )
			this.product = new ArrayList<LogicalDataSet>();

		this.product.add( logicalDataSet );

		return this;
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
