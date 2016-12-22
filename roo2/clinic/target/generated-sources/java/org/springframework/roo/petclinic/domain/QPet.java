package org.springframework.roo.petclinic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPet is a Querydsl query type for Pet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPet extends EntityPathBase<Pet> {

    private static final long serialVersionUID = -1907809921L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPet pet = new QPet("pet");

    public final StringPath name = createString("name");

    public final QOwner owner;

    public final BooleanPath sendReminders = createBoolean("sendReminders");

    public final EnumPath<org.springframework.roo.petclinic.reference.PetType> type = createEnum("type", org.springframework.roo.petclinic.reference.PetType.class);

    public final SetPath<Visit, QVisit> visits = this.<Visit, QVisit>createSet("visits", Visit.class, QVisit.class, PathInits.DIRECT2);

    public final NumberPath<Float> weight = createNumber("weight", Float.class);

    public QPet(String variable) {
        this(Pet.class, forVariable(variable), INITS);
    }

    public QPet(Path<? extends Pet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPet(PathMetadata metadata, PathInits inits) {
        this(Pet.class, metadata, inits);
    }

    public QPet(Class<? extends Pet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.owner = inits.isInitialized("owner") ? new QOwner(forProperty("owner")) : null;
    }

}

