package org.gesis.discovery;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class StudyGroup extends Union_StudyGroupStudy
{

	// relations

	@OneToMany( mappedBy = "inGroup" )
	private List<Study> studies;

	// getter / setter

	public List<Study> getStudies()
	{
		return studies;
	}

	public void setStudies( final List<Study> studies )
	{
		this.studies = studies;
	}

}
