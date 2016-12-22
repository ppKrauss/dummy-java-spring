package org.springframework.roo.petclinic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVet is a Querydsl query type for Vet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVet extends EntityPathBase<Vet> {

    private static final long serialVersionUID = -1907804155L;

    public static final QVet vet = new QVet("vet");

    public final QAbstractPerson _super = new QAbstractPerson(this);

    //inherited
    public final StringPath address = _super.address;

    //inherited
    public final DateTimePath<java.util.Date> birthDay = _super.birthDay;

    //inherited
    public final StringPath city = _super.city;

    //inherited
    public final StringPath email = _super.email;

    public final DateTimePath<java.util.Calendar> employedSince = createDateTime("employedSince", java.util.Calendar.class);

    //inherited
    public final StringPath firstName = _super.firstName;

    //inherited
    public final StringPath homePage = _super.homePage;

    //inherited
    public final StringPath lastName = _super.lastName;

    public final EnumPath<org.springframework.roo.petclinic.reference.Specialty> specialty = createEnum("specialty", org.springframework.roo.petclinic.reference.Specialty.class);

    //inherited
    public final StringPath telephone = _super.telephone;

    public final SetPath<Visit, QVisit> visits = this.<Visit, QVisit>createSet("visits", Visit.class, QVisit.class, PathInits.DIRECT2);

    public QVet(String variable) {
        super(Vet.class, forVariable(variable));
    }

    public QVet(Path<? extends Vet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVet(PathMetadata metadata) {
        super(Vet.class, metadata);
    }

}

