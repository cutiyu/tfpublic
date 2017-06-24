// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Properties;

public class UnifiedConfiger
{
    public static String driverName;
    public static String user;
    public static String password;
    public static String url;
    public static String path;
    public static String dbname;
    
    static {
        final Properties prop = new Properties();
        try {
            System.out.println("\u52a0\u8f7d\u914d\u7f6e\u6587\u4ef6...");
            final String classLocation = URLUtil.getPath(UnifiedConfiger.class);
            System.out.println("\u914d\u7f6e\u6587\u4ef6\u8def\u5f84:" + classLocation + "\\cfg.properties");
            final InputStream in = new FileInputStream(new File(classLocation, "cfg.properties"));
            prop.load(in);
            UnifiedConfiger.driverName = prop.getProperty("driverName");
            System.out.println("\u9a71\u52a8\u7a0b\u5e8f:" + UnifiedConfiger.driverName);
            UnifiedConfiger.user = prop.getProperty("user");
            System.out.println("\u7528\u6237\u540d:" + UnifiedConfiger.user);
            UnifiedConfiger.password = prop.getProperty("password");
            System.out.println("\u5bc6\u7801(\u5df2\u52a0\u5bc6):" + UnifiedConfiger.password.hashCode());
            UnifiedConfiger.url = prop.getProperty("url");
            System.out.println("\u8fde\u63a5\u5b57\u7b26\u4e32:" + UnifiedConfiger.url);
            String tem = UnifiedConfiger.url;
            tem = tem.substring(tem.lastIndexOf("/") + 1);
            tem = (UnifiedConfiger.dbname = tem.substring(0, tem.indexOf("?")));
            UnifiedConfiger.path = prop.getProperty("path");
            System.out.println("\u751f\u6210\u8def\u5f84:" + UnifiedConfiger.path);
            in.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(final String[] args) {
        System.out.println(UnifiedConfiger.dbname);
    }
}
