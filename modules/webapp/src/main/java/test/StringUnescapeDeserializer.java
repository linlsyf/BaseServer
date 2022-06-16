package test;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.apache.commons.lang3.StringEscapeUtils;

import java.lang.reflect.Type;

public class StringUnescapeDeserializer implements JsonDeserializer<String> {



    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        String src = json.getAsJsonPrimitive().getAsString();
        if (src.indexOf('&') == -1) {
            return src;
        } else {
            // 可能存在html实体字符
            return StringEscapeUtils.unescapeHtml4(src);
        }
    }

}