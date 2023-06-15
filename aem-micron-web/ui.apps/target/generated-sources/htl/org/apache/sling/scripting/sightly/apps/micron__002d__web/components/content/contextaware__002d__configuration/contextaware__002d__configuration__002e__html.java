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
package org.apache.sling.scripting.sightly.apps.micron__002d__web.components.content.contextaware__002d__configuration;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class contextaware__002d__configuration__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_camodel = null;
_global_camodel = renderContext.call("use", com.micron.web.core.models.ContextAwareConfig.class.getName(), obj());
out.write("<div <p>CA configuration:</p>\r\n <p>");
{
    String var_0 = ("Site Country:  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_camodel, "siteCountry"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</p>\r\n <p>");
{
    String var_1 = ("Site Locale:  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_camodel, "siteLocale"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</p>\r\n <p>");
{
    String var_2 = ("Site Admin:  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_camodel, "siteAdmin"), "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</p>\r\n <p>");
{
    String var_3 = ("Site Section:  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_camodel, "siteSection"), "text")));
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</p>\r\n\r\n</div>\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

