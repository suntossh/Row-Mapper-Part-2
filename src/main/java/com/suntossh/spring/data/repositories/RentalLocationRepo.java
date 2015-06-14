package com.suntossh.spring.data.repositories;

import java.util.List;

import com.suntossh.spring.data.entities.RentalLocation;


public interface RentalLocationRepo extends Repo<RentalLocation> {

	public String getRentalLocationNameById(Integer id);
	
	public List<RentalLocation> getByState(String stateName);
}
