package com.abhishek.app.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountryRowMapper implements RowMapper<CountryEntity>{

	@Override
	public CountryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CountryEntity countryEntity= new CountryEntity();
		countryEntity.setCountryId(rs.getString("COUNTRY_ID"));
		countryEntity.setCountryName(rs.getString("COUNTRY_NAME"));
		//customer.setEmail(rs.getString("email"));
		return countryEntity;
	}



}
  