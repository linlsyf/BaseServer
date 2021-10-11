
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

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



//        String courseFile =instance.getClass().getResource("").getPath() ;



    }

}
