package ds;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateWrapping  extends JdbcTemplate {

    @Override
    public int update(String sql) throws DataAccessException {
        return super.update(sql);
    }
}
