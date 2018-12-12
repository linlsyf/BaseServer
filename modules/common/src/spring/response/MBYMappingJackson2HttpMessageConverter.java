package spring.response;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 描述:
 *
 */
public class MBYMappingJackson2HttpMessageConverter extends AbstractHttpMessageConverter<MBYViewModel> {
    ObjectMapper mapper = new ObjectMapper();
    private static Log webApi = LogFactory.getLog("webApi");
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public final static String JSON_P_CALLBACK = "callback";

    public MBYMappingJackson2HttpMessageConverter(){
        super( new MediaType("application", "json", DEFAULT_CHARSET),
                new MediaType("application", "*+json", DEFAULT_CHARSET));

        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serialize(Object paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider) throws IOException, JsonProcessingException {
                paramJsonGenerator.writeString("");
            }
        });
    }

    @Override
    protected boolean supports(Class clazz) {
        return MBYViewModel.class.isAssignableFrom(clazz);
    }



    @Override
    protected MBYViewModel readInternal(Class<? extends MBYViewModel> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
//        System.out.println("----------------");
        return null;
    }


    @Override
    protected void writeInternal(MBYViewModel o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            logger.debug("-->" + request.getRequestURI() +  " " + request.getParameterMap());

            //这里将进行统一优化处理，输出时，如果数据为空或者是字符串为空，将去除
//            Map map = BeanUtils.bean2Map(o);

//            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

            if("0000".equals(o.getCode()) && o.getData() instanceof RawJsonData){
                String json = mapper.writeValueAsString(((RawJsonData)o.getData()).getData());
                logger.debug("<--" + json);
                outputMessage.getBody().write(json.getBytes(DEFAULT_CHARSET));
            }
            else {
                //JSON输出
                String callback = request.getParameter(JSON_P_CALLBACK);
                boolean isJsonP = callback != null && callback.length() > 0;
                //是否输出用户
                String isOutputUser = request.getParameter("isOutputUser");
                String json;

                   json = mapper.writeValueAsString(o);



                if (isJsonP) {
                    json = new StringBuilder(JSON_P_CALLBACK).append("(").append(json).append(")").toString();
                }
                logger.debug("<--" + json);

                //如果返回的对象不为 0000,需要进行记录
                if(o instanceof  MBYResponseViewModel
                        && !("0000".equals (((MBYResponseViewModel)o).getCode()))){
                    webApi.error("URI:" + request.getRequestURI());
                    webApi.error("Referer:" + request.getHeader("Referer"));
                    webApi.error("User-Agent:" + request.getHeader("User-Agent"));
                    webApi.error("输入:" + mapper.writeValueAsString(request.getParameterMap()));
                    webApi.error("输出" + json +"\n\n");
                }
                outputMessage.getBody().write(json.getBytes(DEFAULT_CHARSET));
            }
        } catch (Exception e) {
           logger.error("", e);
        }
    }


}
