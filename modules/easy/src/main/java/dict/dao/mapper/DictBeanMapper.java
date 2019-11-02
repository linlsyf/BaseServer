package dict.dao.mapper;



import dict.dao.bean.DictBean;

import java.util.List;

public interface DictBeanMapper {
        List<DictBean> list();
        DictBean get(String id);
        DictBean getByRegisterId(String registerId);
        DictBean getByLoginId(String loginId);

        int  add(DictBean Order);
        int  delete(String id);
        int update(DictBean Order);
        }