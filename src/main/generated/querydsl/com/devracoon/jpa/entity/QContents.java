package com.devracoon.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QContents is a Querydsl query type for Contents
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContents extends EntityPathBase<Contents> {

    private static final long serialVersionUID = -1506076922L;

    public static final QContents contents = new QContents("contents");

    public final StringPath contentId = createString("contentId");

    public final StringPath displayPositonCode = createString("displayPositonCode");

    public final StringPath startDisplayTime = createString("startDisplayTime");

    public QContents(String variable) {
        super(Contents.class, forVariable(variable));
    }

    public QContents(Path<? extends Contents> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContents(PathMetadata metadata) {
        super(Contents.class, metadata);
    }

}

