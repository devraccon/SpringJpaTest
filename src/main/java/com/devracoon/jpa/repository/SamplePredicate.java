package com.devracoon.jpa.repository;

import com.devracoon.jpa.entity.QItem;
import com.devracoon.jpa.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class SamplePredicate {

    public static BooleanBuilder productPredicate(String productName , String itemName){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QProduct product = QProduct.product;
        QItem item = QItem.item;
        if(StringUtils.isNotEmpty(productName)){
            booleanBuilder.and(product.productName.like("%" + productName + "%"));
        }

        if(StringUtils.isNotEmpty(itemName)){
            booleanBuilder.and(product.items.any().itemName.like("%" + itemName + "%"));
        }

        return booleanBuilder;
    }
}
