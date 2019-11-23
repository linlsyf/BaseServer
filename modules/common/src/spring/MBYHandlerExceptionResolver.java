package spring;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;



/**
 * 描述:
 *
 */
public class MBYHandlerExceptionResolver implements HandlerExceptionResolver {

//    protected final static Logger logger = LoggerFactory.getLogger(MBYHandlerExceptionResolver.class);
    ObjectMapper mapper = new ObjectMapper();
//    private final static Logger webApi = LoggerFactory.getLogger("webApi");
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
//    @Autowired
//    MessageService messageService;
    ServletOutputStream outputStream;
//    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse resp, Object handler, Exception e) {

        try {
            resp.setContentType("application/json;charset=UTF-8");
//            String[] ss = MBY_UNKNOWN_ERROR.split(",");
//            String errorMsg = ss[1];
//            String errorCode = ss[0];
            Throwable throwable = e;

//            if(e instanceof UndeclaredThrowableException){
//                throwable = (Exception) CFTools.getFirstCause(e);
//            }
//            if(throwable.getClass().getName().contains("com.alibaba.dubbo.rpc.RpcException")){
//                ss = MBY_CA_CONNECTION_EXCEPTION.split(",");
//                errorMsg = ss[1];
//                errorCode = ss[0];
//            }
//            else if(throwable instanceof CAException){
//                CAException caException = (CAException)throwable;
//                errorMsg =  caException.getMessage();
//                if(ZStringUtils.isNotEmpty(caException.getCode()) && caException.getCode().length()==4){
//                    errorCode = caException.getCode();
//                }
//                logger.error(throwable.toString());
//            }
//            else if(throwable instanceof MbyApiException){
//                MbyApiException ex = (MbyApiException)throwable;
//                errorMsg =  ex.getMessage();
//                if(ZStringUtils.isNotEmpty(ex.getCode()) && ex.getCode().length()==4){
//                    errorCode = ex.getCode();
//                    errorMsg = ex.getMessage();
//                }
//
//            }
//            else if (throwable instanceof ServiceException ) {
//                errorMsg =  throwable.getMessage();
//            }
//            else if(throwable instanceof NullPointerException){
//
//                //show the unknown error message , do not show inner error to UI page.
//                logger.error(ViewModelConst.MBY_UNKNOWN_ERROR, throwable);
//            }
//            else if(throwable instanceof IllegalAccessException){
//                //show the unknown error message , do not show inner error to UI page.
//                String[] s = ERR_MISS_PARAM.split(",");
//                errorMsg = s[1] + throwable.getMessage();
//                errorCode = s[0];
//                logger.error(ERR_MISS_PARAM, throwable);
//            }
//            else if(throwable instanceof  AssertException){
//                AssertException ae = (AssertException)throwable;
//                errorCode =ae.getCode();
//                errorMsg =ae.getMessage();
//                logger.error(ae.getMessage());
//            }
//            else{
//                //show the unknown error message , do not show inner error to UI page.
//                logger.error(MBY_UNKNOWN_ERROR, throwable);
//                //没处理的异常
//                String to = MbyConfig.getProp("mby.error.email.to");
//                if(to!=null && ZStringUtils.isNotEmpty(to.trim())){
//                    String error = CFTools.printStackTrace(throwable);
//
//                    try {
//                        messageService.postEmailMessage(to, "政信异常[" + MbyInfoUtil.getHostIp() + "]", error);
//                    }
//                    catch (Exception ex){
//                        logger.error("",ex);
//                    }
//                }
//            }
//
//            String callback = request.getParameter(JSON_P_CALLBACK);
//            boolean isJsonP =  callback != null && callback.length() > 0;
//
//            MBYViewModel m =  getViewModel(errorCode + "," +errorMsg);
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//            String json =  mapper.writeValueAsString(m);
//
//            if (isJsonP) {
//                json =  new StringBuilder(JSON_P_CALLBACK).append("(").append(json).append(")").toString();
//            }
//
//            webApi.error("URI:" + request.getRequestURI());
//            webApi.error("Referer:" + request.getHeader("Referer"));
//            webApi.error("User-Agent:" + request.getHeader("User-Agent"));
//            webApi.error("输入:" + mapper.writeValueAsString(request.getParameterMap()));
//            webApi.error("输出" + json +"\n\n");
            outputStream = resp.getOutputStream();
//            if(outputStream!=null) {
//                outputStream.write(json.getBytes(DEFAULT_CHARSET));
//                outputStream.flush();
//            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return new ModelAndView(); // ruturn Empty ModelAndView表示到此结束了。

    }


}
