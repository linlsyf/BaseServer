package utils.template;

import com.mw.utils.FileUtils;
import com.mw.utils.StringUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.DeepUnwrap;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.net.URL;
import java.util.Map;

public class TemplateUtils {
    private TemplateUtils() {
    }

//    /** @deprecated */
//    @Deprecated
//    public static String render(String content, Map ctx) {
//        return renderV((String)content, ctx, (String)null, (String)null);
//    }
//
//    public static String renderV(String content, Map ctx) {
//        return renderV((String)content, ctx, (String)null, (String)null);
//    }
//
//    public static String renderV(URL url, Map ctx) {
//        return renderV((URL)url, ctx, (String)null, (String)null);
//    }
//
//    /** @deprecated */
//    @Deprecated
//    public static String render(URL url, Map ctx, String templateRootPath, String encoding) {
//        return renderV(url, ctx, templateRootPath, encoding);
//    }
//
//    public static String renderV(URL url, Map ctx, String templateRootPath, String encoding) {
//        try {
//            String content = StringUtils.read(url.openStream(), encoding);
//            return renderV(content, ctx, templateRootPath, encoding);
//        } catch (RuntimeException var5) {
//            throw var5;
//        } catch (Exception var6) {
//            throw new TemplateException(var6);
//        }
//    }
//
//    /** @deprecated */
//    @Deprecated
//    public static String render(String content, Map ctx, String templateRootPath, String encoding) {
//        return renderV(content, ctx, templateRootPath, encoding);
//    }
//
//    public static String renderV(String content, Map ctx, String templateRootPath, String encoding) {
//        if (null == content) {
//            return null;
//        } else {
//            StringWriter sw = new StringWriter();
//            VelocityContext vCtx = new VelocityContext(ctx);
//            vCtx.put("u", xt.class);
//            VelocityEngine ve = new VelocityEngine();
//            ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.CommonsLogLogChute");
//            encoding = (String)xt.nvl(encoding, "UTF-8");
//            ve.setProperty("input.encoding", encoding);
//            ve.setProperty("output.encoding", encoding);
//            if (null != templateRootPath) {
//                ve.setProperty("resource.loader", "file");
//                ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
//                ve.setProperty("file.resource.loader.path", FileUtils.fixPath(templateRootPath));
//                ve.setProperty("file.resource.loader.cache", "false");
//                ve.setProperty("file.resource.loader.modificationCheckInterval", "0");
//            }
//
//            try {
//                ve.evaluate(vCtx, sw, "TemplateUtils.render", content);
//                return sw.toString();
//            } catch (Exception var8) {
//                throw new TemplateException(xt.getFirstCause(var8));
//            }
//        }
//    }
//
//    public static String render(URL url, Map ctx) {
//        return render(url, ctx, (String)null);
//    }
//
//    public static String render(URL url, Map ctx, String encoding) {
//        FtlManager fm = FtlManagerFactory.getInst();
//        boolean cs = fm.isCacheDisabled();
//
//        String var5;
//        try {
//            fm.setCacheDisabled(true);
//            var5 = fm.render(url, ctx, encoding);
//        } catch (RuntimeException var10) {
//            throw var10;
//        } catch (Exception var11) {
//            throw new TemplateException(var11);
//        } finally {
//            fm.setCacheDisabled(cs);
//        }
//
//        return var5;
//    }
//
//    public static String render(FtlSource source, Map ctx) {
//        FtlManager fm = FtlManagerFactory.getInst();
//        boolean cs = fm.isCacheDisabled();
//
//        String var4;
//        try {
//            fm.setCacheDisabled(true);
//            var4 = fm.render(source, ctx);
//        } catch (RuntimeException var9) {
//            throw var9;
//        } catch (Exception var10) {
//            throw new TemplateException(var10);
//        } finally {
//            fm.setCacheDisabled(cs);
//        }
//
//        return var4;
//    }
//
//    public static TemplateModel wrap(Object obj) throws TemplateModelException {
//        return obj instanceof TemplateModel ? (TemplateModel)obj : Environment.getCurrentEnvironment().getObjectWrapper().wrap(obj);
//    }
//
//    public static Object unwrap(Object obj) throws TemplateModelException {
//        return obj instanceof TemplateModel ? DeepUnwrap.unwrap((TemplateModel)obj) : obj;
//    }

    public static void main(String[] args) throws Exception {
    }
}
