import java.util.Map;

public class GetSignUtils {
    /** 支付宝支付业务：入参app_id */
    public static final String APPID = "2016091100483029";

//	/** 支付宝账户登录授权业务：入参pid值 */
//	public static final String PID = "";
//	/** 支付宝账户登录授权业务：入参target_id值 */
//	public static final String TARGET_ID = "";

    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /** 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1 */
    public static final String RSA2_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCzFPs2Mxc5mN880BIjx7cfd+OnoxFr6KRPv8Yo4DsyyeUNpvMQGRLwfDGq2OI9Y8ZYcUMrZ6/qlZiNrqUr3k9dsOXIeM865oqD2IU9MzeJCDfz7jfVyDSG+YnIzUEdp30RpGIYSwrehAvwHBORZhn1U3bIGkifevVphDosGo3+D8v1I10WdkC+4PB7m9++movMhllBSoM3mPGCVcyp1ZSX7Dr1bRg0t1SpBPyAcdGzuSyVsJxK9rXPPg4xBkH5eDFPXzXNQOW4nT6s+Xyd2lLxOsv++2NbF952UXOcyVDoBC9/9xXWUhzs/Rr2HuwPKoI+sXtsxw/KO/00dZFBBQNAgMBAAECggEBAIeAwtB6bo4g5QvB2fGfPQR7usrmlwTSi+8lNyXYdpJBLyL2aaHHGP1pxycriW14AzbQv9V14HvK7ZQcJeXPujJ7Lssuk3eJHBAt6zhQoUHVN9j4Ec2qOfZt2cdXwkV8jZuiixGnJqaHnkLZRkXsO3ve8O2AuiF4Hljbz99M+FY9bbCGQ9rAki4tfpeFdwCrOdpAgRdpxt9HM+9RCVGn7UzQLe1NzKGnn+0EXyF4s1fSeexPMsOzM8Vg59RETlPp85uD4bTwrQuEfLmZ57f5I3J5Tdd+m2ob80CsN0hZeylJMCM9Ddr/BHpIB/hxBFI3GrBtuJG+M6hQuLa/0UzTbzECgYEA7wl+CAa6AbYouAPxse4Ez5LkrIAoHO7F4dL33yQ6YGHMSZWiAq0IwD5/sFEQEn33N8qvLrkRjsgmiGHWes5DBXBx80nR/iZH0WAANJSL/78MlpyAXSHCbOAr3/bc/tMBsxdLJMqJwVGcXrbHMhZw94GZ4d6hwOCYIyBGQjIoVe8CgYEA0J8pXs9r+I0LVBqCFWGBzEQO6stUmpmgF81ZWA4mKoqt+7w0Iez/uLyyGfccCuavMGHRxBYM6aZA4iRxqGvzGAm1EYKudctAllzIIDqge26BHevkCpCvVLYHBYtNFXcs8mo7PG9s5mMvLgUSYkS2cXV5Uu8++C9wKC+3OM6GUcMCgYEAx4HJshNDLmiGJcgM82/wjftRZvR0Bmn3uRqnDZQkMQuPQR9loAwh0KqZUmTmIDkInIVLn5iRofVFy/C03bzHzYNjaCaF4TS8HnGc2kXdb3Bapl4q+RBTQSH9HKnjG8Crm3lmm2d8gGCIPbkaGqEGWl3OPOnfYadS84ZdfaR1a/sCgYAW4Z4T/AQHmtCnRNEHr04hLUXFks+QtVDNy4QFGGgvOk6i0Z2WKvxRMsEGAAhfWbXVRKVRMGnyJn3vT7f3lP9wn3/wj7i6yrQmyb5ZapS3dQNMWNcGIaBZVi2m+gRWWl/fpq8gjcgP7Mj77yp5BLhN8WiBJCRv7CQNBE7AOEabKQKBgBsFpPyBE++eW5LNCgRtdr7feyxT8bsYNlEnZa1R3ow6adHeM/6Ft98ZNoxsf/7uauKB882+4pVmVeRDu1NlgxNzWAo2WQuktP9T4himD61Z5SKCzg2HhDd6E/ydmp9s0TMqJ4FwaNibGXvP40NobDiuEKJPQkWb/eyS6e2S8awG";
    public static final String RSA_PRIVATE = "";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    public static String get(){
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;
        return orderInfo;
    }
}
