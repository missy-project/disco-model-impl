package org.gesis.rdfs;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.discovery.Representation;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Datatype extends Resource implements Representation
{

}
