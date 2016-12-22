package org.springframework.roo.petclinic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractPerson is a Querydsl query type for AbstractPerson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAbstractPerson extends EntityPathBase<AbstractPerson> {

    private static final long serialVersionUID = -1555895881L;

    public static final QAbstractPerson abstractPerson = new QAbstractPerson("abstractPerson");

    public final StringPath address = createString("address");

    public final DateTimePath<java.util.Date> birthDay = createDateTime("birthDay", java.util.Date.class);

    public final StringPath city = createString("city");

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final StringPath homePage = createString("homePage");

    public final StringPath lastName = createString("lastName");

    public final StringPath telephone = createString("telephone");

    public QAbstractPerson(String variable) {
        super(AbstractPerson.class, forVariable(variable));
    }

    public QAbstractPerson(Path<? extends AbstractPerson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractPerson(PathMetadata metadata) {
        super(AbstractPerson.class, metadata);
    }

}

