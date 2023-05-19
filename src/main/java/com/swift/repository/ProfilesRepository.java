package com.swift.repository;

import com.swift.model.ProfilesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilesRepository extends JpaRepository<ProfilesModel, Long> {
}
