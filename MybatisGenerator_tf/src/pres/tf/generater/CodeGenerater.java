// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater;

import pres.tf.generater.itf.PartAssembled;
import java.util.Scanner;
import pres.tf.generater.impls.bo.AssembleBo;
import pres.tf.generater.impls.dao.AssembleDao;
import java.io.IOException;
import java.sql.SQLException;

public class CodeGenerater
{
    public static void main(final String[] args) {
        try {
            System.out.println("\u6b22\u8fce\u4f7f\u7528\u751f\u6210\u4ee3\u7801\u7ed3\u6784\u751f\u6210\u5411\u5bfc...");
            generate(new GroundParamer(), true);
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
    
    private static void generate(final GroundParamer pip, final boolean b) throws ClassNotFoundException, SQLException, IOException {
        getInput(pip, b);
        PartAssembled pab = new AssembleDao();
        pab.assembling(pip);
        pab = new AssembleBo();
        pab.assembling(pip);
        final Scanner sc = new Scanner(System.in);
        System.out.println("\u751f\u6210\u7ed3\u675f!,\u662f\u5426\u7ee7\u7eed\u751f\u6210\u8be5\u6a21\u5757\u4e0b\u7684\u5176\u4ed6\u8868?(\u8f93\u5165Y\u7ee7\u7eed,\u5426\u5219\u9000\u51fa\u672c\u6b21\u751f\u6210)");
        final String isCon = sc.next();
        if ("Y".equals(isCon.toUpperCase())) {
            generate(pip, false);
        }
        sc.close();
    }
    
    public static void getInput(final GroundParamer pip, final boolean isFirst) {
        final Scanner sc = new Scanner(System.in);
        System.out.print("\u8f93\u5165\u8868\u540d\uff1a");
        pip.setTableName(sc.next());
        if (isFirst) {
            System.out.print("(\u4f8b\u5982\u5305\u540d\u4e3acom.xxx.abc.model)\u5219\u8f93\u5165\u6a21\u5757\u540d(abc)\uff1a");//ossdb
            pip.setModuleName(sc.next());
            System.out.print("(\u4f8b\u5982\u5305\u540d\u4e3acom.xxx.abc.model)\u5219\u8f93\u5165\u6a21\u5757\u524d\u7f6e\u5305\u9650\u5b9a\u540d(com.xxx)\uff1a");//com.linkcook
            pip.setModulePrefix(sc.next());
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
