package org.gesis.datacube;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.gesis.ddi.ontology.Variable;
import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class DataSet extends Resource
{

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="DataSet_Variable",
			joinColumns=@JoinColumn(name="dataSet_id"),
			inverseJoinColumns=@JoinColumn( name = "variable_id" ))
	protected Set<Variable> inputVariable;

	// getter/setter

	public Set<Variable> getInputVariable() {
		return this.inputVariable;
	}

	public void setInputVariable(final Set<Variable> inputVariables) {
		this.inputVariable = inputVariables;
	}

}