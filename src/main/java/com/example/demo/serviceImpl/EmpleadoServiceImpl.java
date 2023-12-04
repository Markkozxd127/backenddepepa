package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleaddoRepository;
import com.example.demo.service.EmpleadoService;




@Service
public class EmpleadoServiceImpl implements EmpleadoService<Empleado>{
	
	@Autowired
	private EmpleaddoRepository empleadoRepository;

	@Override
	public Empleado create(Empleado t) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(t);
	}

	@Override
	public Empleado update(Empleado t) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(id);
	}

	@Override
	public Optional<Empleado> read(int id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id);
	}

	@Override
	public List<Empleado> readAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

}