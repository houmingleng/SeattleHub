package seattlerHub.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import seattlerHub.model.Students;
import seattlerHub.model.Users;


public class StudentsDao extends UsersDao{
	
	protected ConnectionManager connectionManager;
	private static StudentsDao instance = null;
	protected StudentsDao() {
		connectionManager = new ConnectionManager();
	}

	public static StudentsDao getInstance() {
		if(instance == null) {
			instance = new StudentsDao();
		}
		return instance;
	}
	
	public Students create(Students student) throws SQLException {
		create(new Users(student.getUserName(), student.getPassword(), student.getFirstName(), student.getLastName(),
      student.getEmail(), student.getPhone(), student.getHousing(), student.getIfBioVisible(), student.getAuthenticatedResident()));
		
		String insertStudent = "INSERT INTO Students(UserName, School) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertStudent);
			insertStmt.setString(1, student.getUserName());
			insertStmt.setString(2, student.getSchool());
			insertStmt.executeUpdate();
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}
	
	public Students delete(Students student) throws SQLException {
		
		String deleteStudent = "DELETE FROM Students WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteStudent);
			deleteStmt.setString(1, student.getUserName());
			deleteStmt.executeUpdate();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

}
