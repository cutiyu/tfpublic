// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater;

import java.util.List;

public class GroundParamer
{
    private String moduleName;
    private String tableName;
    private String beanName;
    private String modulePrefix;
    private String preStepName;
    List<String> columns;
    List<String> types;
    List<String> comments;
    String tableComment;

    public String getBeanPath() {
        return String.valueOf(UnifiedConfiger.path) + this.getBeanPakage().replaceAll("\\.", "/");
    }
/* service 层  实体包   com.linkcook     .ossdb    .service.entity */
    public String getBeanPakage() {
        return String.valueOf(this.modulePrefix) + "." + this.moduleName + ".service" + ".entity";
    }
    /* serviceImpl 层  实体包   com.linkcook     .ossdb    .serviceImpl   .mapper/.daoImpl */
    public String getMapperPakage() {
        return String.valueOf(this.modulePrefix) + "." + this.moduleName +  ".serviceImpl" + "." + "mapper";
    }

    public String getMapperPath() {
        return String.valueOf(UnifiedConfiger.path) + this.getMapperPakage().replaceAll("\\.", "/");
    }

    public String getIserviceName() {
        return this.beanName + "Dao";
    }
    /* service 层  实体包   com.linkcook     .ossdb    .service.dao */
    public String getIservicePackage() {
        return String.valueOf(this.modulePrefix) + "." + this.moduleName + ".service"+ ".dao";
    }

    public String getIServicePath() {
        return String.valueOf(UnifiedConfiger.path) + this.getIservicePackage().replaceAll("\\.", "/");
    }

    public String getMapperName() {
        return String.valueOf(this.beanName) + "Mapper";
    }

    public String getMapperDaoName() {
        return String.valueOf(this.beanName) + "DaoImpl";
    }

    public String getMapperDaoPakage() {
        return String.valueOf(this.modulePrefix) + "."+this.moduleName +  ".serviceImpl" + ".daoImpl";
    }

    public String getMapperDaoPath() {
        return String.valueOf(UnifiedConfiger.path) + this.getMapperDaoPakage().replaceAll("\\.", "/");
    }

    public String getMapperXmlName() {
        return String.valueOf(this.beanName) + "Mapper";
    }

    public String getMapperXMLPkg() {
        return String.valueOf(this.modulePrefix) + "." + this.moduleName + "." + "xml";
    }

    public String getMapperXMLPath() {
        return String.valueOf(UnifiedConfiger.path) + this.getMapperXMLPkg().replaceAll("\\.", "/");
    }

    public String getServiceName() {
        return String.valueOf(this.beanName) + "ServiceLogic";
    }

    public String getServicePakage() {
        return String.valueOf(this.modulePrefix) + "." + this.moduleName + "." + "service";
    }

    public String getServicePath() {
        return String.valueOf(UnifiedConfiger.path) + this.getServicePakage().replaceAll("\\.", "/");
    }

    public String getDubboServiceName() {
        return String.valueOf(this.beanName) + "Service";
    }

    public String getDubboServicePakage() {
        return String.valueOf(this.modulePrefix) + "." + this.moduleName + "." + "service";
    }

    public String getDubboServicePath() {
        return String.valueOf(UnifiedConfiger.path) + this.getServicePakage().replaceAll("\\.", "/");
    }

    public String getControllerName() {
        return String.valueOf(this.beanName) + "Controller";
    }

    public String getControllerPakage() {
        return String.valueOf(this.modulePrefix) + "." + this.moduleName + "." + "controller";
    }

    public String getControllerPath() {
        return String.valueOf(UnifiedConfiger.path) + this.getControllerPakage().replaceAll("\\.", "/");
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(final String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModulePrefix() {
        return this.modulePrefix;
    }

    public void setModulePrefix(final String modulePrefix) {
        this.modulePrefix = modulePrefix;
    }

    public List<String> getColumns() {
        return this.columns;
    }

    public void setColumns(final List<String> columns) {
        this.columns = columns;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(final List<String> types) {
        this.types = types;
    }

    public List<String> getComments() {
        return this.comments;
    }

    public void setComments(final List<String> comments) {
        this.comments = comments;
    }

    public String getTableComment() {
        return this.tableComment;
    }

    public void setTableComment(final String tableComment) {
        this.tableComment = tableComment;
    }

    public String getBeanName() {
        return this.beanName;
    }

    public void setBeanName(final String beanName) {
        this.beanName = beanName;
    }

    public String getPreStepName() {
        return this.preStepName;
    }

    public void setPreStepName(final String preStepName) {
        this.preStepName = preStepName;
    }
}
