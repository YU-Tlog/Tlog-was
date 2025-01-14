package com.se.Tlog.domain.Travel.repository;

import com.se.Tlog.domain.Travel.Entity.DestinationTag;
import com.se.Tlog.domain.Travel.Entity.DestinationTagPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationTagRepository extends JpaRepository<DestinationTag, DestinationTagPK> {

}
