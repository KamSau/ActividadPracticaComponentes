package com.cenfotec.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.crud.domain.Antology;
import com.cenfotec.crud.domain.Article;
import com.cenfotec.crud.repo.AntologyRepository;
import com.cenfotec.crud.repo.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository repo;
	
	@Override
	public void save(Article article) {
		repo.save(article);
	}

	@Override
	public Optional<Article> get(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Article> find(String name) {
		return repo.findByNameContaining(name);
	}

	@Override
	public List<Article> getAll() {
		return repo.findAll();
	}

}
