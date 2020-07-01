package com.datacubit.springboot.estudiante.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.datacubit.springboot.estudiante.model.entity.Estudiante;

public interface EstudianteDAO extends CrudRepository<Estudiante, Integer>{
}
