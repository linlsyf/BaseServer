
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import provider.service.ProviderService;
import sun.reflect.misc.ReflectUtil;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;


public class RunJetty {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8090);

        WebAppContext context = new WebAppContext();
        context.setDescriptor("web/WEB-INF/web.xml");
        context.setResourceBase("web");
//        context.setContextPath("/easy");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);
//    String templatePath = RunJetty.class.getClassLoader().getResource("/").getPath().replace("classes", "templates");

        server.start();
        server.join();


//        ClassPathXmlApplicationContext contextClass=new ClassPathXmlApplicationContext("consumer.xml");
//
//        context.setDescriptor("web/WEB-INF/consumer.xml");
//
//        contextClass.start();
//        ProviderService providerService = (ProviderService) contextClass.getBean("providerService");
//        String str = providerService.SayHello("test");
//        System.out.println(str);

    }

}
