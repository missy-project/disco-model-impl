package org.gesis.discovery;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Representation extends Union_RdfsDataTypeSkosConceptScheme
{

	// properties

	// relations

	// getter / setter

}