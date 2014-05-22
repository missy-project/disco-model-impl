This package contains the 

**Implementation of the disco-spec - the DDI Discovery Vocabulary**

### DDI-RDF Discovery Vocabulary (disco)
The Data Documentation Initiative (DDI) is an acknowledged international standard for the documentation and management of data from the social, behavioral, and economic sciences. Statistical domain experts, i.e. representatives of national statistical institutes and national data archives, and Linked Open Data community members have developed the DDI-RDF Discovery Vocabulary – based on a subset of the DDI - in order to support the discovery of statistical data as well as metadata. This vocabulary supports dentifying programmatically the relevant data sets for a specific research purpose.

### Model

All classes, datatype properties and object properties are modelled according to [https://github.com/linked-statistics/disco-spec](https://github.com/linked-statistics/disco-spec) turtle file and UML models.

#### Annotations

In order to make the persistence of the model easier, all classes are enriched with JPA-annotations, which annotate all fields and relations discribed in the disco-spec. It was payed attention to just use JPA annotations, hence not being dependent to a specific implementation, e.g. Hibernate.

    @Entity
	@Inheritance( strategy = InheritanceType.JOINED )
	public class Variable extends Concept
	{
		// properties
		@OneToOne
		protected LangString description;
		
		// relations
		@ManyToOne
		@JoinColumn( name = "analysisUnit_id" )
		protected AnalysisUnit analysisUnit;
		…
	}

Please have a look at the [disco-persistence-api](https://github.com/missy-project/disco-persistence-api) for an API for persisting the data model.

#### Persistence

There exists a persistence implementation for this model according to the [API](https://github.com/missy-project/disco-persistence-api) called [disco-persistence-relational](https://github.com/missy-project/disco-persistence-relational). It uses Hibernate as a object-relational-mapper. 

Further physical storage types may be implemented.

#### Validation

It is assumed to have the validation NOT coupled to the model, thus the existence of datatype and object properties is expected to be managed by the business logic.

### Links

* [Specification of the DDI-RDF Discovery Vocabulary](http://rdf-vocabulary.ddialliance.org/discovery.html)
* [GitHub repository DDI-RDF Discovery Vocabulary](https://github.com/linked-statistics/disco-spec)
* [Related Pulications](http://www.ddialliance.org/Specification/RDF/Discovery)

### Editors

* Matthäus Zloch [E-Mail](matthaeus.zloch@gesis.org)
* Thomas Bosch [E-Mail](thomas.bosch@gesis.org)

### License & Copyright

Apache License, Version 2.0 http://www.apache.org/licenses/LICENSE-2.0.html

© GESIS – Leibniz Institute for the Social Sciences. http://www.gesis.org