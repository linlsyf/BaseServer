package dao.Mapper;


import dao.bean.Comment;

import java.util.List;

public interface CommentMapper {
        List<Comment> findAllComment();
        List<Comment> listByStatus(int status);
        List<Comment> search(String key);

        Comment get(String id);

        int  add(Comment Order);
        int  delete(String id);
        int update(Comment Order);
        }