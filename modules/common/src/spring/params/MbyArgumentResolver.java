package spring.params;


import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;



/**
 * Created by Administrator on 2016/4/14.
 */
public class MbyArgumentResolver extends RequestParamMethodArgumentResolver {



    public MbyArgumentResolver() {
        super(true);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //仅作用于添加了注解ListAttribute的参数
        return methodParameter.getParameterAnnotation(MbyParam.class) != null;
    }


    /**
     * @param name             方法的变量名
     * @param methodParameter
     * @param nativeWebRequest
     * @return
     * @throws Exception
     */
    @Override
    protected Object resolveName(String name, MethodParameter methodParameter, NativeWebRequest nativeWebRequest) throws Exception {

        try {
            Class expectedClass = methodParameter.getParameterType();




            //采用户value 下的name 而不是用变量名
            MbyParam m = (methodParameter.getParameterAnnotation(MbyParam.class));
            Object value = super.resolveName(m.value(), methodParameter, nativeWebRequest);

            if (expectedClass == String[].class) {
                if (value == null) {
                    value = super.resolveName(name + "[]", methodParameter, nativeWebRequest);
                }
                if (value != null) {
                    if (value instanceof String[]) {
                        return value;
                    }
                    if (value instanceof String) {
                        return ((String) value).split(",");
                    }
                }
            }

            if (expectedClass == Integer.class
                    && (value instanceof String)
                    ) {
                String s = (String) value;
                if (StringUtils.isEmpty(s) && (methodParameter.getParameterAnnotation(MbyParam.class)) != null) {
                    MbyParam v = (methodParameter.getParameterAnnotation(MbyParam.class));
                    if (v.required() == false && StringUtils.isNotEmpty(v.defaultValue())) {
                        return Integer.valueOf(v.defaultValue());
                    } else {
//                        logger.error("-->" + name + "必须附值");

                    }
                }
            }

//去除注释将支持 下划线 和 小驼峰编码 作为参数
//        if(obj==null) {
//            String annoName = null;
//            MbyParam mbyParam = methodParameter.getParameterAnnotation(MbyParam.class);
//            if (mbyParam != null) {
//                annoName = methodParameter.getParameterAnnotation(MbyParam.class).value();
//                if (hasUpperCase(annoName)) {
//                    String requestName = NamingUtils.camelToUnderline(annoName);
//                    obj = super.resolveName(requestName, methodParameter, nativeWebRequest);
//                }
//            }
//        }

//validate params is empty or nulls.
            if (value == null) {
                MbyParam mbyParam = methodParameter.getParameterAnnotation(MbyParam.class);
                String obj  = mbyParam.defaultValue();
                if(obj!=null && !"\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n".equals(obj)){
                    if(expectedClass == Boolean.class){
                        return Boolean.valueOf(obj);
                    }
                    if(expectedClass == Integer.class)
                    {
                        return Integer.valueOf(obj);
                    }
                    if(expectedClass == String.class){
                        return String.valueOf(obj);
                    }
                }
//                assertFalse(ERR_MISS_PARAM + mbyParam.value(), mbyParam.required());

            }
            return value;
        } catch (Exception ex) {
//            if(ex instanceof AssertException){
//                return ex;
//            }
//            ex.printStackTrace();
            throw ex;
        }
    }



}
