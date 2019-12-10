package it.unical.asde.hibernatedemo.repositories;

import org.springframework.data.repository.CrudRepository;

import it.unical.asde.hibernatedemo.model.Car;

public interface CarsDAO  extends CrudRepository<Car, String>{

	
}
