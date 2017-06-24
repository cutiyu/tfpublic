// 
// Decompiled by Procyon v0.5.30
// 

package pres.tf.generater.itf;

import java.sql.SQLException;
import java.io.IOException;
import pres.tf.generater.GroundParamer;

public interface PartAssembled
{
    boolean assembling(final GroundParamer p0) throws IOException, SQLException;
}
