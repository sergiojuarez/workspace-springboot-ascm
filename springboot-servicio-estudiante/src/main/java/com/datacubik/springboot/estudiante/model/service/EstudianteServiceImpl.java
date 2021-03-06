package com.datacubik.springboot.estudiante.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacubik.springboot.estudiante.model.dao.EstudianteDAO;
import com.datacubik.springboot.estudiante.model.entity.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private EstudianteDAO estudianteDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		return (List<Estudiante>)estudianteDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Integer id) {
		return estudianteDAO.findById(id).orElse(null);
	}

}
