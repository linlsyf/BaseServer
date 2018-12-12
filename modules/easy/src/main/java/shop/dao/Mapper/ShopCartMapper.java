package shop.dao.Mapper;


import shop.dao.bean.ShopCart;

import java.util.List;

public interface ShopCartMapper {
        List<ShopCart> findAllOrders();
        List<ShopCart> listByStatus(int status);
        ShopCart get(String id);

        int  add(ShopCart Order);
        int  delete(String id);
        int update(ShopCart Order);
        }