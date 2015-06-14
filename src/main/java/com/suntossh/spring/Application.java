package com.suntossh.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suntossh.spring.data.entities.RentalLocation;
import com.suntossh.spring.data.repositories.RentalLocationRepo;
import com.suntossh.spring.data.repositories.RentalLocationRepoImpl;


public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/application-config.xml");
		RentalLocationRepo rentalLocationRepo = applicationContext.getBean("rentalLocationRepoImpl", RentalLocationRepoImpl.class);
		/*System.out.println(rentalLocationRepo.getRentalLocationNameById(new Integer(4)));
		
		RentalLocation rentalLocation = rentalLocationRepo.getById(3);
		System.out.println(rentalLocation.getRentalLocationId());
		System.out.println(rentalLocation.getName());
		System.out.println(rentalLocation.getAddress1());*/
		
		List<RentalLocation> rentalLocList = rentalLocationRepo.getByState("NJ");
		
		for(RentalLocation rentalLocation: rentalLocList){
			System.out.println(rentalLocation.getRentalLocationId());
			System.out.println(rentalLocation.getName());
			System.out.println(rentalLocation.getAddress1());
			System.out.println(rentalLocation.getState());
		}
		
		
	}
}
