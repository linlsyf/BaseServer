package base;

public class BaseDao {
    public static Object  instance;
    public static String  LIST_TYPE="list.sql";



    public static String getDict(){
        String courseFile =instance.getClass().getResource("").getPath() ;

         return  courseFile;
    }
    public static String getSqlFilePath(String path,String type){
        String courseFile =getDict();
        courseFile=courseFile+"sql/"+ path+"/"+type;
        return  courseFile;
    }
}
