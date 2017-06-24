// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater;

import pres.tf.generater.itf.PartAssembled;
import pres.tf.generater.impls.bo.AssembleBo;
import pres.tf.generater.impls.dao.AssembleDao;
import java.io.IOException;
import java.sql.SQLException;

public class BatchCodeGenerater
{
    public static void main(final String[] args) {
        try {
            System.out.println("\u6b22\u8fce\u4f7f\u7528\u751f\u6210\u4ee3\u7801\u7ed3\u6784\u751f\u6210\u5411\u5bfc...");
            final GroundParamer pip = new GroundParamer();
            generate(pip);
            Runtime.getRuntime().exec("cmd /c start explorer " + UnifiedConfiger.path.replaceAll("\\/", "\\\\"));
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            showWait();
        }
        catch (SQLException e2) {
            e2.printStackTrace();
            showWait();
        }
        catch (IOException e3) {
            showWait();
            e3.printStackTrace();
        }
        catch (Exception e4) {
            e4.printStackTrace();
            showWait();
        }
    }

    private static void generate(final GroundParamer pip) throws ClassNotFoundException, SQLException, IOException {

        String[] tables = { "yc_acl_user"};

        PartAssembled pab = null;
        String[] array;
        for (int length = (array = tables).length, i = 0; i < length; ++i) {
            final String tbname = array[i];
            pip.setTableName(tbname);
            //pip.setModuleName(UnifiedConfiger.dbname);
            pip.setModuleName(".ossdb");
            pip.setModulePrefix("com.linkcook.ossdb");
            pab = new AssembleDao();
            pab.assembling(pip);
            pab = new AssembleBo();
            pab.assembling(pip);
        }
    }

    private static void showWait() {
        try {
            Thread.sleep(60000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
