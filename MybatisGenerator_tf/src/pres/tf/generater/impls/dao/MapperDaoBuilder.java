// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.impls.dao;

import java.io.IOException;
import pres.tf.generater.UnifiedConfiger;
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
 * DaoImpl.java
 */
public class MapperDaoBuilder extends PubCodeBuilder implements CodeFileBulider
{
    @Override
    public void build(final GroundParamer gp) throws IOException {
        final File folder = new File(gp.getMapperDaoPath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        final File mapperFile = new File(gp.getMapperDaoPath(), String.valueOf(gp.getMapperDaoName()) + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
        bw.write("package " + gp.getMapperDaoPakage() + ";");
        bw.newLine();
        bw.newLine();
        bw.write("import " + gp.getPreStepName() + ";");
        bw.newLine();
        bw.write("import " + gp.getBeanPakage()+"."+gp.getBeanName() + ";");
        bw.newLine();
        bw.write("import com.linkcook.basedao.DataSourceType;");
        bw.newLine();
        bw.write("import com.linkcook.basedao.SessionFactory;");
        bw.newLine();
        bw.write("import org.apache.ibatis.annotations.Param;");
        bw.newLine();
        bw.write("import org.springframework.stereotype.Service;");
        bw.newLine();
        bw.write("import java.util.Map;");
        bw.newLine();
        bw.write("import java.util.List;");
        bw.newLine();
        bw.write("import "+gp.getMapperPakage()+"."+gp.getMapperName()+";");
        bw.newLine();

        bw = this.buildClassComment(bw, String.valueOf(gp.getMapperDaoName()) + "\u6570\u636e\u5e93\u64cd\u4f5c\u5b9e\u73b0\u7c7b");
        bw.newLine();
        bw.newLine();
        bw.write("@Service");
        bw.newLine();
        bw.write("public class " + gp.getMapperDaoName() + " implements " + gp.getIserviceName() + " {");
        bw.newLine();
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u67e5\u8be2\uff08\u6839\u636e\u4e3b\u952eID\u67e5\u8be2\uff09");
        bw.newLine();
        bw.write("\t @Override");
        bw.newLine();
        bw.write("\t public " + gp.getBeanName() + "  selectByPrimaryKey ( Long id ){");
        bw.newLine();
        bw.write("\t\t return SessionFactory.getSessionDAO(DataSourceType.dataSource_" + UnifiedConfiger.dbname + "," + gp.getMapperName() + ".class).selectByPrimaryKey(id);");
        bw.newLine();
        bw.write("\t }");
        bw.newLine();
        bw.write("\t @Override");
        bw.newLine();
        bw.write("\t public List<" + gp.getBeanName() + ">  selectByMap ( Map map ){");
        bw.newLine();
        bw.write("\t\t return SessionFactory.getSessionDAO(DataSourceType.dataSource_" + UnifiedConfiger.dbname + "," + gp.getMapperName() + ".class).selectByMap(map);");
        bw.newLine();
        bw.write("\t }");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u5220\u9664\uff08\u6839\u636e\u4e3b\u952eID\u5220\u9664\uff09");
        bw.newLine();
        bw.write("\t @Override");
        bw.newLine();
        bw.write("\t public int deleteByPrimaryKey ( Long id ){");
        bw.newLine();
        bw.write("\t\t return SessionFactory.getSessionDAO(DataSourceType.dataSource_" + UnifiedConfiger.dbname + "," + gp.getMapperName() + ".class).deleteByPrimaryKey(id);");
        bw.newLine();
        bw.write("\t }");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u6dfb\u52a0");
        bw.newLine();
        bw.write("\t @Override");
        bw.newLine();
        bw.write("\t public int insert( " + gp.getBeanName() + " record ){");
        bw.newLine();
        bw.write("\t\t return SessionFactory.getSessionDAO(DataSourceType.dataSource_" + UnifiedConfiger.dbname + "," + gp.getMapperName() + ".class).insert(record);");
        bw.newLine();
        bw.write("\t }");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u6dfb\u52a0 \uff08\u5339\u914d\u6709\u503c\u7684\u5b57\u6bb5\uff09");
        bw.newLine();
        bw.write("\t @Override");
        bw.newLine();
        bw.write("\t public int insertSelective( " + gp.getBeanName() + " record ){");
        bw.newLine();
        bw.write("\t\t return SessionFactory.getSessionDAO(DataSourceType.dataSource_" + UnifiedConfiger.dbname + "," + gp.getMapperName() + ".class).insertSelective(record);");
        bw.newLine();
        bw.write("\t }");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u4fee\u6539 \uff08\u5339\u914d\u6709\u503c\u7684\u5b57\u6bb5\uff09");
        bw.newLine();
        bw.write("\t @Override");
        bw.newLine();
        bw.write("\t public int updateByPrimaryKeySelective( " + gp.getBeanName() + " record ){");
        bw.newLine();
        bw.write("\t\t return SessionFactory.getSessionDAO(DataSourceType.dataSource_" + UnifiedConfiger.dbname + "," + gp.getMapperName() + ".class).updateByPrimaryKeySelective(record);");
        bw.newLine();
        bw.write("\t }");
        bw.newLine();
        bw = this.buildMethodComment(bw, "\u4fee\u6539\uff08\u6839\u636e\u4e3b\u952eID\u4fee\u6539\uff09");
        bw.newLine();
        bw.write("\t @Override");
        bw.newLine();
        bw.write("\t public int updateByPrimaryKey ( " + gp.getBeanName() + " record ){");
        bw.newLine();
        bw.write("\t\t return SessionFactory.getSessionDAO(DataSourceType.dataSource_" + UnifiedConfiger.dbname + "," + gp.getMapperName() + ".class).updateByPrimaryKey(record);");
        bw.newLine();
        bw.write("\t }");
        bw.newLine();
        bw.newLine();
        bw.write("}");
        bw.flush();
        bw.close();
    }
}
