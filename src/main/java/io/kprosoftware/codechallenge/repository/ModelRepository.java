package io.kprosoftware.codechallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kprosoftware.codechallenge.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
