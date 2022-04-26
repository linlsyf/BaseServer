package common;

import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Map;

public class MapCovert  implements Converter<LinkedMap, Map> {

    @Override
    public Map convert(LinkedMap source) {
        if(source == null){
            throw new RuntimeException("参数不能为空");
        }
        try {
            return (Map)source;
        } catch (Exception e) {
            throw new RuntimeException("LinkedMap, Map类型转换时出错");
        }
    }
}

