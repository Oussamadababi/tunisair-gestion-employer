package com.tunisair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunisair.entities.personnel.Magasin;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin, Long> {

}
