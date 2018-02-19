package org.gesis.dcterms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.discovery.DataFile;
import org.gesis.discovery.LogicalDataSet;
import org.gesis.discovery.Study;
import org.gesis.rdfs.Resource;

/**
 * {@link Study}, {@link LogicalDataSet}s, and {@link DataFile}s may have a
 * spatial, temporal, and topical coverage. There is no dedicated coverage type
 * in DDI-RDF. The comprehensive description by spatial, temporal, and topical
 * coverage is directly attached to the respective study, logical dataset, and
 * datafile (using DCMI terms).
 * 
 * <p>
 * Disco could be used to discover datasets by searching for specific questions,
 * topics, and geographical coverage. For temporal coverage, dcterms:temporal is
 * used, pointing to a period of time or single point in time.
 * </p>
 * <p>
 * Please note that these properties are a feature at risk, since the domain is
 * not Disco. Maintainers of the domain ontology may introduce their own
 * properties for this purpose. A possible way to describe temporal coverage is
 * the use of the W3C time ontology.
 * </p>
 * 
 * @author matthaeus
 * @see <a href=
 *      "http://rdf-vocabulary.ddialliance.org/discovery.html#coverage-of-studies-logical-datasets-and-data-files">
 *      Coverage of Studies, LogicalDataSets, and DataFiles</a>
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class PeriodOfTime extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@Column
	private Date startDate;

	@Column
	private Date endDate;

	@Column
	private Date dateIssued;

	// relations

	// getter / setter

	/**
	 * @return The start date of this temporal coverage.
	 */
	public Date getStartDate()
	{
		return this.startDate;
	}

	/**
	 * Corresponds to disco:startDate. For time periods it is also possible to
	 * define start (startDate) and end dates (endDate).
	 * 
	 * @param startDate
	 * @return This PeriodOfTime object.
	 * @see #getStartDate()
	 */
	public PeriodOfTime setStartDate( final Date startDate )
	{
		this.startDate = startDate;
		return this;
	}

	/**
	 * @return The end date of this temporal coverage.
	 */
	public Date getEndDate()
	{
		return this.endDate;
	}

	/**
	 * Corresponds to disco:endDate. For time periods it is also possible to define
	 * start (startDate) and end dates (endDate).
	 * 
	 * @param endDate
	 * @return This PeriodOfTime object.
	 * @see #getEndDate()
	 */
	public PeriodOfTime setEndDate( final Date endDate )
	{
		this.endDate = endDate;
		return this;
	}

	/**
	 * @return The date issued as a single point in time.
	 */
	public Date getDateIssued()
	{
		return dateIssued;
	}

	/**
	 * A single point in time. For time periods it is also possible to define start
	 * (startDate) and end dates (endDate).
	 * 
	 * @param dateIssued
	 * @return This PeriodOfTime object.
	 * @see #getDateIssued()
	 * @see #setStartDate(Date)
	 * @see #setEndDate(Date)
	 */
	public PeriodOfTime setDateIssued( Date dateIssued )
	{
		this.dateIssued = dateIssued;
		return this;
	}

}
