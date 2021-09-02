package com.devracoon.jpa.repository;

import com.devracoon.jpa.entity.Contents;
import com.devracoon.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Contents, String>, ContentsRepositoryCustom{

}
