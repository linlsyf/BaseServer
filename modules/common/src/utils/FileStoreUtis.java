package utils;

public class FileStoreUtis {
    public  static  String foldName ="upload";
    public  static  String filePath ="";
    public  static String baseOutputFilePath = filePath;
//    public static final String baseOutputFilePath = "c:"+filePath;
    public   String websitFilePath = ServiceUtils.host+filePath;
    public static FileStoreUtis utis;

      public static FileStoreUtis getInstance(){

          if (null==utis){
              utis=new FileStoreUtis();
              String path =  Thread.currentThread().getContextClassLoader().getResource("").toString();
              path=path.replace('/', '\\'); // 将/换成\
              path=path.replace("file:", ""); //去掉file:
              path=path.replace("classes\\", ""); //去掉class\
              path=path.replace("WEB-INF\\", ""); //去掉class\
              path=path.substring(1); //去掉第一个\,如 \D:\JavaWeb...



              utis. filePath =path+foldName+"\\";
              utis.baseOutputFilePath = filePath;
//    public static final String baseOutputFilePath = "c:"+filePath;
              utis.websitFilePath = ServiceUtils.host+filePath;
          }

          return  utis;

      }

}
