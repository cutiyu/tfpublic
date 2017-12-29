// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.impls.dao;

import pres.tf.generater.GroundParamer;
import pres.tf.generater.itf.CodeFileBulider;
import pres.tf.generater.itf.PubCodeBuilder;

import java.io.*;
import java.util.List;

/**
 * mapper.xml
 */
class MapperXMLBuilderNew extends PubCodeBuilder implements CodeFileBulider {
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
                          /* **************************** resultMap  开始 ******************************* */

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
        /* **************************** resultMap  结束 ******************************* */

        /* **************************** sql 增删改查  开始 ******************************* */
        this.buildSQL(bw, gp);
          /* **************************** sql 增删改查  结束 ******************************* */

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

         /*表名*/
        tableName(bw,gp);

        /**表字段**/
        baseColumnList(bw,size,columns);

        /*查询条件*/
        querCondition(bw,columns);

        /*根据主键ID查询*/
        selectByPrimaryKey(bw,gp,columns,types);
        /*根据Map查询*/
        selectByMap(bw,gp,columns);

        /*插入数据*/
        insert(bw,gp,columns);
        insertSelective(bw,gp,columns);

       /*更新*/
       updateByPrimaryKey(bw,gp,columns);
       updateByPrimaryKeySelective(bw,gp,columns);

