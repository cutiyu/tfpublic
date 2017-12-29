// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.impls.bo;

import java.sql.SQLException;
import java.io.IOException;
import pres.tf.generater.itf.CodeFileBulider;
import pres.tf.generater.GroundParamer;
import pres.tf.generater.itf.PartAssembled;

public class AssembleBo implements PartAssembled
{
    @Override
    public boolean assembling(final GroundParamer gp) throws IOException, SQLException {
        CodeFileBulider cfb = new DubboServiceBulider();
        cfb = new ServiceClassBulider();
        cfb.build(gp);
        cfb = new ControllerClassBulider();
        cfb.build(gp);
        return false;
    }
}
