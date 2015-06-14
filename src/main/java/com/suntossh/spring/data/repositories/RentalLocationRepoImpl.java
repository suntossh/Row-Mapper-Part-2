package com.suntossh.spring.data.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.suntossh.spring.data.entities.RentalLocation;


@Repository
public class RentalLocationRepoImpl implements RentalLocationRepo, org.springframework.jdbc.core.RowMapper<RentalLocation>{

	private JdbcTemplate template;
	private DataSource dataSource;
	
	public static final String SELECT_COLUMNS = "RENTAL_LOCATION_ID, NAME, ADDRESS1, ADDRESS2, CITY, STATE, POSTAL_CODE";
	public static final String SELECT_QUERY = "select name from rental_location where rental_location_id = ?";
	public static final String SELECT_ROW = "select "+SELECT_COLUMNS+" from rental_location where rental_location_id = ?";

	public static final String SELECT_ROWS_BY_STATE = "select "+SELECT_COLUMNS+" from rental_location where state = ?";

	
	@Autowired
	public RentalLocationRepoImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public String getRentalLocationNameById(Integer id){
		return this.template.queryForObject(SELECT_QUERY, new Object[]{id}, java.lang.String.class);
	}
	
	
	public void insert(RentalLocation rentalLocation) {
		
	}

	public void update(RentalLocation rentalLocation) {
		
	}

	public void delete(RentalLocation rentalLocation) {
		
	}

	public RentalLocation getById(Integer id) {
		return this.template.queryForObject(SELECT_ROW, new Object[]{id}, this);
	}
	
	public List<RentalLocation> getByState(String stateName){
		
		return this.template.query(SELECT_ROWS_BY_STATE, new Object[]{stateName}, this);
	}

	public RentalLocation mapRow(ResultSet rs, int rowNum) throws SQLException {
		RentalLocation rentalLocation  = new RentalLocation();
		rentalLocation.setRentalLocationId(rs.getInt("RENTAL_LOCATION_ID"));
		rentalLocation.setName(rs.getString("NAME"));
		rentalLocation.setAddress1(rs.getString("ADDRESS1"));
		rentalLocation.setAddress2(rs.getString("ADDRESS2"));
		rentalLocation.setCity(rs.getString("CITY"));
		rentalLocation.setState(rs.getString("STATE"));
		rentalLocation.setPostalCode(rs.getString("POSTAL_CODE"));
		
		return rentalLocation;
	}



}
