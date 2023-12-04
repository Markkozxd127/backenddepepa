package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class ReservaDto {
	
 
    private String 	fecha;
	
  
    private String cantidad;
	
 
    private String tipopago;
	
	
   
    private String totalventa;
	
	

    private String descuento;
	
	
  
    private String totalneto;
	
    
    private String confirmado;
	
   
    private String anulado;
	

	


	
		private int cliente;

		private int paquete;
		
		private int empleado;
		
}
