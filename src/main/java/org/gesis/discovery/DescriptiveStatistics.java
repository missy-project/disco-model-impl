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

import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class DescriptiveStatistics extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	// relations
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "DescriptiveStatistics_DataFile",
			joinColumns = @JoinColumn( name = "descriptiveStatistics_id" ),
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected List<DataFile> statisticsDatafile;

	// getter/setter

	public List<DataFile> getStatisticsDataFile()
	{
		return this.statisticsDatafile;
	}

	public void setStatisticsDataFile(final List<DataFile> dataFiles)
	{
		this.statisticsDatafile = dataFiles;
	}

	public DescriptiveStatistics addStatisticsDataFile( final DataFile dataFile )
	{
		if ( this.statisticsDatafile == null )
			this.statisticsDatafile = new ArrayList<DataFile>();

		this.statisticsDatafile.add( dataFile );

		return this;
	}

}