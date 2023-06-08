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
package org.apache.sling.scripting.sightly.apps.micron__002d__web.components.content.product__002d__description;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class product__002d__description__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_pdpdesc = null;
_global_pdpdesc = renderContext.call("use", com.micron.web.core.models.ProductionDescriptionModel.class.getName(), obj());
out.write("\r\n\r\n<div class=\"cmp-helloworld\">\r\n    <h2 class=\"cmp-helloworld__title\">");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_pdpdesc, "productDetailCfModel"), "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</h2>\r\n    <div class=\"cmp-helloworld__item\">\r\n        <p class=\"cmp-helloworld__item-label\">");
{
    Object var_1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_pdpdesc, "productDetailCfModel"), "description"), "text");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</p>\r\n\r\n    </div>\r\n\r\n\r\n    <div class=\"cmp-helloworld__item\">\r\n\t\t");
{
    Object var_resourcecontent2 = renderContext.call("includeResource", null, obj().with("path", renderContext.getObjectModel().resolveProperty(_global_pdpdesc, "xfPath")).with("selectors", "content").with("wcmmode", "disabled"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent2));
}
out.write("\r\n    </div>\r\n</div>\r\n\r\n\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

