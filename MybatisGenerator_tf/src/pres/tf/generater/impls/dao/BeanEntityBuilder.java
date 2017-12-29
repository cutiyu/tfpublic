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

class BeanEntityBuilder extends PubCodeBuilder implements CodeFileBulider
{
    @Override
    public void build(final GroundParamer gp) throws IOException {
        final File folder = new File(gp.getBeanPath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        final File beanFile = new File(gp.getBeanPath(), String.valueOf(gp.getBeanName()) + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile), "utf-8"));
        bw.write("package " + gp.getBeanPakage() + ";");
        bw.newLine();
        bw.write("import java.io.Serializable;");
        bw.newLine();
        bw = this.buildClassComment(bw, gp.getTableComment());
        bw.newLine();
        bw.write("@SuppressWarnings(\"serial\")");
        bw.newLine();
        bw.write("public class " + gp.getBeanName() + " implements Serializable {");
        bw.newLine();
        bw.newLine();
        final int size = gp.getColumns().size();
        for (int i = 0; i < size; ++i) {
            bw.write("\t/**" + gp.getComments().get(i) + "**/");
            bw.newLine();
            bw.write("\t private " + this.processType(gp.getTypes().get(i)) + " " + this.processField(gp.getColumns().get(i)) + ";");
            bw.newLine();
            bw.newLine();
        }
        bw.newLine();
        String tempField = null;
        String _tempField = null;
        String tempType = null;
        for (int j = 0; j < size; ++j) {
            tempType = this.processType(gp.getTypes().get(j));
            _tempField = this.processField(gp.getColumns().get(j));
            tempField = String.valueOf(_tempField.substring(0, 1).toUpperCase()) + _tempField.substring(1);
            bw.newLine();
            bw.write("\tpublic void set" + tempField + "(" + tempType + " " + _tempField + "){");
            bw.newLine();
            bw.write("\t\tthis." + _tempField + " = " + _tempField + ";");
            bw.newLine();
            bw.write("\t}");
            bw.newLine();
            bw.newLine();
            bw.write("\tpublic " + tempType + " get" + tempField + "(){");
            bw.newLine();
            bw.write("\t\treturn this." + _tempField + ";");
            bw.newLine();
            bw.write("\t}");
            bw.newLine();
        }
        bw.newLine();
        bw.write("}");
        bw.newLine();
        bw.flush();
        bw.close();
        gp.setPreStepName(String.valueOf(gp.getBeanPakage()) + "." + gp.getBeanName());
    }
}
