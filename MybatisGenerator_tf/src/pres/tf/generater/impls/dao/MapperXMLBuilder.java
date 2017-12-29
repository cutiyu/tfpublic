// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.impls.dao;

import java.util.List;
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
 * mapper.xml
 */
class MapperXMLBuilder extends PubCodeBuilder implements CodeFileBulider
{
    @Override
    public void build(final GroundParamer gp) throws IOException {
        final File folder = new File(gp.getMapperXMLPath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        final File mapperXmlFile = new File(gp.getMapperXMLPath(), String.valueOf(gp.getMapperXmlName()) + ".xml");
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperXmlFile), "utf-8"));
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        bw.newLine();
        bw.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" ");
        bw.newLine();
        bw.write("    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        bw.newLine();
        bw.write("<mapper namespace=\"" + gp.getPreStepName() + "\">");
        bw.newLine();
        bw.newLine();
        bw.write("\t<!--\u5b9e\u4f53\u6620\u5c04-->");
        bw.newLine();
        bw.write("\t<resultMap id=\"" + this.processResultMapId(gp.getBeanName()) + "\" type=\"" + gp.getBeanPakage() + "." + gp.getBeanName() + "\">");
        bw.newLine();
        bw.write("\t\t<!--" + gp.getComments().get(0) + "-->");
        bw.newLine();
        bw.write("\t\t<id property=\"" + this.processField(gp.getColumns().get(0)) + "\" column=\"" + gp.getColumns().get(0) + "\" />");
        bw.newLine();
        for (int size = gp.getComments().size(), i = 1; i < size; ++i) {
            bw.write("\t\t<!--" + gp.getComments().get(i) + "-->");
            bw.newLine();
            bw.write("\t\t<result property=\"" + this.processField(gp.getColumns().get(i)) + "\" column=\"" + gp.getColumns().get(i) + "\" />");
            bw.newLine();
        }
        bw.write("\t</resultMap>");
        bw.newLine();
        bw.newLine();
        bw.newLine();
        this.buildSQL(bw, gp);
        bw.write("</mapper>");
        bw.flush();
        bw.close();
    }
    
    private String processResultMapId(final String beanName) {
        return String.valueOf(beanName) + "ResMap";
    }
    
    private void buildSQL(final BufferedWriter bw, final GroundParamer gp) throws IOException {
        final List<String> columns = gp.getColumns();
        final List<String> types = gp.getTypes();
        final int size = columns.size();
        bw.write("\t<!-- \u901a\u7528\u67e5\u8be2\u7ed3\u679c\u5217-->");
        bw.newLine();
        bw.write("\t<sql id=\"Base_Column_List\">");
        bw.newLine();
        bw.write("\t\t id,");
        for (int i = 1; i < size; ++i) {
            bw.write("\t" + columns.get(i));
            if (i != size - 1) {
                bw.write(",");
            }
        }
        bw.newLine();
        bw.write("\t</sql>");
        bw.newLine();
        bw.newLine();
        bw.write("\t<!-- \u67e5\u8be2\uff08\u6839\u636e\u4e3b\u952eID\u67e5\u8be2\uff09 -->");
        bw.newLine();
        bw.write("\t<select id=\"selectByPrimaryKey\" resultType=\"" + gp.getBeanPakage() + "." + gp.getBeanName() + "\" parameterType=\"java.lang." + this.processType(types.get(0)) + "\">");
        bw.newLine();
        bw.write("\t\t SELECT");
        bw.newLine();
        bw.write("\t\t <include refid=\"Base_Column_List\" />");
        bw.newLine();
        bw.write("\t\t FROM " + gp.getTableName());
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + this.processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</select>");
        bw.newLine();
        bw.newLine();
        bw.write("\t<!--\u5220\u9664\uff1a\u6839\u636e\u4e3b\u952eID\u5220\u9664-->");
        bw.newLine();
        bw.write("\t<delete id=\"deleteByPrimaryKey\" parameterType=\"java.lang." + this.processType(types.get(0)) + "\">");
        bw.newLine();
        bw.write("\t\t DELETE FROM " + gp.getTableName());
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + this.processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</delete>");
        bw.newLine();
        bw.newLine();
        bw.write("\t<!-- \u6dfb\u52a0 -->");
        bw.newLine();
        bw.write("\t<insert id=\"insert\" parameterType=\"" + this.processRPType(gp) + "\">");
        bw.newLine();
        bw.write("\t\t INSERT INTO " + gp.getTableName());
        bw.newLine();
        bw.write(" \t\t(");
        for (int i = 0; i < size; ++i) {
            bw.write(columns.get(i));
            if (i != size - 1) {
                bw.write(",");
            }
        }
        bw.write(") ");
        bw.newLine();
        bw.write("\t\t VALUES ");
        bw.newLine();
        bw.write(" \t\t(");
        for (int i = 0; i < size; ++i) {
            bw.write("#{" + this.processField(columns.get(i)) + "}");
            if (i != size - 1) {
                bw.write(",");
            }
        }
        bw.write(") ");
        bw.newLine();
        bw.write("\t</insert>");
        bw.newLine();
        bw.newLine();
        bw.write("\t<!-- \u6dfb\u52a0 \uff08\u5339\u914d\u6709\u503c\u7684\u5b57\u6bb5\uff09-->");
        bw.newLine();
        bw.write("\t<insert id=\"insertSelective\" parameterType=\"" + this.processRPType(gp) + "\">");
        bw.newLine();
        bw.write("\t\t INSERT INTO " + gp.getTableName());
        bw.newLine();
        bw.write("\t\t <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >");
        bw.newLine();
        String tempField = null;
        for (int j = 0; j < size; ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t<if test=\"" + tempField + " != null\">");
            bw.newLine();
            bw.write("\t\t\t\t " + columns.get(j) + ",");
            bw.newLine();
            bw.write("\t\t\t</if>");
            bw.newLine();
        }
        bw.newLine();
        bw.write("\t\t </trim>");
        bw.newLine();
        bw.write("\t\t <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >");
        bw.newLine();
        tempField = null;
        for (int j = 0; j < size; ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t<if test=\"" + tempField + "!=null\">");
            bw.newLine();
            bw.write("\t\t\t\t #{" + tempField + "},");
            bw.newLine();
            bw.write("\t\t\t</if>");
            bw.newLine();
        }
        bw.write("\t\t </trim>");
        bw.newLine();
        bw.write("\t</insert>");
        bw.newLine();
        bw.newLine();
        bw.write("\t<!-- \u4fee \u6539-->");
        bw.newLine();
        bw.write("\t<update id=\"updateByPrimaryKeySelective\" parameterType=\"" + this.processRPType(gp) + "\">");
        bw.newLine();
        bw.write("\t\t UPDATE " + gp.getTableName());
        bw.newLine();
        bw.write(" \t\t <set> ");
        bw.newLine();
        tempField = null;
        for (int j = 1; j < size; ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t<if test=\"" + tempField + " != null\">");
            bw.newLine();
            bw.write("\t\t\t\t " + columns.get(j) + " = #{" + tempField + "},");
            bw.newLine();
            bw.write("\t\t\t</if>");
            bw.newLine();
        }
        bw.newLine();
        bw.write(" \t\t </set>");
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + this.processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</update>");
        bw.newLine();
        bw.newLine();
        bw.write("\t<!-- \u4fee \u6539-->");
        bw.newLine();
        bw.write("\t<update id=\"updateByPrimaryKey\" parameterType=\"" + this.processRPType(gp) + "\">");
        bw.newLine();
        bw.write("\t\t UPDATE " + gp.getTableName());
        bw.newLine();
        bw.write("\t\t SET ");
        bw.newLine();
        tempField = null;
        for (int j = 1; j < size; ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t " + columns.get(j) + " = #{" + tempField + "}");
            if (j != size - 1) {
                bw.write(",");
            }
            bw.newLine();
        }
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + this.processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</update>");
        bw.newLine();
        bw.newLine();
    }
    
    private String processRPType(final GroundParamer gp) {
        return String.valueOf(gp.getBeanPakage()) + "." + gp.getBeanName();
    }
}
