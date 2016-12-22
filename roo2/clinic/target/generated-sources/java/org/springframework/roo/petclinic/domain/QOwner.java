package org.springframework.roo.petclinic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOwner is a Querydsl query type for Owner
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOwner extends EntityPathBase<Owner> {

    private static final long serialVersionUID = 545311507L;

    public static final QOwner owner = new QOwner("owner");

    public final QAbstractPerson _super = new QAbstractPerson(this);

    //inherited
    public final StringPath address = _super.address;

    //inherited
    public final DateTimePath<java.util.Date> birthDay = _super.birthDay;

    //inherited
    public final StringPath city = _super.city;

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final StringPath firstName = _super.firstName;

    //inherited
    public final StringPath homePage = _super.homePage;

    //inherited
    public final StringPath lastName = _super.lastName;

    public final SetPath<Pet, QPet> pets = this.<Pet, QPet>createSet("pets", Pet.class, QPet.class, PathInits.DIRECT2);

    //inherited
    public final StringPath telephone = _super.telephone;

    public QOwner(String variable) {
        super(Owner.class, forVariable(variable));
    }

    public QOwner(Path<? extends Owner> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOwner(PathMetadata metadata) {
        super(Owner.class, metadata);
    }

}

