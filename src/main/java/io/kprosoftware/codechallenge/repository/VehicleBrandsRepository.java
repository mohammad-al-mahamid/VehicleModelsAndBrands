package io.kprosoftware.codechallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kprosoftware.codechallenge.entity.VehicleBrand;

public interface VehicleBrandsRepository extends JpaRepository<VehicleBrand, Long> {

}
