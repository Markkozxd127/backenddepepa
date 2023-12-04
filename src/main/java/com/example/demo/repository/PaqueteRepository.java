package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Paquete;
@Repository
public interface PaqueteRepository extends JpaRepository<Paquete,Integer>{

}