package provider.service;

//provider 部署到另外一个tomcat
public class ProviderServiceImpl implements ProviderService {

    public String SayHello(String word) {
        return word;
    }

}
