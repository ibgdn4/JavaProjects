package com.spring.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class MainApp {
	static JdbcTemplate jdbcTemplateObj;
	static SimpleDriverDataSource dataSourceObj;
	
	// Database Configuration Parameters
	static String DB_USERNAME = "demo";
	static String DB_PASSWORD = "demo";
	static String DB_URL = "jdbc:mysql://192.168.129.130:3306/contactdb";
	
	public static SimpleDriverDataSource getDatabaseConnection(){
		dataSourceObj = new SimpleDriverDataSource();
		try {
			dataSourceObj.setDriver(new com.mysql.jdbc.Driver());
			dataSourceObj.setUrl(DB_URL);
			dataSourceObj.setUsername(DB_USERNAME);
			dataSourceObj.setPassword(DB_PASSWORD);
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return dataSourceObj;
	}
	
	public static void main(String[] args) {
		// Code To Set Driver Class Name, Database URL, Username & Password
		jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());
		
		if(null != jdbcTemplateObj) {
			// SQL Operation #1 - SQL INSERT Operation
			String sqlInsertQuery = "INSERT INTO contact (name, email, address, telephone) VALUES (?, ?, ?, ?)";
			for(int i = 101; i < 106; i++) {
				jdbcTemplateObj.update(sqlInsertQuery, "Editor " + i, "editor" + i + "@spring.com", "G", "0123456789");
			}
			
			// SQL　Operation #2 - SQL UPDATE Operation
			String sqlUpdateQuery = "UPDATE contact set email = ? where name = ?";
			jdbcTemplateObj.update(sqlUpdateQuery, "administrator@spring.com", "Editor 101");
			
			// SQL Operation #3 - SQL READ Operation
			String sqlSelectQuery = "SELECT name, email, address, telephone FROM contact";
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Contact> listContacts = jdbcTemplateObj.query(sqlSelectQuery, new RowMapper() {
				public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
					Contact contactObj = new Contact();
					contactObj.setName(result.getString("name"));
					contactObj.setEmail(result.getString("email"));
					contactObj.setAddress(result.getString("address"));
					contactObj.setPhone(result.getString("telephone"));
					return contactObj;
				}
			});
			
			// Displaying The SQL Records
			for(Contact contactDetail : listContacts) {
				System.out.println(contactDetail.toString());
			}

			// SQL Operation #4 - SQL DELETE Operation
			String sqlDeleteQuery = "DELETE FROM contact WHERE name = ?";
			jdbcTemplateObj.update(sqlDeleteQuery, "Editor 104");
		} else {
			System.out.println("Application Is Not Able To Bind With The Database! Please Checke!");
		}
	}
}
