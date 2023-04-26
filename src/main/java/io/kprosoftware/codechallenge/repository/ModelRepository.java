package io.kprosoftware.codechallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kprosoftware.codechallenge.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
  List<Model> findByvehicleBrandId(Long ByvehicleBrandId);
}
