package com.betacom.corsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.betacom.corsi.businesscomponent.model.Corsista;
import com.betacom.corsi.businesscomponent.model.CorsistaCorso;
import com.betacom.corsi.businesscomponent.model.Corso;
import com.betacom.corsi.businesscomponent.model.Docente;
import com.betacom.corsi.service.AdminService;
import com.betacom.corsi.service.CorsistaCorsoService;
import com.betacom.corsi.service.CorsistaService;
import com.betacom.corsi.service.CorsoService;
import com.betacom.corsi.service.DocenteService;

@Controller
@Scope("session")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	CorsistaCorsoService ccService;
	@Autowired
	CorsistaService corsistaService;
	@Autowired
	CorsoService corsoService;
	@Autowired
	DocenteService docenteService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		Integer numCorsisti = corsistaService.getAll().size();
		mv.addObject("numCorsisti", numCorsisti);
		List<String> corsiFreq = ccService.getCorsiFreq();
		mv.addObject("corsiFreq", corsiFreq);
		mv.addObject("ultimoCorso", corsoService.getUltimoCorso());
		Double mediaCorsi = corsoService.getMediaCorsi();
		mv.addObject("mediaCorsi", mediaCorsi); //al massimo fare Double
		return mv;
	}

	// -----------NUOVO CORSISTA ------------

	@RequestMapping(value = "/aggiungicorsista", method = RequestMethod.GET)
	public ModelAndView nuovoCorsista() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aggiungicorsista");
		Corsista corsista = new Corsista();
		mv.addObject("corsista", corsista);
		List<Corso> corsi = corsoService.getAll();
		mv.addObject("corsi", corsi);
		// aggiungere posti disponibili per ogni corso
		return mv;
	}

	@PostMapping("/registrazionecorsista")
	public ModelAndView registrazioneCorsista(Corsista corsista, Corso corso) {
		corsistaService.saveCorsista(corsista);
		CorsistaCorso cc = new CorsistaCorso();
		cc.setCorsista(corsista);
		cc.setCorso(corso);
		ccService.saveCorsistaCorso(cc);
		// ma viene collegato al corso?
		return new ModelAndView("redirect:/admin/");

	}

	// -----------NUOVO CORSO ------------

	@RequestMapping(value = "/aggiungicorso", method = RequestMethod.GET)
	public ModelAndView nuovoCorso() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aggiungicorso");
		Corso corso = new Corso();
		mv.addObject("corso", corso);
		List<Docente> docenti = docenteService.getAll();
		mv.addObject("docenti", docenti);
		return mv;
	}

	@PostMapping("/registrazionecorso")
	public ModelAndView registrazioneCorso(Corso corso, Docente docente) {
		corso.setDocente(docente);
		corsoService.saveCorso(corso);
		return new ModelAndView("redirect:/admin/");

	}

	// -----------GESTIONE CORSI ------------
	@GetMapping("/gestionecorsi")
	public ModelAndView gestioneCorsi() {
		List<Corso> listaCorsi = corsoService.getAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("corsiList", listaCorsi);
		mv.setViewName("gestionecorsi");
		return mv;
	}

	@GetMapping("/eliminaordine/{id}")
	public ModelAndView eliminaCorso(@PathVariable long id) {
		corsoService.deleteCorso(id);
		// altrimenti cambiare con delete(entity)
		return new ModelAndView("redirect:/admin/gestioneordini");
	}
	
	// -----------GESTIONE CORSISTI ------------
	
	@GetMapping("/gestionecorsisti")
	public ModelAndView gestioneCorsisti() {
		List<Corsista> listaCorsisti = corsistaService.getAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gestionecorsisti");
		mv.addObject("listaCorsisti", listaCorsisti);	
		return mv;
	}
	
	
	

}
