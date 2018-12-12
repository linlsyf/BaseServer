package dao.Mapper;


import dao.bean.Goods;

import java.util.List;

public interface GoodsMapper {
        List<Goods> findAllGoods();
        List<Goods> listByStatus(int status);
        List<Goods> search(String key);

        Goods get(String id);

        int  add(Goods Order);
        int  delete(String id);
        int update(Goods Order);
        }