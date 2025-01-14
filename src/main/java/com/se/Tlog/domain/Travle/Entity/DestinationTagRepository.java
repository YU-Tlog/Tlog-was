package com.se.Tlog.domain.Travle.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationTagRepository extends JpaRepository<DestinationTag, DestinationTagPK> {

}
