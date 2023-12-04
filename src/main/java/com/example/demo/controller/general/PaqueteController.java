package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Paquete;
import com.example.demo.serviceImpl.PaqueteServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_PAQUETE;;

@RestController
@RequestMapping(API_PAQUETE)
@CrossOrigin({"*"})
public class PaqueteController {
	@Autowired
	private PaqueteServiceImpl clienteServiceImpl;
	
	@GetMapping ("/ListPaque")
	public ResponseEntity<List<Paquete>> listar() {
		try {
		      List<Paquete> cat = clienteServiceImpl.readAll();
		      if (cat.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(cat, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	

	@GetMapping("/BuscarPaque/{id}")
	public ResponseEntity<Paquete> getCategoriaById(@PathVariable("id") int id){
		Optional<Paquete> carData = clienteServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Paquete>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/InsertPaque")
    public ResponseEntity<Paquete> crear(@Valid @RequestBody Paquete cliente){
        try {
        	Paquete _cat = clienteServiceImpl.create(cliente);
            return new ResponseEntity<Paquete>(_cat, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
        
    }
	
	@DeleteMapping("/DeletePaque/{id}")
	public ResponseEntity<Paquete> delete(@PathVariable("id") int id){
		try {
			clienteServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	@PutMapping("EditarPaque/{id}")
	public ResponseEntity<?> updateCarrera(@PathVariable("id") int id, @Valid @RequestBody Paquete cliente){
		Optional<Paquete> carData = clienteServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Paquete dbcliente = carData.get();
	    	  dbcliente.setTipo(cliente.getTipo());
	    	  dbcliente.setNombre(cliente.getNombre());
	    	  dbcliente.setPreciocosto(cliente.getPreciocosto());
	    	  dbcliente.setPrecioventa(cliente.getPrecioventa());
	    	  dbcliente.setFechainicio(cliente.getFechainicio());
	    	  dbcliente.setFechatermino(cliente.getFechatermino());
	    	  dbcliente.setCategoria(cliente.getCategoria());
	    	  dbcliente.setFechaconfirmacion(cliente.getFechaconfirmacion());
	    	  dbcliente.setCupos(cliente.getCupos());
	    	  dbcliente.setVigente(cliente.getVigente());
	        return new ResponseEntity<Paquete>(clienteServiceImpl.update(dbcliente), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}
