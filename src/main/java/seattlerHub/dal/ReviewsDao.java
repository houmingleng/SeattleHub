package seattlerHub.dal;

import seattlerHub.model.Reviews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ReviewsDao {
	
	protected ConnectionManager connectionManager;
	private static ReviewsDao instance = null;
	protected ReviewsDao() {
		connectionManager = new ConnectionManager();
	}

	public static ReviewsDao getInstance() {
		if(instance == null) {
			instance = new ReviewsDao();
		}
		return instance;
	}
	
	public Reviews create(Reviews review) throws SQLException {
		String insertReview = "INSERT INTO Reviews(Content,Rating,UserName,HousingID) VALUES(?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertReview,
					Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, review.getContent());
			insertStmt.setDouble(2, review.getRating());
			insertStmt.setString(3, review.getUsers().getUserName());
			insertStmt.setInt(4, review.getHousing().getHousingId());
			insertStmt.executeUpdate();
			resultKey = insertStmt.getGeneratedKeys();
			int reviewId = -1;
			if(resultKey.next()) {
				reviewId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			review.setReviewId(reviewId);
			return review;
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
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}
	
	public Reviews delete(Reviews review) throws SQLException {
		String deleteReview = "DELETE FROM Reviews WHERE ReviewId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteReview);
			deleteStmt.setInt(1, review.getReviewId());
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
