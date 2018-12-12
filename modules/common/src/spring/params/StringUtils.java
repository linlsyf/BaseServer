package spring.params;

public class StringUtils {
    public static boolean isEmpty(String s) {
        boolean isEmpty=false;
        if (s==null||s.trim().equals("")){
            isEmpty=true;
        }
        return  isEmpty;
    }

    public static boolean isNotEmpty(String s) {
        boolean isEmpty=true;
        if (s==null||s.trim().equals("")){
            isEmpty=false;
        }
        return  isEmpty;
    }
}
