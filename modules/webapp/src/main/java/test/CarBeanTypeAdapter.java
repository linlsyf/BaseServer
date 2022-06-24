package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.NetInterBean;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import test.bean.CatBean;

public class CarBeanTypeAdapter extends TypeAdapter {

    @Override
    public void write(JsonWriter out, Object o) throws IOException {
        out.beginObject();

        out.endObject();
    }

    @Override
    public Object read(JsonReader in) throws IOException {
         NetInterBean carbean = new NetInterBean();
        while (in.hasNext()) {
              try {
                  Object data="";
                  data= getObject(carbean,in);

          System.out.println("data="+data);
              }   catch (Exception e) {
//                  in.nextName();
                  e.printStackTrace();
              }

        }
//        in.endObject();
     return carbean;
    }
    public Object readChild(JsonReader in) throws IOException {
        final NetInterBean carbean = new NetInterBean();

//        in.beginObject();
        while (in.hasNext()) {
              try {
                  Object data="";
                  data= getObject(carbean,in);

          System.out.println("data="+data);
              }   catch (Exception e) {
//                  in.nextName();
                  e.printStackTrace();
              }

        }
//        in.endObject();
     return carbean;
    }

    private Object getObject(NetInterBean carbean ,JsonReader in) throws IOException {
        JsonToken token = in.peek();
        switch (token) {
            case NAME:
                return in.nextName();
//                return in.nextName();
            case BEGIN_ARRAY:
                List<Object> list = new ArrayList<Object>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(readChild(in));
                }
                 in.endArray();

                return list;
//                return list;

            case BEGIN_OBJECT:
                Map<String, Object> map = new LinkedTreeMap<String, Object>();
                in.beginObject();
                read(in);
                in.endObject();
//                return   map;
//                return    in.nextString();
//                return      map.put(in.nextName(), read(in));


            case STRING:
                return in.nextString();

            case NUMBER:
                /**
                 * 改写数字的处理逻辑，将数字值分为整型与浮点型。
                 */
                double dbNum = in.nextDouble();

                // 数字超过long的最大值，返回浮点类型
                if (dbNum > Long.MAX_VALUE) {
                    return dbNum;
                }

                // 判断数字是否为整数值
                long lngNum = (long) dbNum;
                if (dbNum == lngNum) {
                    return lngNum;
                } else {
                    return dbNum;
                }

            case BOOLEAN:
                return in.nextBoolean();

            case NULL:
                in.nextNull();
                return null;

//            default:
//                throw null;
//                throw new IllegalStateException();
        }
        return null;
    }
}