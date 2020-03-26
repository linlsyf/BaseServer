package utils.template;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.ObjectWrapper;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FtlManager {

//    private Configuration configuration;
//    private FtlLoader templateLoader;
//
//    protected FtlManager() {
//        this.init((FtlLoader)null);
//    }
//
//    protected FtlManager(FtlLoader templateLoader) {
//        this.init(templateLoader);
//    }
//
//    protected void init(FtlLoader loader) {
//        Configuration cfg = new Configuration();
//        this.templateLoader = null == loader ? new FtlLoader() : loader;
//        cfg.setTemplateLoader(new TemplateLoader() {
//            public Object findTemplateSource(String s) throws IOException {
//                try {
//                    return FtlManager.this.templateLoader.doFindSource(s);
//                } catch (Exception var3) {
//                    throw new IOException(xt.getFirstCause(var3));
//                }
//            }
//
//            public long getLastModified(Object o) {
//                return FtlManager.this.templateLoader.getLastModified(o);
//            }
//
//            public Reader getReader(Object o, String s) throws IOException {
//                try {
//                    return FtlManager.this.templateLoader.getReader(o, s);
//                } catch (Exception var4) {
//                    throw new IOException(xt.getFirstCause(var4));
//                }
//            }
//
//            public void closeTemplateSource(Object o) throws IOException {
//                try {
//                    FtlManager.this.templateLoader.close(o);
//                } catch (Exception var3) {
//                    throw new IOException(xt.getFirstCause(var3));
//                }
//            }
//        });
//        cfg.setLocalizedLookup(false);
//        cfg.setObjectWrapper(this.getObjectWrapper());
//        cfg.setDateTimeFormat(this.getDateTimeFormat());
//        cfg.setDefaultEncoding(this.getFtlEncoding());
//        cfg.setNumberFormat("0.##########");
//
//        try {
//            cfg.setSharedVariable("_T", new FtlTools(cfg, (DefaultObjectWrapper)this.getObjectWrapper()));
//        } catch (Exception var4) {
//            var4.printStackTrace();
//        }
//
//        this.configuration = cfg;
//    }
//
//    public String render(String ftl, Map ctx, String encoding) throws Exception {
//        StringWriter sw = new StringWriter();
//        if (null == encoding) {
//            this.configuration.getTemplate(ftl).process(ctx, sw);
//        } else {
//            this.configuration.getTemplate(ftl, encoding).process(ctx, sw);
//        }
//
//        return sw.toString();
//    }
//
//    public String render(FtlSource source, Map ctx) throws Exception {
//        StringWriter sw = new StringWriter();
//
//        try {
//            this.templateLoader.setSource(source);
//            if (null == source.getEncoding()) {
//                this.configuration.getTemplate(source.getName()).process(ctx, sw);
//            } else {
//                this.configuration.getTemplate(source.getName(), source.getEncoding()).process(ctx, sw);
//            }
//        } finally {
//            this.templateLoader.removeSource();
//        }
//
//        return sw.toString();
//    }
//
//    public String render(URL url, Map ctx, String encoding) throws Exception {
//        String var5;
//        try {
//            this.templateLoader.setSource(url);
//            StringWriter sw = new StringWriter();
//            if (null == encoding) {
//                this.configuration.getTemplate(url.toString()).process(ctx, sw);
//            } else {
//                this.configuration.getTemplate(url.toString(), encoding).process(ctx, sw);
//            }
//
//            var5 = sw.toString();
//        } finally {
//            this.templateLoader.removeSource();
//        }
//
//        return var5;
//    }
//
//    public void clearTemplateCache() {
//        this.configuration.clearTemplateCache();
//    }
//
//    protected String getDateTimeFormat() {
//        return "yyyy-MM-dd hh:mm:ss";
//    }
//
//    protected String getFtlEncoding() {
//        return "UTF-8";
//    }
//
//    protected ObjectWrapper getObjectWrapper() {
//        return new FtlObjectWrapper();
//    }
//
//    public Configuration getConfiguration() {
//        return this.configuration;
//    }
//
//    public FtlLoader getTemplateLoader() {
//        return this.templateLoader;
//    }
//
//    public boolean isCacheDisabled() {
//        return this.configuration.isTemplateCacheDisabled();
//    }
//
//    public void setCacheDisabled(boolean flag) {
//        this.configuration.setDisableTemplateCache(flag);
//    }
//
//    public static void main(String[] args) throws Exception {
//        FtlManager m = FtlManagerFactory.getInst();
//        Map ctx = new HashMap();
//        System.out.println(m.render((URL)FtlManager.class.getResource("test.ftl"), ctx, (String)null));
//    }
}
