package human.dao.mapper;



import human.dao.bean.RoleUser;

import java.util.List;

public interface RoleUserMapper {
        List<RoleUser> list();

        int  add(RoleUser Order);
        int  delete(String id);
        int update(RoleUser Order);
        RoleUser get(String id);


}