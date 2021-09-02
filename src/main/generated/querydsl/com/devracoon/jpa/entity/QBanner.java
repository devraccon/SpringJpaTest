package com.devracoon.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBanner is a Querydsl query type for Banner
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBanner extends EntityPathBase<Banner> {

    private static final long serialVersionUID = 1176978968L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBanner banner = new QBanner("banner");

    public final StringPath bannerId = createString("bannerId");

    public final QContents content;

    public QBanner(String variable) {
        this(Banner.class, forVariable(variable), INITS);
    }

    public QBanner(Path<? extends Banner> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBanner(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBanner(PathMetadata metadata, PathInits inits) {
        this(Banner.class, metadata, inits);
    }

    public QBanner(Class<? extends Banner> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.content = inits.isInitialized("content") ? new QContents(forProperty("content")) : null;
    }

}

