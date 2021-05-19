package com.tunisair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunisair.entities.Habilitation;

@Repository
public interface HabilitationRepository extends JpaRepository<Habilitation, Long>{

}
