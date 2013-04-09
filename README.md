*Please note that this is work in progess.*

This package contains the 

**Implementation of the disco-spec - the DDI Discovery Vocabulary**

### Model

All classes, datatype properties and object properties are modelled according to [https://github.com/linked-statistics/disco-spec](https://github.com/linked-statistics/disco-spec) turtle file and UML models.

### Persistence

#### Annotations

In order to make the persistence of the model easier, all classes are enriched with JPA-annotations, which indicate the relations discribed in the disco-spec. It was intentionally payed attention to JUST using JPA annotations, hence not being dependent to the Hibernate implementation.

Please have a look at []() for an API for persisting

#### Validation

It is assumed to have the validation NOT coupled to the model, thus the existence of datatype and object properties is expected to be managed by the business logic.

### License & Copyright
Apache License, Version 2.0 http://www.apache.org/licenses/LICENSE-2.0.html

© GESIS – Leibniz Institute for the Social Sciences. http://www.gesis.org
