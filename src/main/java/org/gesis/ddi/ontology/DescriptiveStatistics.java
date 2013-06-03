package org.gesis.ddi.ontology;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.gesis.ddi.Identifiable;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class DescriptiveStatistics extends Identifiable
{

	// properties

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "DescriptiveStatistics_DataFile", 
			joinColumns = @JoinColumn( name = "descriptiveStatistics_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected Set<DataFile> statisticsDatafile;

	// getter/setter

	public Set<DataFile> getStatisticsDataFile()
	{
		return this.statisticsDatafile;
	}

	public void setStatisticsDataFile(final Set<DataFile> dataFiles)
	{
		this.statisticsDatafile = dataFiles;
	}

	public DescriptiveStatistics addStatisticsDataFile( final DataFile dataFile )
	{
		if ( this.statisticsDatafile == null )
			this.statisticsDatafile = new HashSet<DataFile>();

		this.statisticsDatafile.add( dataFile );

		return this;
	}

}