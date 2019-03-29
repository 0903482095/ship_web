package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDAO;
import model.User;
import utils.DBConnection;

public class UserDAOImpl implements UserDAO {

	private Connection connection;

	@Override
	public User login(String username, String password) {
		try {
			connection = DBConnection.connect();
			String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setRoleId(rs.getInt("role_id"));
				user.setLat(rs.getFloat("lat"));
				user.setLng(rs.getFloat("lng"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@Override
	public void register(User user) {
		try {
			connection = DBConnection.connect();
			String sql = "INSERT INTO user(username, password, address, role_id, lat, lng, avatar) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setInt(4, user.getRoleId());
			preparedStatement.setFloat(5, user.getLat());
			preparedStatement.setFloat(6, user.getLng());
			preparedStatement.setString(7, user.getAvatar());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getUserById(Integer id) {
		connection = DBConnection.connect();
		User user = new User();
		try {
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setRoleId(rs.getInt(5));
			}

			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
