package com.cenfotec.crud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.crud.domain.Antology;
import com.cenfotec.crud.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	public List<Article> findByNameContaining(String word);
}
