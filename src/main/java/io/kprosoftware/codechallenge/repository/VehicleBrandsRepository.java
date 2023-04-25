package io.kprosoftware.codechallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kprosoftware.codechallenge.entity.VehicleBrands;

public interface VehicleBrandsRepository extends JpaRepository<VehicleBrands, Long> {

}
