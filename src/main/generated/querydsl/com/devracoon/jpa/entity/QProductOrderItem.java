package com.devracoon.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductOrderItem is a Querydsl query type for ProductOrderItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductOrderItem extends EntityPathBase<ProductOrderItem> {

    private static final long serialVersionUID = 823500606L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductOrderItem productOrderItem = new QProductOrderItem("productOrderItem");

    public final StringPath orderItemId = createString("orderItemId");

    public final QProduct product;

    public final QProductOrder productOrder;

    public QProductOrderItem(String variable) {
        this(ProductOrderItem.class, forVariable(variable), INITS);
    }

    public QProductOrderItem(Path<? extends ProductOrderItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductOrderItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductOrderItem(PathMetadata metadata, PathInits inits) {
        this(ProductOrderItem.class, metadata, inits);
    }

    public QProductOrderItem(Class<? extends ProductOrderItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
        this.productOrder = inits.isInitialized("productOrder") ? new QProductOrder(forProperty("productOrder"), inits.get("productOrder")) : null;
    }

}

