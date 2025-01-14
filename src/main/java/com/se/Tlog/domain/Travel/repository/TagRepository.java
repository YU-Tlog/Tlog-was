package com.se.Tlog.domain.Travel.repository;

import com.se.Tlog.domain.Travel.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
