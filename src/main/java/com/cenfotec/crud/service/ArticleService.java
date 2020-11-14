package com.cenfotec.crud.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.crud.domain.Antology;
import com.cenfotec.crud.domain.Article;

public interface ArticleService {

	public void save(Article article);
	public Optional<Article> get(Long id);
	public List<Article> getAll();
	public List<Article> find(String name);
	
}
