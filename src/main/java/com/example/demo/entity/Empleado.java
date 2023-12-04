package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name=" EMPLEADO ")
public class Empleado {
	@Id
	@Column(name = "ID_EMPLEADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmpleado")
    @SequenceGenerator(name = "seqEmpleado", allocationSize = 1, sequenceName = "SEQ_EMPLEADO")
    private Integer id;
	
	//  ---------------------------------------------------------------NOMBRE DEL AUTOR----------------------    
	@Column(name = "NOMBREC")
	@NotNull @NotBlank    
    private String nombrec;
	//  ---------------------------------------------------------------APELLIDO_AUTOR DEL AUTOR--------------
	@Column(name = "DNI")
	@NotNull @NotBlank    
    private String dni;
	//  ---------------------------------------------------------------FECHA_NACIMIENTO DEL AUTOR-------------
	@Column(name = "DIRECCION")
	@NotNull @NotBlank    
    private String direccion;
	//  ---------------------------------------------------------------LUGAR_NACIMIENTO DEL AUTOR-------------
	@Column(name = "CARGO")
	@NotNull @NotBlank    
    private String cargo;

								//TODO RELACIONES 	
	
		//----------RELACION DE AUTOR CON LIBRO----------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empleado")
		@JsonIgnore
		private Set<Reserva> reservas;

}
