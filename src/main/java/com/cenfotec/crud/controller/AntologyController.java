package com.cenfotec.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cenfotec.crud.domain.Antology;
import com.cenfotec.crud.domain.Article;
import com.cenfotec.crud.service.AntologyService;
import com.cenfotec.crud.service.ArticleService;

@Controller
public class AntologyController {

	@Autowired
	AntologyService anthologyService;
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/insertar",  method = RequestMethod.GET)
	public String insertarPage(Model model) {
		model.addAttribute(new Antology());
		return "insertar";
	}	
	
	@RequestMapping(value = "/insertar",  method = RequestMethod.POST)
	public String insertarAction(Antology antology, BindingResult result, Model model) {

		Antology newEntry = antology;
		System.out.println(antology.toString());
		anthologyService.save(newEntry);
		return "index";
	}
	
	
	@GetMapping(value = "/antology/{id}")
	public String antologyPage(@PathVariable("id") long id, Model model) {
		System.out.println(anthologyService.getAll().size() + " antologias");
		for (Antology a: anthologyService.getAll()) {
			System.out.println(a.toString());
			System.out.println(a.getArticles().size() + " articulos");
			if (a.getId() == id) {
				model.addAttribute("ant", a);
			}
		}
		return "antology";
	}	
	
	@GetMapping(value = "/editar/{id}")
	public String editarPage(@PathVariable("id") long id, Model model) {
		System.out.println(anthologyService.getAll().size() + " antologias");
		for (Antology a: anthologyService.getAll()) {
			System.out.println(a.toString());
			System.out.println(a.getArticles().size() + " articulos");
			if (a.getId() == id) {
				model.addAttribute(a);
			}
		}
		return "editar";
	}	
	
	@RequestMapping(value = "/editar",  method = RequestMethod.POST)
	public String editarAction(Antology antology, BindingResult result, Model model) {
		
		Antology edit = antology;
		
		System.out.println(antology.toString());
		
		anthologyService.save(edit);
		return "index";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("anthologies",anthologyService.getAll());
		return "listar";
	}
	
	@GetMapping(value = "/article/{id}")
	public String agregarArticulo(@PathVariable("id") long id, Model model) {
		System.out.println(anthologyService.getAll().size() + " antologias");
		for (Antology a: anthologyService.getAll()) {
			System.out.println(a.toString());
			if (a.getId() == id) {
				model.addAttribute(new Article(id));
			}
		}
		return "insertarArticulo";
	}	
	
	@RequestMapping(value = "/article",  method = RequestMethod.POST)
	public String articuloAction(Article article, BindingResult result, Model model) {
		System.out.println(anthologyService.getAll().size() + " antologias");
		for (Antology a: anthologyService.getAll()) {
			System.out.println(a.toString() + " Comparando con " + article.getId());
			if (a.getId() == article.getId()) {
				System.out.println("Encontrado ");
				Article art = new Article(article.getName(), a);
				a.getArticles().add(art);
				anthologyService.save(a);
				articleService.save(art);
				System.out.println("Listo? " + a.toString());
				
			}
		}
		
		return "redirect:/";
	}
	
	
	
	
}
