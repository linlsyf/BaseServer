package provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import provider.service.ProviderService;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        //加载xml配置文件启动
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String str = providerService.SayHello("test");
        System.out.println(str);
    }
}
