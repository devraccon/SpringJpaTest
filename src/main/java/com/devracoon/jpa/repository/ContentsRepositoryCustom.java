package com.devracoon.jpa.repository;

import com.devracoon.jpa.entity.Contents;

import java.util.List;

public interface ContentsRepositoryCustom {

    public List<Contents> findContentsByCustom();

    public List<Contents> findContentsFunctionTest();


}
