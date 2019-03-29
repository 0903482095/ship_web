package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserOrderDAO;
import model.SearchOrder;
import model.UserOrder;
import utils.DBConnection;

public class UserOrderDAOImpl implements UserOrderDAO {

	private Connection connection;

	@Override
	public boolean addUserOrder(UserOrder userOrder) {
		try {
			connection = DBConnection.connect();
			String sql = "INSERT INTO user_order(created_by, content, lat1, lng1, fee, created_date, status, lat2, lng2, from_add, to_add) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userOrder.getCreatedBy());
			preparedStatement.setString(2, userOrder.getContent());
			preparedStatement.setFloat(3, userOrder.getLat1());
			preparedStatement.setFloat(4, userOrder.getLng1());

			preparedStatement.setLong(5, userOrder.getFee());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			preparedStatement.setTimestamp(6, date);
			preparedStatement.setInt(7, userOrder.getStatus());
			preparedStatement.setFloat(8, userOrder.getLat2());
			preparedStatement.setFloat(9, userOrder.getLng2());
			preparedStatement.setString(10, userOrder.getFromAdd());
			preparedStatement.setString(11, userOrder.getToAdd());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void editUserOrder(UserOrder order) {
		connection = DBConnection.connect();
		try {
			String sql = "UPDATE user_order SET content = ?, fee = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, order.getContent());
			preparedStatement.setLong(2, order.getFee());
			preparedStatement.setInt(3, order.getId());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUserOrder(Integer id) {
		try {
			connection = DBConnection.connect();
			String sql = "DELETE FROM user_order WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatusUserOrder(Integer id) {
		connection = DBConnection.connect();
		try {
			String sql = "UPDATE user_order set status = 1 where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserOrder getUserOrderById(Integer id) {
		connection = DBConnection.connect();
		try {
			String sql = "SELECT * FROM user_order WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			UserOrder order = new UserOrder();
			while (rs.next()) {
				order.setId(rs.getInt(1));
				order.setCreatedBy(rs.getInt(2));
				order.setContent(rs.getString(3));
				order.setLat1(rs.getFloat(4));
				order.setLng1(rs.getFloat(5));
				order.setFee(rs.getLong(6));
				order.setCreatedDate(rs.getDate(7));
				order.setStatus(rs.getInt(8));
				order.setLat2(rs.getFloat(9));
				order.setLng2(rs.getFloat(10));
			}
			return order;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserOrder> searchOrder(SearchOrder searchOrder) {
		List<UserOrder> orders = new ArrayList<UserOrder>();
		try {
			connection = DBConnection.connect();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"SELECT * FROM user_order uo INNER JOIN user u ON uo.created_by = u.id WHERE 1=1 AND LCASE (uo.content) LIKE LCASE(?) AND uo.shipperId IS NULL");

			if (searchOrder.getPage() != null && searchOrder.getPageSize() != null) {
				sql.append(" LIMIT " + searchOrder.getPageSize() + " OFFSET "
						+ (searchOrder.getPage() - 1) * searchOrder.getPageSize());
			}
			if (searchOrder.getUserOrderId() != null) {
				sql.append(" AND uo.id=?");
			}
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			if (searchOrder.getUserOrderId() != null) {
				preparedStatement.setInt(2, searchOrder.getUserOrderId());
			}
			if (searchOrder.getKeyWord() == null) {
				preparedStatement.setString(1, "%%");
			} else {
				preparedStatement.setString(1, "%" + searchOrder.getKeyWord() + "%");
			}
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UserOrder order = new UserOrder();
				order.setId(rs.getInt(1));
				order.setCreatedBy(rs.getInt(2));
				order.setContent(rs.getString(3));
				order.setLat1(rs.getFloat(4));
				order.setLng1(rs.getFloat(5));
				order.setFee(rs.getLong(6));
				order.setCreatedDate(rs.getDate(7));
				order.setStatus(rs.getInt(8));
				order.setLat2(rs.getFloat(9));
				order.setLng2(rs.getFloat(10));

				orders.add(order);
			}
			return orders;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserOrder> getAllUserOrder() {
		try {
			connection = DBConnection.connect();
			String sql = "SELECT * FROM user_order";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<UserOrder> orders = new ArrayList<UserOrder>();
			while (rs.next()) {
				UserOrder order = new UserOrder();
				order.setCreatedBy(rs.getInt(2));
				order.setContent(rs.getString(3));
				order.setLat1(rs.getFloat(4));
				order.setLng1(rs.getFloat(5));
				order.setFee(rs.getLong(6));
				order.setCreatedDate(rs.getDate(7));
				order.setStatus(rs.getInt(8));
				order.setLat2(rs.getFloat(9));
				order.setLng2(rs.getFloat(10));

				orders.add(order);
			}
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void shipperUpdateLocation(UserOrder userOrder) {
		connection = DBConnection.connect();
		try {
			String sql = "UPDATE user_order SET lat3=?, lng3=? WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, userOrder.getLat3());
			preparedStatement.setFloat(2, userOrder.getLng3());
			preparedStatement.setInt(3, userOrder.getId());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void shipperPickupOrder(UserOrder userOrder) {
		connection = DBConnection.connect();
		try {
			String sql = "UPDATE user_order SET shipperId=? WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userOrder.getShipperId());
			preparedStatement.setInt(2, userOrder.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<UserOrder> getPickedOrders(Integer shipeperId) {
		List<UserOrder> orders = new ArrayList<UserOrder>();
		connection = DBConnection.connect();
		try {
			String sql = "SELECT * FROM user_order WHERE shipperId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, shipeperId);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UserOrder order = new UserOrder();
				order.setId(rs.getInt(1));
				order.setCreatedBy(rs.getInt(2));
				order.setContent(rs.getString(3));
				order.setLat1(rs.getFloat(4));
				order.setLng1(rs.getFloat(5));
				order.setFee(rs.getLong(6));
				order.setCreatedDate(rs.getDate(7));
				order.setStatus(rs.getInt(8));
				order.setLat2(rs.getFloat(9));
				order.setLng2(rs.getFloat(10));

				orders.add(order);
			}
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserOrder searchLocationOrder(SearchOrder searchOrder) {
		try {
			connection = DBConnection.connect();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"SELECT * FROM user_order uo INNER JOIN user u ON uo.created_by = u.id WHERE 1=1 AND LCASE (uo.content) LIKE LCASE(?) AND uo.shipperId IS NOT NULL");

			if (searchOrder.getPage() != null && searchOrder.getPageSize() != null) {
				sql.append(" LIMIT " + searchOrder.getPageSize() + " OFFSET "
						+ (searchOrder.getPage() - 1) * searchOrder.getPageSize());
			}
			if (searchOrder.getUserOrderId() != null) {
				sql.append(" AND uo.id=?");
			}
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			if (searchOrder.getUserOrderId() != null) {
				preparedStatement.setInt(2, searchOrder.getUserOrderId());
			}
			if (searchOrder.getKeyWord() == null) {
				preparedStatement.setString(1, "%%");
			} else {
				preparedStatement.setString(1, "%" + searchOrder.getKeyWord() + "%");
			}
			ResultSet rs = preparedStatement.executeQuery();
			UserOrder order = new UserOrder();
			while (rs.next()) {
				order.setId(rs.getInt(1));
				order.setCreatedBy(rs.getInt(2));
				order.setContent(rs.getString(3));
				order.setLat1(rs.getFloat(4));
				order.setLng1(rs.getFloat(5));
				order.setFee(rs.getLong(6));
				order.setCreatedDate(rs.getDate(7));
				order.setStatus(rs.getInt(8));
				order.setLat2(rs.getFloat(9));
				order.setLng2(rs.getFloat(10));
				order.setLat3(rs.getFloat(11));
				order.setLng3(rs.getFloat(12));
			}
			return order;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
