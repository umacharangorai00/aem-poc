/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.micron__002d__web.components.content.richtext__002d__multifield;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class richtext__002d__multifield__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_ritchtextmodel = null;
Object _global_hastype = null;
_global_ritchtextmodel = renderContext.call("use", com.micron.web.core.models.RichTextMultiFieldModel.class.getName(), obj());
out.write("\r\n\r\n");
_global_hastype = renderContext.getObjectModel().resolveProperty(_global_ritchtextmodel, "title");
if (renderContext.getObjectModel().toBoolean(_global_hastype)) {
    out.write("\r\n\r\n    ");
    {
        Object var_testvariable0 = renderContext.getObjectModel().resolveProperty(_global_ritchtextmodel, "title");
        if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
            out.write("<pre>");
            {
                String var_1 = ("Title:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_ritchtextmodel, "title"), "text")));
                out.write(renderContext.getObjectModel().toString(var_1));
            }
            out.write("</pre>");
        }
    }
    out.write("\r\n    ");
    {
        Object var_testvariable2 = renderContext.getObjectModel().resolveProperty(_global_ritchtextmodel, "description");
        if (renderContext.getObjectModel().toBoolean(var_testvariable2)) {
            out.write("<pre>");
            {
                String var_3 = ("Description: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_ritchtextmodel, "description"), "text")));
                out.write(renderContext.getObjectModel().toString(var_3));
            }
            out.write("</pre>");
        }
    }
    out.write("\r\n");
}
out.write("\r\n");
{
    boolean var_testvariable4 = (!renderContext.getObjectModel().toBoolean(_global_hastype));
    if (var_testvariable4) {
        out.write("<pre>Ritch Text Component Component</pre>");
    }
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

