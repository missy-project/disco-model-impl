package org.gesis.rdfs;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.discovery.Union_RdfsDataTypeSkosConceptScheme;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Datatype extends Union_RdfsDataTypeSkosConceptScheme
{

}
