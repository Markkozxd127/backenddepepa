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
@Table(name=" CLIENTE ")
public class Cliente {
	@Id
	@Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
    @SequenceGenerator(name = "seqCliente", allocationSize = 1, sequenceName = "SEQ_CLIENTE")
    private Integer id;
	
	//  ---------------------------------------------------------------NOMBRE DEL AUTOR----------------------    
	@Column(name = "APELLIDOS")
	@NotNull @NotBlank    
    private String apellidos;
	//  ---------------------------------------------------------------APELLIDO_AUTOR DEL AUTOR--------------
	@Column(name = "NOMBRES")
	@NotNull @NotBlank    
    private String nombres;
	//  ---------------------------------------------------------------FECHA_NACIMIENTO DEL AUTOR-------------
	@Column(name = "SEXO")
	@NotNull @NotBlank    
    private String sexo;
	//  ---------------------------------------------------------------LUGAR_NACIMIENTO DEL AUTOR-------------
	@Column(name = "PAIS")
	@NotNull @NotBlank    
    private String pais;
	//  ---------------------------------------------------------------GENERO DEL AUTOR-----------------------
	@Column(name = "FECHANACIMIENTO")
	@NotNull @NotBlank    
    private String fechanacimiento;
	
	
	@Column(name = "DIDENTIDAD")
	@NotNull @NotBlank    
    private String didentidad;
	//  ---------------------------------------------------------------GENERO DEL AUTOR-----------------------
	@Column(name = "FOTO")
	@NotNull @NotBlank    
    private String foto;
								//TODO RELACIONES 	
	
		//----------RELACION DE AUTOR CON LIBRO----------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
		@JsonIgnore
		private Set<Reserva> reservas;
		
		

}
