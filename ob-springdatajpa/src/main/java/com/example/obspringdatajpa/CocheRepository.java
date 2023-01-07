package com.example.obspringdatajpa;

/*
@Repository --> Lo que dice esto es que es un bean

 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche,Long> {



  }
