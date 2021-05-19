package com.tunisair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunisair.entities.EquipePersonnel;

@Repository
public interface EquipePersonnelRepository  extends JpaRepository<EquipePersonnel, Long>{

}
