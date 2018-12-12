package alipay.config;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091100483029";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCzFPs2Mxc5mN880BIjx7cfd+OnoxFr6KRPv8Yo4DsyyeUNpvMQGRLwfDGq2OI9Y8ZYcUMrZ6/qlZiNrqUr3k9dsOXIeM865oqD2IU9MzeJCDfz7jfVyDSG+YnIzUEdp30RpGIYSwrehAvwHBORZhn1U3bIGkifevVphDosGo3+D8v1I10WdkC+4PB7m9++movMhllBSoM3mPGCVcyp1ZSX7Dr1bRg0t1SpBPyAcdGzuSyVsJxK9rXPPg4xBkH5eDFPXzXNQOW4nT6s+Xyd2lLxOsv++2NbF952UXOcyVDoBC9/9xXWUhzs/Rr2HuwPKoI+sXtsxw/KO/00dZFBBQNAgMBAAECggEBAIeAwtB6bo4g5QvB2fGfPQR7usrmlwTSi+8lNyXYdpJBLyL2aaHHGP1pxycriW14AzbQv9V14HvK7ZQcJeXPujJ7Lssuk3eJHBAt6zhQoUHVN9j4Ec2qOfZt2cdXwkV8jZuiixGnJqaHnkLZRkXsO3ve8O2AuiF4Hljbz99M+FY9bbCGQ9rAki4tfpeFdwCrOdpAgRdpxt9HM+9RCVGn7UzQLe1NzKGnn+0EXyF4s1fSeexPMsOzM8Vg59RETlPp85uD4bTwrQuEfLmZ57f5I3J5Tdd+m2ob80CsN0hZeylJMCM9Ddr/BHpIB/hxBFI3GrBtuJG+M6hQuLa/0UzTbzECgYEA7wl+CAa6AbYouAPxse4Ez5LkrIAoHO7F4dL33yQ6YGHMSZWiAq0IwD5/sFEQEn33N8qvLrkRjsgmiGHWes5DBXBx80nR/iZH0WAANJSL/78MlpyAXSHCbOAr3/bc/tMBsxdLJMqJwVGcXrbHMhZw94GZ4d6hwOCYIyBGQjIoVe8CgYEA0J8pXs9r+I0LVBqCFWGBzEQO6stUmpmgF81ZWA4mKoqt+7w0Iez/uLyyGfccCuavMGHRxBYM6aZA4iRxqGvzGAm1EYKudctAllzIIDqge26BHevkCpCvVLYHBYtNFXcs8mo7PG9s5mMvLgUSYkS2cXV5Uu8++C9wKC+3OM6GUcMCgYEAx4HJshNDLmiGJcgM82/wjftRZvR0Bmn3uRqnDZQkMQuPQR9loAwh0KqZUmTmIDkInIVLn5iRofVFy/C03bzHzYNjaCaF4TS8HnGc2kXdb3Bapl4q+RBTQSH9HKnjG8Crm3lmm2d8gGCIPbkaGqEGWl3OPOnfYadS84ZdfaR1a/sCgYAW4Z4T/AQHmtCnRNEHr04hLUXFks+QtVDNy4QFGGgvOk6i0Z2WKvxRMsEGAAhfWbXVRKVRMGnyJn3vT7f3lP9wn3/wj7i6yrQmyb5ZapS3dQNMWNcGIaBZVi2m+gRWWl/fpq8gjcgP7Mj77yp5BLhN8WiBJCRv7CQNBE7AOEabKQKBgBsFpPyBE++eW5LNCgRtdr7feyxT8bsYNlEnZa1R3ow6adHeM/6Ft98ZNoxsf/7uauKB882+4pVmVeRDu1NlgxNzWAo2WQuktP9T4himD61Z5SKCzg2HhDd6E/ydmp9s0TMqJ4FwaNibGXvP40NobDiuEKJPQkWb/eyS6e2S8awG";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2N67iiUNXZMzcJjqieRP4lDrnJQk/QG589DHyWIgNQLbDxryrdZHn3L6d5juX3Bm39eJpYr/2kDKR+p2+4GxqpBUjVNwCS6w8hDc2lEpWQNOsBEi/tA0TCwXoWZ0DNX58e8GPXeLJbID6QxJgtJXfZVtdQmkoeukGfBqegoosjotvs7kaBnUMy8AvyIbUO2aTpbERtKEI5J1ALHZHciVBpC9e0GzIXTO8t9949culRXK5TJ9jnnYFRYjT789vVoshMrPw76ZHd77ttpDOMR4aWN/w8t94dYks0EsugVh8wD0Wj3r6BEwLJnfZ+zaYijQuU8Eo2acNSygTTpnFEWi4wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://192.168.1.145:8090/easy/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://192.168.1.145:8090/easy/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
//    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

