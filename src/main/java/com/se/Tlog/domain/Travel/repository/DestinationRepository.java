package com.se.Tlog.domain.Travel.repository;

import com.se.Tlog.domain.Travel.Entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
