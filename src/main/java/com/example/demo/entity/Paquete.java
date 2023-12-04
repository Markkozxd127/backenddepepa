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
@Table(name=" PAQUETE ")
public class Paquete {
	@Id
	@Column(name = "ID_PAQUETE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPaquete")
    @SequenceGenerator(name = "seqPaquete", allocationSize = 1, sequenceName = "SEQ_PAQUETE")
    private Integer id;
	
	//  ---------------------------------------------------------------NOMBRE DEL AUTOR----------------------    
	@Column(name = "TIPO")
	@NotNull @NotBlank    
    private String tipo;
	//  ---------------------------------------------------------------APELLIDO_AUTOR DEL AUTOR--------------
	@Column(name = "NOMBRE")
	@NotNull @NotBlank    
    private String nombre;
	//  ---------------------------------------------------------------FECHA_NACIMIENTO DEL AUTOR-------------
	@Column(name = "PRECIOCOSTO")
	@NotNull @NotBlank    
    private String preciocosto;
	//  ---------------------------------------------------------------LUGAR_NACIMIENTO DEL AUTOR-------------
	@Column(name = "PRECIOVENTA")
	@NotNull @NotBlank    
    private String precioventa;
	
	
	@Column(name = "FECHAINICIO")
	@NotNull @NotBlank    
    private String fechainicio;
	//  ---------------------------------------------------------------APELLIDO_AUTOR DEL AUTOR--------------
	@Column(name = "FECHATERMINO")
	@NotNull @NotBlank    
    private String fechatermino;
	//  ---------------------------------------------------------------FECHA_NACIMIENTO DEL AUTOR-------------
	@Column(name = "CATEGORIA")
	@NotNull @NotBlank    
    private String categoria;
	//  ---------------------------------------------------------------LUGAR_NACIMIENTO DEL AUTOR-------------
	@Column(name = "FECHACONFIRMACION")
	@NotNull @NotBlank    
    private String fechaconfirmacion;
	
	
	@Column(name = "CUPOS")
	@NotNull @NotBlank    
    private String cupos;
	//  ---------------------------------------------------------------LUGAR_NACIMIENTO DEL AUTOR-------------
	@Column(name = "VIGENTE")
	@NotNull @NotBlank    
    private String vigente;

								//TODO RELACIONES 	
	
		//----------RELACION DE AUTOR CON LIBRO----------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paquete")
		@JsonIgnore
		private Set<Reserva> reservas;

}
