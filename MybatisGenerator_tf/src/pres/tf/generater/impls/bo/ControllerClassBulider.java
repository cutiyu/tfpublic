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

class ControllerClassBulider extends PubCodeBuilder implements CodeFileBulider
{
    @Override
    public void build(final GroundParamer gp) throws IOException {
        final File folder = new File(gp.getControllerPath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        final String ctrolName = gp.getControllerName();
        final File servFile = new File(gp.getControllerPath(), String.valueOf(ctrolName) + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servFile), "utf-8"));
        bw.write("package " + gp.getControllerPakage() + ";");
        bw.newLine();
        bw.write("import java.util.Map;");
        bw.newLine();
        bw.write("import java.util.HashMap;");
        bw.newLine();
        bw.write("import java.util.List;");
        bw.newLine();
        bw.write("import org.slf4j.Logger;");
        bw.newLine();
        bw.write("import org.slf4j.LoggerFactory;");
        bw.newLine();
        bw.write("import org.springframework.beans.factory.annotation.Autowired;");
        bw.newLine();
        bw.write("import org.springframework.stereotype.Controller;");
        bw.newLine();
        bw.write("import " + gp.getBeanPakage() + "." + gp.getBeanName() + ";");
        bw.newLine();
        bw.write("import " + gp.getServicePakage() + "." + gp.getServiceName() + ";");
        bw.newLine();
        bw = this.buildClassComment(bw, String.valueOf(gp.getTableComment()) + " \u8bbf\u95ee\u63a7\u5236\u5668\u7c7b");
        bw.newLine();
        bw.write("@Controller(\"" + ctrolName.substring(0, 1).toLowerCase() + ctrolName.substring(1) + "\")");
        bw.newLine();
        bw.write("public class " + ctrolName + " {");
        bw.newLine();
        bw.newLine();
        bw.write("\t //\u7edf\u4e00\u8bb0\u5f55\u65e5\u5fd7\u7c7b");
        bw.newLine();
        bw.write("\t private Logger Log=LoggerFactory.getLogger(\"" + gp.getModuleName() + "\");");
        bw.newLine();
        bw.write("\t @Autowired //\u5f53\u524d\u4e1a\u52a1\u64cd\u4f5c\u63a5\u53e3bo");
        bw.newLine();
        bw.write("\t private " + gp.getServiceName() + " service;");
        bw.newLine();
        bw.newLine();
        bw.write("}");
        bw.newLine();
        bw.flush();
        bw.close();
        gp.setPreStepName(String.valueOf(gp.getControllerPakage()) + "." + ctrolName);
    }
}
