package jpush;

//import cn.jiguang.common.resp.APIConnectionException;
//import cn.jiguang.common.resp.APIRequestException;
//import cn.jpush.api.JPushClient;
//import cn.jpush.api.push.PushResult;
//import cn.jpush.api.push.model.Message;
//import cn.jpush.api.push.model.Options;
//import cn.jpush.api.push.model.Platform;
//import cn.jpush.api.push.model.PushPayload;
//import cn.jpush.api.push.model.audience.Audience;
//import cn.jpush.api.push.model.notification.Notification;

import java.util.Collection;
import java.util.Map;

public class JpushManger {

    //极光推送>>Android
    //Map<String, String> parm是我自己传过来的参数,同学们可以自定义参数
    public static void jpushAndroid(Map<String, String> parm,boolean isAll,Collection<String> aliases) {
        // 设置好账号的app_key和masterSecret
        String appKey = "2c453bc83de32f68189a7aba";
        String masterSecret = "ff95247ee592327e69aa2713";
        //创建JPushClient(极光推送的实例)
//        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
//        //推送的关键,构造一个payload
//        PushPayload payload = PushPayload.newBuilder()
//                .setPlatform(Platform.android())//指定android平台的用户
////                .setAudience( isAll?Audience.all(): Audience.alias(aliases))//你项目中的所有用户
//
//                .setAudience(Audience.alias(aliases))//你项目中的所有用户
////                .setAudience(Audience.all())//你项目中的所有用户
//                .setNotification(Notification.android(parm.get("msg"), "这是title", parm))
//                //发送内容,这里不要盲目复制粘贴,这里是我从controller层中拿过来的参数)
//                .setOptions(Options.newBuilder().setApnsProduction(false).build())
//                //这里是指定开发环境,不用设置也没关系
//                .setMessage(Message.content(parm.get("msg")))//自定义信息
//                .build();
//
//        try {
//            PushResult pu = jpushClient.sendPush(payload);
//        } catch (APIConnectionException e) {
//            e.printStackTrace();
//        } catch (APIRequestException e) {
//            e.printStackTrace();
//        }
    }
}
