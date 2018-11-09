package com.abhishek.app.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartmentRowMapper implements RowMapper<DepartmentEntity>{

	@Override
	public DepartmentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DepartmentEntity departmentEntity= new DepartmentEntity();
		departmentEntity.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
		departmentEntity.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
		//customer.setEmail(rs.getString("email"));
		return departmentEntity;
	}



}
  