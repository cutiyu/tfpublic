// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.impls.dao;

import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import pres.tf.generater.GroundParamer;
import pres.tf.generater.itf.CodeFileBulider;
import pres.tf.generater.itf.PubCodeBuilder;

/**
 * Dao.java
 */
class ServiceItfBuilder extends PubCodeBuilder implements CodeFileBulider
{
    @Override
    public void build(final GroundParamer gp) throws IOException {
        final File folder = new File(gp.getIServicePath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        final File mapperFile = new File(gp.getIServicePath(), String.valueOf(gp.getIserviceName()) + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
        bw.write("package " + gp.getIservicePackage() + ";");
        bw.newLine();
        bw.newLine();
        /*bw.write("import " + gp.getPreStepName() + ";");
        bw.newLine();*/
        bw.write("import " + gp.getBeanPakage()+"."+gp.getBeanName() + ";");
        bw.newLine();
        bw.write("import java.util.Map;");
        bw.newLine();
        bw.write("import java.util.List;");
        bw.newLine();
        bw = this.buildClassComment(bw, String.valueOf(gp.getIserviceName()) + "\u6570\u636e\u5e93\u64cd\u4f5c\u63a5\u53e3\u7c7b");
        bw.newLine();
        bw.newLine();
        bw.write("public interface " + gp.getIserviceName() + "{");
        bw.newLine();
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u67e5\u8be2\uff08\u6839\u636e\u4e3b\u952eID\u67e5\u8be2\uff09");
        bw.newLine();
        bw.write("\t" + gp.getBeanName() + "  selectByPrimaryKey (Long id );");
        bw.newLine();
        bw.write("\t List<" + gp.getBeanName() + ">  selectByMap (Map map );");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u5220\u9664\uff08\u6839\u636e\u4e3b\u952eID\u5220\u9664\uff09");
        bw.newLine();
        bw.write("\tint deleteByPrimaryKey (Long id );");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u6dfb\u52a0");
        bw.newLine();
        bw.write("\tint insert( " + gp.getBeanName() + " record );");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u6dfb\u52a0 \uff08\u5339\u914d\u6709\u503c\u7684\u5b57\u6bb5\uff09");
        bw.newLine();
        bw.write("\tint insertSelective( " + gp.getBeanName() + " record );");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u4fee\u6539 \uff08\u5339\u914d\u6709\u503c\u7684\u5b57\u6bb5\uff09");
        bw.newLine();
        bw.write("\tint updateByPrimaryKeySelective( " + gp.getBeanName() + " record );");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u4fee\u6539\uff08\u6839\u636e\u4e3b\u952eID\u4fee\u6539\uff09");
        bw.newLine();
        bw.write("\tint updateByPrimaryKey ( " + gp.getBeanName() + " record );");
        bw.newLine();
        bw.newLine();
        bw.write("}");
        bw.flush();
        bw.close();
        gp.setPreStepName(String.valueOf(gp.getIservicePackage()) + "." + gp.getIserviceName());
    }
}
