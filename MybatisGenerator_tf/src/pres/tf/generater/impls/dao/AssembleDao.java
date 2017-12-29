// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.impls.dao;

import java.util.HashMap;
import java.io.IOException;
import pres.tf.generater.itf.CodeFileBulider;
import java.sql.ResultSet;
import java.util.Map;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import pres.tf.generater.GroundParamer;
import java.sql.SQLException;
import java.sql.DriverManager;
import pres.tf.generater.UnifiedConfiger;
import java.sql.Connection;
import pres.tf.generater.itf.PartAssembled;

public class AssembleDao implements PartAssembled
{
    private Connection conn;
    
    public void init() throws ClassNotFoundException, SQLException {
        Class.forName(UnifiedConfiger.driverName);
        this.conn = DriverManager.getConnection(UnifiedConfiger.url, UnifiedConfiger.user, UnifiedConfiger.password);
    }
    
    public AssembleDao() throws ClassNotFoundException, SQLException {
        this.conn = null;
        this.init();
    }
    
    @Override
    public boolean assembling(final GroundParamer gp) throws IOException, SQLException {
        final String prefix = "show full fields from ";
        List<String> columns = null;
        List<String> types = null;
        List<String> comments = null;
        PreparedStatement pstate = null;
        final String table = gp.getTableName();
        final Map<String, String> tableComments = this.getTableComment();
        if (table != null) {
            columns = new ArrayList<String>();
            types = new ArrayList<String>();
            comments = new ArrayList<String>();
            pstate = this.conn.prepareStatement(String.valueOf(prefix) + table);
            final ResultSet results = pstate.executeQuery();
            while (results.next()) {
                columns.add(results.getString("FIELD"));
                types.add(results.getString("TYPE"));
                comments.add(results.getString("COMMENT"));
            }
            final String beaName = this.processTable(table);
            gp.setBeanName(beaName);
            gp.setTableComment(tableComments.get(table));
            gp.setColumns(columns);
            gp.setTypes(types);
            gp.setComments(comments);
            CodeFileBulider cfb = new BeanEntityBuilder();
            cfb.build(gp);
            cfb = new MapperItfBuilder();
            cfb.build(gp);
            //cfb = new MapperXMLBuilder();
            cfb = new MapperXMLBuilderNew();
            cfb.build(gp);
            cfb = new ServiceItfBuilder();
            cfb.build(gp);
            cfb = new MapperDaoBuilder();
            cfb.build(gp);
        }
        this.conn.close();
        return false;
    }
    
    private Map<String, String> getTableComment() throws SQLException {
        final Map<String, String> maps = new HashMap<String, String>();
        final PreparedStatement pstate = this.conn.prepareStatement("show table status");
        final ResultSet results = pstate.executeQuery();
        while (results.next()) {
            final String tableName = results.getString("NAME");
            final String comment = results.getString("COMMENT");
            maps.put(tableName, comment);
        }
        return maps;
    }
    
    private String processTable(final String table) {
        final StringBuffer sb = new StringBuffer(table.length());
        final String tableNew = table.toLowerCase();
        final String[] tables = tableNew.split("_");
        String temp = null;
        for (int i = 0; i < tables.length; ++i) {
            temp = tables[i].trim();
            sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
        }
        return sb.toString();
    }
}
