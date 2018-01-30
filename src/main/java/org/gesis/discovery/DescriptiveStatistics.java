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

/**
 * An overview over the microdata can be given either by the descriptive
 * statistics or the aggregated data. DescriptiveStatistics may be minimal,
 * maximal, mean values, and absolute and relative frequencies. Aggregated data
 * are derived from microdata by statistics on groups, or aggregates such as
 * counts, means, or frequencies.
 * 
 * <p>
 * Subclasses of this class are {@link SummaryStatistics} and
 * {@link CategoryStatistics}, which are both descriptive statistics.
 * </p>
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#descriptivestatistics}
 */
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

	/**
	 * @return The list of DataFiles of this individual.
	 */
	public List<DataFile> getStatisticsDataFile()
	{
		return this.statisticsDatafile;
	}

	/**
	 * Corresponds to disco:statisticsDataFile. Indicates the DataFile of a specific
	 * DesciptiveStatistics individual.
	 * 
	 * @param dataFiles
	 * @return This DescriptiveStatistics object.
	 * @see {@link getStatisticsDataFile()}
	 */
	public DescriptiveStatistics setStatisticsDataFile( final List<DataFile> dataFiles )
	{
		this.statisticsDatafile = dataFiles;
		return this;
	}

	public DescriptiveStatistics addStatisticsDataFile( final DataFile dataFile )
	{
		if ( this.statisticsDatafile == null )
			this.statisticsDatafile = new ArrayList<DataFile>();

		this.statisticsDatafile.add( dataFile );

		return this;
	}

}