package org.gesis.ddi.ontology;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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

	// properties

	// relations

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "DescriptiveStatistics_DataFile", 
			joinColumns = @JoinColumn( name = "descriptiveStatistics_id" ), 
			inverseJoinColumns = @JoinColumn( name = "dataFile_id" ) )
	protected Set<DataFile> statisticsDatafile;

	// getter/setter

	public DescriptiveStatistics( final String agencyId, final String objectId, final int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

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