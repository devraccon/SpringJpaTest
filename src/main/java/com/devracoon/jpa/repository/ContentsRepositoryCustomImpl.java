package com.devracoon.jpa.repository;

import com.devracoon.jpa.entity.Contents;
import com.devracoon.jpa.entity.Product;
import com.devracoon.jpa.entity.QContents;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ContentsRepositoryCustomImpl extends QuerydslRepositorySupport implements ContentsRepositoryCustom{

    private JPAQueryFactory queryFactory;

    public ContentsRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(Contents.class);
        this.queryFactory = queryFactory;
    }

    public List<Contents> findContentsByCustom(){

        QContents contents = QContents.contents;

        List<Contents> contentsList = queryFactory.selectFrom(contents).where(Expressions.list(contents.displayPositonCode , contents.startDisplayTime ).in(
                        JPAExpressions.select(contents.displayPositonCode , contents.startDisplayTime.max())
                                .from(contents).groupBy(contents.displayPositonCode))).fetch();

        return contentsList;
    }

    public List<Contents> findContentsFunctionTest(){

        QContents contents = QContents.contents;

        List<Contents> contentsList = queryFactory.selectFrom(contents)
                .orderBy(
                    Expressions.stringTemplate("DATE_FORMAT({0}, {1})",contents.startDisplayTime, "%Y-%m-%d %H:%i").desc()
                )
                .fetch();
        return contentsList;
    }
}
