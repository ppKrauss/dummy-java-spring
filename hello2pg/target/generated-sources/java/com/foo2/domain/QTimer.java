package com.foo2.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTimer is a Querydsl query type for Timer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTimer extends EntityPathBase<Timer> {

    private static final long serialVersionUID = 2119999696L;

    public static final QTimer timer = new QTimer("timer");

    public final StringPath message = createString("message");

    public QTimer(String variable) {
        super(Timer.class, forVariable(variable));
    }

    public QTimer(Path<? extends Timer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimer(PathMetadata metadata) {
        super(Timer.class, metadata);
    }

}

