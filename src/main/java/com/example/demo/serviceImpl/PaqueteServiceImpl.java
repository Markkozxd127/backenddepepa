package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Paquete;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.PaqueteRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.PaqueteService;


@Service
public class PaqueteServiceImpl implements PaqueteService<Paquete>{
	
	@Autowired
	private PaqueteRepository paqueteRepository;

	@Override
	public Paquete create(Paquete t) {
		// TODO Auto-generated method stub
		return paqueteRepository.save(t);
	}

	@Override
	public Paquete update(Paquete t) {
		// TODO Auto-generated method stub
		return paqueteRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		paqueteRepository.deleteById(id);
	}

	@Override
	public Optional<Paquete> read(int id) {
		// TODO Auto-generated method stub
		return paqueteRepository.findById(id);
	}

	@Override
	public List<Paquete> readAll() {
		// TODO Auto-generated method stub
		return paqueteRepository.findAll();
	}

}