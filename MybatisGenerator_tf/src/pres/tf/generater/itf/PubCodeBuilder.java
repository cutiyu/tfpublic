// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.itf;

import java.io.IOException;
import java.io.BufferedWriter;

public abstract class PubCodeBuilder
{
    protected final String type_char = "char";
    protected final String type_date = "date";
    protected final String type_timestamp = "timestamp";
    protected final String type_int = "int";
    protected final String type_bigint = "bigint";
    protected final String type_text = "text";
    protected final String type_bit = "bit";
    protected final String type_decimal = "decimal";
    protected final String type_blob = "blob";
    protected final String encodeing = "utf-8";
    
    protected String processField(final String field) {
        final StringBuffer sb = new StringBuffer(field.length());
        final String[] fields = field.split("_");
        String temp = null;
        sb.append(fields[0]);
        for (int i = 1; i < fields.length; ++i) {
            temp = fields[i].trim();
            sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
        }
        return sb.toString();
    }
    
    protected String processType(final String type) {
        if (type.indexOf("char") > -1) {
            return "String";
        }
        if (type.indexOf("bigint") > -1) {
            return "Long";
        }
        if (type.indexOf("int") > -1) {
            return "Integer";
        }
        if (type.indexOf("date") > -1) {
            return "java.util.Date";
        }
        if (type.indexOf("text") > -1) {
            return "String";
        }
        if (type.indexOf("timestamp") > -1) {
            return "java.util.Date";
        }
        if (type.indexOf("bit") > -1) {
            return "Boolean";
        }
        if (type.indexOf("decimal") > -1) {
            return "java.math.BigDecimal";
        }
        if (type.indexOf("blob") > -1) {
            return "byte[]";
        }
        return null;
    }
    
    protected BufferedWriter buildClassComment(final BufferedWriter bw, final String text) throws IOException {
        bw.newLine();
        bw.newLine();
        bw.write("/**");
        bw.newLine();
        bw.write(" * ");
        bw.newLine();
        bw.write(" * " + text);
        bw.newLine();
        bw.write(" * ");
        bw.newLine();
        bw.write(" **/");
        return bw;
    }
    
    protected BufferedWriter buildMethodComment(final BufferedWriter bw, final String text) throws IOException {
        bw.newLine();
        bw.write("\t/**");
        bw.newLine();
        bw.write("\t * ");
        bw.newLine();
        bw.write("\t * " + text);
        bw.newLine();
        bw.write("\t * ");
        bw.newLine();
        bw.write("\t **/");
        return bw;
    }
}
