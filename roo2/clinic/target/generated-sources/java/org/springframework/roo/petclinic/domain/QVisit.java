package org.springframework.roo.petclinic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVisit is a Querydsl query type for Visit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVisit extends EntityPathBase<Visit> {

    private static final long serialVersionUID = 551364011L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVisit visit = new QVisit("visit");

    public final StringPath description = createString("description");

    public final QPet pet;

    public final QVet vet;

    public final DateTimePath<java.util.Date> visitDate = createDateTime("visitDate", java.util.Date.class);

    public QVisit(String variable) {
        this(Visit.class, forVariable(variable), INITS);
    }

    public QVisit(Path<? extends Visit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVisit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVisit(PathMetadata metadata, PathInits inits) {
        this(Visit.class, metadata, inits);
    }

    public QVisit(Class<? extends Visit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pet = inits.isInitialized("pet") ? new QPet(forProperty("pet"), inits.get("pet")) : null;
        this.vet = inits.isInitialized("vet") ? new QVet(forProperty("vet")) : null;
    }

}

