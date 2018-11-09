package com.abhishek.app.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LocationRowMapper implements RowMapper<LocationEntity>{

	@Override
	public LocationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LocationEntity locationEntity= new LocationEntity();
		locationEntity.setLocationId(rs.getInt("LOCATION_ID"));
		locationEntity.setLocationName(rs.getString("CITY"));
		//customer.setEmail(rs.getString("email"));
		return locationEntity;
	}



}
  