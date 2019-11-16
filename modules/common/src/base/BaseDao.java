package base;

public class BaseDao {
    public  Object  instance;
    public static String  LIST_TYPE="list.sql";



    public  String getDict(){
        String courseFile =instance.getClass().getResource("").getPath() ;

         return  courseFile;
    }
    public  String getSqlFilePath(String type){
        String courseFile =getDict();
        courseFile=courseFile+"sql"+"/"+type;
        return  courseFile;
    }
//    public  String getSqlFilePath(String path,String type){
//        String courseFile =getDict();
//        courseFile=courseFile+"sql/"+ path+"/"+type;
//        return  courseFile;
//    }
}
