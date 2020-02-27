package test;

public class NormTest {

    public static  final  void main(String[] arg){

        String word="c++";
        String test="";
        if (word.contains("+")){
            test=word.replace("c++","C%2B%2B");
        }

        System.out.println(test);
    }
}
