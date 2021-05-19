package com.tunisair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunisair.entities.Equipe;

@Repository
public interface EquipeRepository  extends JpaRepository<Equipe, Long>{

}
