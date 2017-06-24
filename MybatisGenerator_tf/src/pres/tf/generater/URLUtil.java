// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URL;
import java.io.File;

public class URLUtil
{
    static String cfgfd;
    
    static {
        URLUtil.cfgfd = "config";
    }
    
    public static File getClassFile(final Class clazz) {
        URL path = clazz.getResource(String.valueOf(clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1)) + ".class");
        if (path == null) {
            final String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/" + name + ".class");
        }
        return new File(path.getFile());
    }
    
    public static String getClassFilePath(final Class clazz) {
        try {
            return URLDecoder.decode(getClassFile(clazz).getAbsolutePath(), "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static File getClassPathFile(final Class clazz) {
        File file = getClassFile(clazz);
        for (int i = 0, count = clazz.getName().split("[.]").length; i < count; ++i) {
            file = file.getParentFile();
        }
        if (file.getName().toUpperCase().endsWith(".JAR!")) {
            file = file.getParentFile();
        }
        return file;
    }
    
    public static String getClassPath(final Class clazz) {
        try {
            return URLDecoder.decode(getClassPathFile(clazz).getAbsolutePath(), "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static void main(final String[] args) {
        System.out.println(getClassFilePath(URLUtil.class));
        System.out.println(getClassPath(URLUtil.class));
        System.out.println(getPath(URLUtil.class));
        try {
            Thread.sleep(50000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static String getPath(final Class clazz) {
        final String path = getClassPath(clazz);
        String find = "";
        if (path.contains("file:")) {
            find = "file:\\\\([\\\\a-zA-Z0-9:]{1,})";
        }
        else {
            find = "bin";
        }
        return replace(path, find);
    }
    
    private static String replace(final String source, final String regex) {
        return source.replaceFirst(regex, URLUtil.cfgfd);
    }
}
