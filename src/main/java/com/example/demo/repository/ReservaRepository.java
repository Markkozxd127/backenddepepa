package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reserva;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer>{

}