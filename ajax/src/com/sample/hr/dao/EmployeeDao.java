package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.vo.Department;
import com.sample.hr.vo.Employee;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;

public class EmployeeDao {

	public List<Department> getAllDepartments() throws SQLException {
		List<Department> depts = new ArrayList<Department>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt =conn.prepareStatement(QueryUtil.getSQL("hr.getAllDepartments"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Department dept = new Department();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			
			depts.add(dept);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return depts;
	}
	
	public List<Employee> getEmployeesByDept(int departmentId) throws SQLException {
		List<Employee> emps = new ArrayList<Employee>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt =conn.prepareStatement(QueryUtil.getSQL("hr.getEmployeesByDept"));
		pstmt.setInt(1, departmentId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emps.add(emp);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return emps;
	}
	
	public Employee getEmployeeById(int employeeId) throws SQLException{
		Employee employee = null;
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("hr.getEmployeeById"));
		pstmt.setInt(1, employeeId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setSalary(rs.getDouble("salary"));
			employee.setHireDate(rs.getDate("hire_date"));
			employee.setJobId(rs.getString("job_id"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return employee;
	}
	
}
