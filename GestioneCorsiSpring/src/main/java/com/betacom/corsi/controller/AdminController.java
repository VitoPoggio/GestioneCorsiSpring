package com.betacom.corsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.betacom.corsi.businesscomponent.model.Corsista;
import com.betacom.corsi.businesscomponent.model.Corso;
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
		// aggiungere dati che servono nella home
		mv.setViewName("adminhome");
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

	@PostMapping("/registrazioneadmin")
	public ModelAndView registrazioneCorsista(Corsista corsista) {
		corsistaService.saveCorsista(corsista);
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
		return mv;
	}

	@PostMapping("/registrazionecorso")
	public ModelAndView registrazioneCorso(Corso corso) {
		corsoService.saveCorso(corso);
		return new ModelAndView("redirect:/admin/");

	}

}
