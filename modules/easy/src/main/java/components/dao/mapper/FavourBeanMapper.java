package components.dao.mapper;



import favour.dao.bean.FavourBean;

import java.util.List;

public interface FavourBeanMapper {
        List<FavourBean> list();
        FavourBean get(String id);
        FavourBean getByRegisterId(String registerId);
        FavourBean getByLoginId(String loginId);

        int  add(FavourBean Order);
        int  delete(String id);
        int update(FavourBean Order);
        }