       /*删除*/
       deleteByPrimaryKey(bw,gp,columns);
    }

    /**
     * 1：基础列表字段
     * @param bw
     * @param size
     * @param columns
     * @throws IOException
     */
    private void baseColumnList(final BufferedWriter bw,final int size,final List<String> columns) throws IOException{
        bw.write("\t<!-- \u901a\u7528\u67e5\u8be2\u7ed3\u679c\u5217-->");
        bw.newLine();
        /*基础列字段*/
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
    }

    /**
     * 2.表名
     * @param bw
     * @param gp
     * @throws IOException
     */
    private void tableName(final BufferedWriter bw,final GroundParamer gp ) throws IOException{
        bw.write("\t<sql id=\"table_name\">");
        bw.newLine();
        bw.write("\t\t" + gp.getTableName());
        bw.newLine();
        bw.write("\t</sql>");
        bw.newLine();
        bw.newLine();
    }

    /**
     * 3.根据主键ID查询
     * @param bw
     * @param gp
     * @param columns
     * @param types
     * @throws IOException
     */
    private void selectByPrimaryKey(final BufferedWriter bw,final GroundParamer gp,final List<String> columns,final List<String> types)throws IOException{
        bw.write("\t<!-- \u67e5\u8be2\uff08\u6839\u636e\u4e3b\u952eID\u67e5\u8be2\uff09 -->");
        bw.newLine();
        bw.write("\t<select id=\"selectByPrimaryKey\" resultMap=\"" + this.processResultMapId(gp.getBeanName()) + "\" parameterType=\"java.lang." + this.processType(types.get(0)) + "\">");
        bw.newLine();
        bw.write("\t\t SELECT");
        bw.newLine();
        bw.write("\t\t <include refid=\"Base_Column_List\" />");
        bw.newLine();
        bw.write("\t\t FROM <include refid=\"table_name\" />");
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + this.processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</select>");
        bw.newLine();
        bw.newLine();
    }

    /**
     * 4.根据Map查询
     * @param bw
     * @param gp
     * @param columns
     * @throws IOException
     */
    private void selectByMap(final BufferedWriter bw,final GroundParamer gp,final List<String> columns)throws IOException{
        bw.write("\t<!-- \u67e5\u8be2\uff08\u6839\u636eMap\u67e5\u8be2\uff09 -->");
        bw.newLine();
        bw.write("\t<select id=\"selectByMap\" resultMap=\"" + this.processResultMapId(gp.getBeanName()) + "\" parameterType=\"java.util.Map\">");
        bw.newLine();
        bw.write("\t\t SELECT");
        bw.newLine();
        bw.write("\t\t <include refid=\"Base_Column_List\" />");
        bw.newLine();
        bw.write("\t\t FROM <include refid=\"table_name\" />");
        bw.newLine();
        bw.write("\t\t <include refid=\"query_condition\" />");
        bw.newLine();
        bw.write("\t</select>");
        bw.newLine();
        bw.newLine();
    }

    /**
     * 5.插入数据
     * @param bw
     * @param gp
     * @param columns
     * @throws IOException
     */
    private void insert(final BufferedWriter bw,final GroundParamer gp,final List<String> columns)throws IOException{
        bw.write("\t<!-- \u6dfb\u52a0 -->");
        bw.newLine();
        bw.write("\t<insert id=\"insert\" parameterType=\"" + this.processRPType(gp) + "\" keyProperty=\""+this.processField(columns.get(0))+"\" useGeneratedKeys=\"true\">");
        bw.newLine();
        bw.write("\t\t INSERT INTO <include refid=\"table_name\" />");
        bw.newLine();
        bw.write(" \t\t(");
        for (int i = 0; i < columns.size(); ++i) {
            bw.write(columns.get(i));
            if (i != columns.size() - 1) {
                bw.write(",");
            }
        }
        bw.write(") ");
        bw.newLine();
        bw.write("\t\t VALUES ");
        bw.newLine();
        bw.write(" \t\t(");
        for (int i = 0; i < columns.size(); ++i) {
            bw.write("#{" + this.processField(columns.get(i)) + "}");
            if (i != columns.size() - 1) {
                bw.write(",");
            }
        }
        bw.write(") ");
        bw.newLine();
        bw.write("\t</insert>");
        bw.newLine();
        bw.newLine();


    }

    /**
     * 6.根据可选属性插入数据
     * @param bw
     * @param gp
     * @param columns
     * @throws IOException
     */
    private void insertSelective(final BufferedWriter bw,final GroundParamer gp,final List<String> columns)throws IOException{
        bw.write("\t<!-- \u6dfb\u52a0 \uff08\u5339\u914d\u6709\u503c\u7684\u5b57\u6bb5\uff09-->");
        bw.newLine();
        bw.write("\t<insert id=\"insertSelective\" parameterType=\"" + this.processRPType(gp) +  "\" keyProperty=\""+this.processField(columns.get(0))+"\" useGeneratedKeys=\"true\">");
        bw.newLine();
        bw.write("\t\t INSERT INTO <include refid=\"table_name\" />");
        bw.newLine();
        bw.write("\t\t <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >");
        bw.newLine();
        String tempField = null;
        for (int j = 0; j < columns.size(); ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t<if test=\"" + tempField + " != null\">"+columns.get(j)+",</if>");
            bw.newLine();
        }
        bw.newLine();
        bw.write("\t\t </trim>");
        bw.newLine();
        bw.write("\t\t <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >");
        bw.newLine();
        tempField = null;
        for (int j = 0; j < columns.size(); ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t<if test=\"" + tempField + "!=null\">"+" #{" + tempField + "},</if>");
            bw.newLine();
        }
        bw.write("\t\t </trim>");
        bw.newLine();
        bw.write("\t</insert>");
        bw.newLine();
        bw.newLine();
    }

    /**
     * 7.更新
     * @param bw
     * @param gp
     * @param columns
     * @throws IOException
     */
    private void updateByPrimaryKeySelective(final BufferedWriter bw,final GroundParamer gp,final List<String> columns)throws IOException{


        //更新
        bw.write("\t<!-- \u4fee \u6539-->");
        bw.newLine();
        bw.write("\t<update id=\"updateByPrimaryKeySelective\" parameterType=\"" + this.processRPType(gp) + "\">");
        bw.newLine();
        bw.write("\t\t UPDATE <include refid=\"table_name\" />");
        bw.newLine();
        bw.write(" \t\t <set> ");
        bw.newLine();
        String tempField = null;
        for (int j = 1; j < columns.size(); ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t<if test=\"" + tempField + " != null\">"+ columns.get(j) + " = #{" + tempField + "},</if>");
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

    }

    /**
     * 8.更新
     * @param bw
     * @param gp
     * @param columns
     * @throws IOException
     */
    private void updateByPrimaryKey(final BufferedWriter bw,final GroundParamer gp,final List<String> columns)throws IOException{
        bw.write("\t<!-- \u4fee \u6539-->");
        bw.newLine();
        bw.write("\t<update id=\"updateByPrimaryKey\" parameterType=\"" + this.processRPType(gp) + "\">");
        bw.newLine();
        bw.write("\t\t UPDATE <include refid=\"table_name\" />" );
        bw.newLine();
        bw.write("\t\t SET ");
        bw.newLine();
        String tempField = null;
        for (int j = 1; j < columns.size(); ++j) {
            tempField = this.processField(columns.get(j));
            bw.write("\t\t\t " + columns.get(j) + " = #{" + tempField + "}");
            if (j != columns.size() - 1) {
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

    /**
     * 9 根据主键删除
     * @param bw
     * @param gp
     * @param columns
     * @throws IOException
     */
    private void deleteByPrimaryKey(final BufferedWriter bw,final GroundParamer gp,final List<String> columns)throws IOException{
        bw.write("\t<!--\u5220\u9664\uff1a\u6839\u636e\u4e3b\u952eID\u5220\u9664-->");
        bw.newLine();
        bw.write("\t<delete id=\"deleteByPrimaryKey\" parameterType=\"java.lang." + this.processType(gp.getTypes().get(0)) + "\">");
        bw.newLine();
        bw.write("\t\t DELETE FROM <include refid=\"table_name\" />");
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + this.processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</delete>");
        bw.newLine();
        bw.newLine();
    }

    /**
     * 10 封装的查询条件
     * @param bw
     * @param columns
     * @throws IOException
     */
    private void querCondition(final BufferedWriter bw,final List<String> columns)throws IOException{
        bw.write("\t <sql id=\"query_condition\">");
        bw.newLine();
        bw.write("\t\t <where>");
        bw.newLine();
        for (String column : columns) {
            bw.write("\t\t\t <if test=\""+this.processField(column)+" !=null\">and "+column + " =#{" + this.processField(column) + "}</if>");
            bw.newLine();
        }
        bw.newLine();
        bw.write("\t\t </where>");
        bw.newLine();
        bw.write("\t </sql>");
        bw.newLine();
        bw.newLine();

    }




    private String processRPType(final GroundParamer gp) {
        return String.valueOf(gp.getBeanPakage()) + "." + gp.getBeanName();
    }
}
