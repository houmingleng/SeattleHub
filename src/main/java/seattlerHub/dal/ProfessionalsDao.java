package seattlerHub.dal;

import seattlerHub.model.Professionals;
import seattlerHub.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;





public class ProfessionalsDao extends UsersDao{
	
	protected ConnectionManager connectionManager;
	private static ProfessionalsDao instance = null;
	protected ProfessionalsDao() {
		connectionManager = new ConnectionManager();
	}

	public static ProfessionalsDao getInstance() {
		if(instance == null) {
			instance = new ProfessionalsDao();
		}
		return instance;
	}
	
	public Professionals create(Professionals professional) throws SQLException {
		create( new Users(professional.getUserName(), professional.getPassword(),
				professional.getFirstName(), professional.getLastName(),
      professional.getEmail(), professional.getPhone(), professional.getHousing(),
				professional.getIfBioVisible(), professional.getAuthenticatedResident()));
		
		String insertProfessional = "INSERT INTO Professionals(UserName, Company) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertProfessional);
			insertStmt.setString(1, professional.getUserName());
			insertStmt.setString(2, professional.getCompany());
			insertStmt.executeUpdate();
			return professional;
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
	
	public Professionals delete(Professionals professional) throws SQLException {
		
		String deleteProfessional = "DELETE FROM Professionals WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteProfessional);
			deleteStmt.setString(1, professional.getUserName());
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
