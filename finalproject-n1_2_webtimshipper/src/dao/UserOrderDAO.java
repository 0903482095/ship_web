package dao;

import java.util.List;

import model.SearchOrder;
import model.UserOrder;

public interface UserOrderDAO {

	boolean addUserOrder(UserOrder userOrder);

	void editUserOrder(UserOrder order);

	void deleteUserOrder(Integer id);

	void updateStatusUserOrder(Integer id);

	UserOrder getUserOrderById(Integer id);

	List<UserOrder> searchOrder(SearchOrder searchOrder);

	List<UserOrder> getAllUserOrder();

	void shipperUpdateLocation(UserOrder userOrder);

	void shipperPickupOrder(UserOrder userOrder);

	List<UserOrder> getPickedOrders(Integer shipeperId);
	
	UserOrder searchLocationOrder(SearchOrder id);
}
