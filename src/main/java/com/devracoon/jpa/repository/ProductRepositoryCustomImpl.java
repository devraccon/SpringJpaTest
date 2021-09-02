package com.devracoon.jpa.repository;

import com.devracoon.jpa.entity.Product;
import com.devracoon.jpa.entity.QContents;
import com.devracoon.jpa.entity.QItem;
import com.devracoon.jpa.entity.QProduct;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom{

    private JPAQueryFactory queryFactory;

    public ProductRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }

    public List<Product> findProductByCustom(String productName , String itemName){
        QProduct product = QProduct.product;
        List<Product> products = queryFactory.selectFrom(product).leftJoin(product.items).fetchJoin()
                .where(SamplePredicate.productPredicate(productName,  itemName)).fetch();
        return products;
    }

    public List<Product> findProductByCustomPasing(String productName , String itemName , Pageable pageable){
        QProduct product = QProduct.product;
        JPAQuery<Product> query = queryFactory.selectFrom(product).leftJoin(product.items).fetchJoin()
                .where(SamplePredicate.productPredicate(productName,  itemName));
                //.limit(pageable.getPageSize()).offset(pageable.getOffset());


        List<Product> products = getQuerydsl().applyPagination(pageable, query).fetch();

        return products;
    }




}
