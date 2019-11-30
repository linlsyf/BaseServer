package spring.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {

//    private static Logger logger = LoggerFactory.getLogger(SystemInterceptor.class);
//    OperationLogDao logOperationDao;
//    LoginLogDao loginLogDao;
//    ComponentSystem componentSystem;
//    ViewObjectService viewObjectService;
    ObjectMapper mapper = new ObjectMapper();

    Collection<HandlerInterceptor> handlerInterceptors;
    List<String> signInPaths = Arrays.asList("/api/v2/auth/sign_in");
    public Collection<HandlerInterceptor> getHandlerInterceptors() {
        return handlerInterceptors;
    }

    public void setHandlerInterceptors(Collection<HandlerInterceptor> handlerInterceptors) {
        this.handlerInterceptors = handlerInterceptors;
    }

//    @Autowired
//    public void setViewObjectService(ViewObjectService service){
//        this.viewObjectService =service;
//    }
//    @Autowired
//    public void setComponentSystem(ComponentSystem componentSystem){
//        this.componentSystem = componentSystem;
////        this.logOperationDao =componentSystem.getService(OperationLogDao.class);
////        this. loginLogDao = componentSystem.getService(LoginLogDao.class);
//    }

    public void setSignInPaths(List<String> signInPaths){
        this.signInPaths = signInPaths;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
//        logger.debug("-->" + request.getRequestURI() +  " " +mapper.writeValueAsString(request.getParameterMap()));
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
//
//        if (handler instanceof HandlerMethod) {
//
////            OperationLog optLog = new OperationLog();
////            optLog.setOperatorTime(new Timestamp(startTime));
////            optLog.setIp(request.getRemoteHost());
////            optLog.setMac("");
////            optLog.setServerName(request.getServerName());
////            optLog.setPort(request.getServerPort() + "");
//
//            HandlerMethod method = (HandlerMethod) handler;
////            MBYControllerLog controllerLog = method.getMethodAnnotation(MBYControllerLog.class);
////            if (controllerLog != null) {
////                optLog.setModuleId(controllerLog.moduleId());
////                optLog.setContent(controllerLog.content());
////                optLog.setRemark(request.getServletPath());
////                optLog.setModuleName(controllerLog.moduleName());
////                optLog.setAgentId("");
////                optLog.setOperatorType(controllerLog.operatorType());
////
////                String accessToken = request.getParameter(ViewModelConst.ACCESS_TOKEN);
////
////                if(StringUtils.isNotEmpty(accessToken)) {
////                    TokenModel token = viewObjectService.getToken(accessToken);
////                    if(token!=null){
////                        optLog.setCorpId(viewObjectService.getTokenData(token, ViewModelConst.CURRENT_COMPANY_ID));
////                        optLog.setCorpName(viewObjectService.getTokenData(token, ViewModelConst.CURRENT_COMPANY_NAME));
////                        optLog.setOperatorId(viewObjectService.getTokenData(token, ViewModelConst.CURRENT_USER_ID));
////                        optLog.setOperatorName(viewObjectService.getTokenData(token, ViewModelConst.CURRENT_USER_NAME));
////                    }
////                }
////            }
//
//
////           if(UserContext.getCurrentUser()==null){
////                String accessToken = request.getParameter("accessToken");
////                if(StringUtils.isNoneEmpty(accessToken)){
////                    TokenModel tm = viewObjectService.getToken(accessToken);
////                    if (tm != null) {
////                        UserContext.setCurrentUser(tm.getUser());
////                    }
////                }
////            }
////            request.setAttribute(OperationLog.class.getName(), optLog );
//
//           //设置tokenModel
////            String accessToken = getAccessToken(request);
////            if(StringUtils.isNotEmpty(accessToken)) {
////                TokenModel token = viewObjectService.getToken(accessToken);
////                if(token!=null){
////                    request.setAttribute(TokenModel.class.getName(), token);
////                }
////            }
//
//           if(handlerInterceptors!=null && handlerInterceptors.size()>0){
//                for(HandlerInterceptor h : handlerInterceptors){
//                    h.preHandle(request, response, handler);
//                }
//           }//
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
//
//        if (handler instanceof HandlerMethod && !request.getServletPath().contains("/sign_out") ) {
//
//
//            HandlerMethod method = (HandlerMethod) handler;
//            MBYControllerLog controllerLog = method.getMethodAnnotation(MBYControllerLog.class);
//            if (controllerLog != null && signInPaths!=null && signInPaths.size()>0 && signInPaths.contains(request.getRequestURI())) {
//                if(  UserContext.getCurrentUser()!=null){
//                        UserVO userVO = UserContext.getCurrentUser();
//
//                        List<DepartmentVO> depts = userVO.getDepartments();
//                        StringBuilder deptsId = new StringBuilder();
//                        StringBuilder deptsName = new StringBuilder();
//                        int i = 0;
//                        for (DepartmentVO dept :
//                                depts) {
//                            if (i != 0){
//                                deptsId.append(",");
//                                deptsName.append(",");
//                            }
//                            deptsId.append(dept.getId());
//                            deptsName.append(dept.getName());
//                            i++;
//                        }
//                        String deptId = deptsId.toString();
//                        String deptName = deptsName.toString();
//
//
//                        String companyId = userVO.getCompanyId();
//                        String companyName = userVO.getCompanyName();
//                        String loginName = userVO.getName();
//
//
//                        Timestamp loginTime = new Timestamp(System.currentTimeMillis());
//                        Timestamp logoutTime = null;
//                        String sessionId = "";
//                        String loginId = request.getParameter("signInId");
//
//                        String ip = request.getRemoteHost();
//                        String mac = "";
//                        String serverName = request.getServerName();
//                        String port = request.getServerPort() + "";
//                        String remark = "";
//                        String signInId = request.getParameter("signInId");
//
//
//                            //save login logging
//                            if (loginId != null && loginId.length() > 0 &&
//                                    signInId != null && signInId.length() > 0
//                                    ) {
//                                String content = loginId + controllerLog.content();
//                                loginLogDao.logLoginLog(loginTime,
//                                        logoutTime,
//                                        sessionId,
//                                        signInId,
//                                        loginName,
//                                        ip,
//                                        mac,
//                                        serverName,
//                                        port,
//                                        content,
//                                        remark,
//                                        companyId,
//                                        companyName,
//                                        deptId,
//                                        deptName);
//                            }
//
//                } //#getViewModel if
//                else{
//
//                    //save operation log.
//                    OperationLog operationLog = (OperationLog) request.getAttribute(OperationLog.class.getName());
//                    if(operationLog!=null && StringUtils.isNotEmpty(operationLog.getModuleId())){
//                        if(operationLog.isLog()) {
//                            Long usedTime = System.currentTimeMillis() - startTime;
//                            operationLog.setUsedTime(usedTime);
//                            logOperationDao.saveOperationLog(operationLog);
//                        }
//                    }
//                }
//            }//#if controllerLog

//        }//#if

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");

    }

//    private String getAccessToken(HttpServletRequest request) {
//        String accessToken = request.getParameter(ACCESS_TOKEN);
//        if (com.mw.utils.StringUtils.isEmpty(accessToken)) {
//            String ticket = request.getParameter(TICKET);
//            String mac = request.getParameter(MAC);
//            if (com.mw.utils.StringUtils.isNotEmpty(ticket) && com.mw.utils.StringUtils.isNotEmpty(mac)) {
//                return viewObjectService.getAccessTokenByTicket(ticket, mac);
//            }
//        }
//        return accessToken;
//    }
}
