package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="RESERVA")
public class Reserva {
	@Id
	@Column(name = "ID_RESERVA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReserva")
    @SequenceGenerator(name = "seqReserva", allocationSize = 1, sequenceName = "SEQ_RESERVA")
    private Integer id;
	
	
	//atributos
	
	@Column(name = "FECHA")  
	@NotNull @NotBlank    
    private String 	fecha;
	
	
	@Column(name = "CANTIDAD")  
	@NotNull @NotBlank    
    private String cantidad;
	
	
	@Column(name = "TIPOPAGO")  
	@NotNull @NotBlank    
    private String tipopago;
	
	
	@Column(name = "TOTALVENTA")  
	@NotNull @NotBlank    
    private String totalventa;
	
	
	@Column(name = "DESCUENTO")  
	@NotNull @NotBlank    
    private String descuento;
	
	
	
	@Column(name = "TOTALNETO")  
	@NotNull @NotBlank    
    private String totalneto;
	
	
	@Column(name = "CONFIRMADO")  
	@NotNull @NotBlank    
    private String confirmado;
	
	
	@Column(name = "ANULADO")  
	@NotNull @NotBlank    
    private String anulado;
	

	

	
	
//TODO RELACIONES  FORANEAS	
	

		
		@ManyToOne
		@JoinColumn(name="CLIENTE_ID", nullable = false)
		private Cliente cliente;
		
		@ManyToOne
		@JoinColumn(name="PAQUETE_ID", nullable = false)
		private Paquete paquete;
		
		@ManyToOne
		@JoinColumn(name="EMPLEADO_ID", nullable = false)
		private Empleado empleado;
		

		

		
		
}

