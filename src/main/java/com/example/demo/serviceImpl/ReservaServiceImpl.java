package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservaDto;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Empleado;
import com.example.demo.entity.Paquete;
import com.example.demo.entity.Reserva;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.EmpleaddoRepository;
import com.example.demo.repository.PaqueteRepository;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.service.ReservaService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaServiceImpl implements ReservaService<Reserva>{

	
	@Autowired
	private ReservaRepository reservaRepository ;
	
	
	@Autowired
	private ClienteRepository clienteRepository ;	
	@Autowired
	private PaqueteRepository paqueteRepository ;	
	@Autowired
	private EmpleaddoRepository empleaddoRepository ;

	@Override
	public Reserva update(int id, ReservaDto reservaDto) {
	    Optional<Reserva> optionalReserva = reservaRepository.findById(id);

	    if (optionalReserva.isPresent()) {
	    	Reserva reserva = optionalReserva.get();

	        // Actualiza los campos del libro con los valores del DTO
	    	reserva.setFecha(reservaDto.getFecha());
	    	reserva.setCantidad(reservaDto.getCantidad());
	    	reserva.setTipopago(reservaDto.getTipopago());
	    	reserva.setTotalventa(reservaDto.getTotalventa());
	    	reserva.setDescuento(reservaDto.getDescuento());
	    	reserva.setTotalneto(reservaDto.getTotalneto());
	    	reserva.setConfirmado(reservaDto.getConfirmado());
	    	reserva.setAnulado(reservaDto.getAnulado());

	      

	    	reserva.setEmpleado(empleaddoRepository.findById(reservaDto.getEmpleado()).orElse(null));
	    	reserva.setPaquete(paqueteRepository.findById(reservaDto.getPaquete()).orElse(null));
	    	reserva.setCliente(clienteRepository.findById(reservaDto.getCliente()).orElse(null));


	        // Guarda el libro actualizado en la base de datos
	        return reservaRepository.save(reserva);
	    } else {
	        throw new ResourceNotFoundException("reserva no encontrado con ID: " + id);
	    }
	}
	


	@Override
	public void delete(int id) {
		reservaRepository.deleteById(id);
	}

	@Override
	public Optional<Reserva> read(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Reserva> readAll() {
		// TODO Auto-generated method stub
	    return reservaRepository.findAll();
	}
	
	
	
	
    public Reserva guardarReserva(ReservaDto reservaDto) {
        Empleado empleado = empleaddoRepository.findById(reservaDto.getEmpleado())
                .orElseThrow(() -> new EntityNotFoundException("HOTEL not found"));
        
        Paquete paquete = paqueteRepository.findById(reservaDto.getPaquete())
                .orElseThrow(() -> new EntityNotFoundException("SUCURSAL not found"));
        
        Cliente cliente = clienteRepository.findById(reservaDto.getCliente())
                .orElseThrow(() -> new EntityNotFoundException("CLIENTE not found"));
        
   

        Reserva reserva = new Reserva();
    
        reserva.setFecha(reservaDto.getFecha());
        reserva.setCantidad(reservaDto.getCantidad());

        reserva.setTipopago(reservaDto.getTipopago());

        reserva.setTotalventa(reservaDto.getTotalventa());

        reserva.setDescuento(reservaDto.getDescuento());

        reserva.setTotalneto(reservaDto.getTotalneto());

        reserva.setConfirmado(reservaDto.getConfirmado());
        reserva.setAnulado(reservaDto.getAnulado());


    	
    	
        reserva.setEmpleado(empleado);
        reserva.setPaquete(paquete);
        reserva.setCliente(cliente);
        
        return reservaRepository.save(reserva);
    }
}