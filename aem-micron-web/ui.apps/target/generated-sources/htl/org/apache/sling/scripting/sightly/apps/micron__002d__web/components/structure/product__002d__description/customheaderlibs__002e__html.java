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
package org.apache.sling.scripting.sightly.apps.micron__002d__web.components.structure.product__002d__description;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class customheaderlibs__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_clientlib = null;
out.write("\r\n");
_global_clientlib = renderContext.call("use", "core/wcm/components/commons/v1/templates/clientlib.html", obj());
out.write("\r\n    ");
{
    Object var_templatevar0 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "css");
    {
        String var_templateoptions1_field$_categories = "micron-web.base";
        {
            java.util.Map var_templateoptions1 = obj().with("categories", var_templateoptions1_field$_categories);
            callUnit(out, renderContext, var_templatevar0, var_templateoptions1);
        }
    }
}
out.write("\r\n\r\n");
{
    Object var_resourcecontent2 = renderContext.call("includeResource", "contexthub", obj().with("resourceType", "granite/contexthub/components/contexthub"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent2));
}
out.write("\r\n\r\n");
{
    Object var_includedresult3 = renderContext.call("include", "favicons.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult3));
}
out.write("\r\n<header class=\"header header-mega\">\r\n    <div data-sticky-container=\"\" class=\"sticky-container\" style=\"\">\r\n        <div data-sticky=\"\" data-sticky-on=\"small\" data-options=\"marginTop:0;\" class=\"sticky is-anchored is-at-top\" data-resize=\"dygl59-sticky\" data-mutate=\"dygl59-sticky\" data-b=\"i4hkgn-b\" data-events=\"resize\" style=\"max-width: 1579.17px; margin-top: 0px; bottom: auto; top: 0px;\">\r\n            <div class=\"dark-theme top-bar\" style=\"background-color:#0090da\">\r\n                <div class=\"dark-theme top-bar\" style=\"background-color:#0090da\">\r\n                    <div class=\"float-left\">\r\n                        <div class=\"header-cta\">\r\n                            <div class=\"text parbase\">\r\n\r\n                                </br></br>\r\n                            </div>\r\n                        </div>\r\n                        <div class=\"float-right\"></div>\r\n                    </div>\r\n                </div>\r\n                <nav class=\"top-bar\">\r\n\r\n\r\n                </nav>\r\n            </div>\r\n        </div>\r\n</header>\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

