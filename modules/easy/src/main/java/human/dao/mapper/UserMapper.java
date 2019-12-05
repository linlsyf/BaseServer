package human.dao.mapper;



import auth.User;

import java.util.List;

public interface UserMapper {
        List<User> list();
        User get(String id);
        User getByRegisterId(String registerId);
        User getByLoginId(String loginId);

        int  add(User Order);
        int  delete(String id);
        int update(User Order);
        }