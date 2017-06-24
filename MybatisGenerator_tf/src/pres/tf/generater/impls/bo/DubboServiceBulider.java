// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.impls.bo;

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

public class DubboServiceBulider extends PubCodeBuilder implements CodeFileBulider
{
    @Override
    public void build(final GroundParamer gp) throws IOException {
        final File folder = new File(gp.getDubboServicePath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        final File servFile = new File(gp.getDubboServicePath(), String.valueOf(gp.getDubboServiceName()) + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servFile), "utf-8"));
        bw.write("package " + gp.getDubboServicePakage() + ";");
        bw.newLine();
        bw = this.buildClassComment(bw, String.valueOf(gp.getTableComment()) + " dubbo\u66b4\u9732\u670d\u52a1\u7c7b\u63a5\u53e3");
        bw.newLine();
        bw.write("public interface " + gp.getDubboServiceName() + "{");
        bw.newLine();
        bw.write("}");
        bw.flush();
        bw.close();
        gp.setPreStepName(String.valueOf(gp.getDubboServicePakage()) + "." + gp.getDubboServiceName());
    }
}
