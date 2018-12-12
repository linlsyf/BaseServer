package spring.interceptors;


import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/14.
 */
public class PermissionInterceptor implements HandlerInterceptor {

//    ViewObjectService viewObjectService;
//
//    @Autowired
//    public void setViewObjectService(ViewObjectService viewObjectService) {
//        this.viewObjectService = viewObjectService;
//    }

    // before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod) handler;
//            if(h.getMethod().getAnnotation(AccessTokenRequired.class)!=null){
//
//            }
//            if(h.getMethod().getAnnotation(UserRequired.class)!=null){
//                TokenModel tokenModel = getTokenModel(request);
//                assertNotNull(ERR_ACCESS_TOKEN_INVALIDATION, tokenModel);
//                assertNotNull(ERR_ACCESS_TOKEN_INVALIDATION, tokenModel.getUser());
//
//            }
//            if(h.getMethod().getAnnotation(CompanyRequired.class)!=null){
//
//            }
        }
        return true;
    }

    // after the handler is executed
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

        long startTime = (Long) request.getAttribute("startTime");

    }
//
//    private TokenModel getTokenModel(HttpServletRequest request) throws Exception {
//        return (TokenModel) request.getAttribute(TokenModel.class.getName());
//    }
}