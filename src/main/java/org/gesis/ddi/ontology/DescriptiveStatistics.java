package org.gesis.ddi.ontology;

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

	public DescriptiveStatistics( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Set<DataFile> getStatisticsDataFile()
	{
		return this.statisticsDatafile;
	}

	public void setStatisticsDataFile(Set<DataFile> dataFiles)
	{
		this.statisticsDatafile = dataFiles;
	}

}