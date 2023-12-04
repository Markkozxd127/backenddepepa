package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Empleado;
import com.example.demo.serviceImpl.EmpleadoServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.commons.GlobalConstans.API_EMPLEADO;;

@RestController
@RequestMapping(API_EMPLEADO)
@CrossOrigin({"*"})
public class EmpleadoController {
	@Autowired
	private EmpleadoServiceImpl clienteServiceImpl;
	
	@GetMapping ("/ListEmpl")
	public ResponseEntity<List<Empleado>> listar() {
		try {
		      List<Empleado> cat = clienteServiceImpl.readAll();
		      if (cat.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(cat, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	

	@GetMapping("/BuscarEmpl/{id}")
	public ResponseEntity<Empleado> getCategoriaById(@PathVariable("id") int id){
		Optional<Empleado> carData = clienteServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Empleado>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/InsertEmpl")
    public ResponseEntity<Empleado> crear(@Valid @RequestBody Empleado cliente){
        try {
        	Empleado _cat = clienteServiceImpl.create(cliente);
            return new ResponseEntity<Empleado>(_cat, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
        
    }
	
	@DeleteMapping("/DeleteEmpl/{id}")
	public ResponseEntity<Empleado> delete(@PathVariable("id") int id){
		try {
			clienteServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	@PutMapping("EditarEmpl/{id}")
	public ResponseEntity<?> updateCarrera(@PathVariable("id") int id, @Valid @RequestBody Empleado cliente){
		Optional<Empleado> carData = clienteServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Empleado dbcliente = carData.get();
	    	  dbcliente.setNombrec(cliente.getNombrec());
	    	  dbcliente.setDni(cliente.getDni());
	    	  dbcliente.setDireccion(cliente.getDireccion());
	    	  dbcliente.setCargo(cliente.getCargo());



	        return new ResponseEntity<Empleado>(clienteServiceImpl.update(dbcliente), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}
