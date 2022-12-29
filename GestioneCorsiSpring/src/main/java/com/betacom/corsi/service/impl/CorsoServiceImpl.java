package com.betacom.corsi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.corsi.businesscomponent.model.Corso;
import com.betacom.corsi.repository.CorsoRepository;
import com.betacom.corsi.service.CorsoService;

@Service
public class CorsoServiceImpl implements CorsoService {
	@Autowired
	CorsoRepository correp;

	@Override
	public void saveCorso(Corso corso) {
		correp.save(corso);

	}

	@Override
	public List<Corso> getAll() {
		return correp.findAll();
	}

	@Override
	public Optional<Corso> findById(long id) {
		return correp.findById(id);
	}

	@Override
	public int getPostiDisponibili(long id) {
		return correp.getPostiDisponibili(id);
	}

	@Override
	public Date getUltimoCorso() {
		return correp.getUltimoCorso();
	}

	@Override
	public double getMediaCorsi() {
		return correp.getMediaCorsi();
	}

	@Override
	public void deleteCorso(long id) {
		correp.deleteById(id);

	}

	/*
	 * private int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
	 * 
	 * Calendar startCal = Calendar.getInstance(); startCal.setTime(startDate);
	 * 
	 * Calendar endCal = Calendar.getInstance(); endCal.setTime(endDate);
	 * 
	 * int workDays = 0;
	 * 
	 * // Return 1 if start and end are the same if (startCal.getTimeInMillis() ==
	 * endCal.getTimeInMillis()) { return 1; }
	 * 
	 * if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	 * startCal.setTime(endDate); endCal.setTime(startDate); }
	 * 
	 * do { // excluding start date startCal.add(Calendar.DAY_OF_MONTH, 1); if
	 * (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
	 * startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) { ++workDays; } }
	 * while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()); // excluding
	 * end date
	 * 
	 * return workDays; }
	 */

}
