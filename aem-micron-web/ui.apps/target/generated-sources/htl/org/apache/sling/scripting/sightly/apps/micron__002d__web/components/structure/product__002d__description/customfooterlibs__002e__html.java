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

public final class customfooterlibs__002e__html extends RenderUnit {

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
    Object var_templatevar0 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "js");
    {
        boolean var_templateoptions1_field$_async = true;
        {
            String var_templateoptions1_field$_categories = "micron-web.base";
            {
                java.util.Map var_templateoptions1 = obj().with("async", var_templateoptions1_field$_async).with("categories", var_templateoptions1_field$_categories);
                callUnit(out, renderContext, var_templatevar0, var_templateoptions1);
            }
        }
    }
}
out.write("\r\n\r\n\t");
{
    Object var_templatevar2 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "all");
    {
        boolean var_templateoptions3_field$_async = true;
        {
            String var_templateoptions3_field$_categories = "micron-web.base";
            {
                java.util.Map var_templateoptions3 = obj().with("async", var_templateoptions3_field$_async).with("categories", var_templateoptions3_field$_categories);
                callUnit(out, renderContext, var_templatevar2, var_templateoptions3);
            }
        }
    }
}
out.write("\r\n\r\n\r\n\r\n\r\n<footer class=\"site-footer footermega\">\r\n    <div id=\"email-signup\" data-emailsignup=\"/content/crucial/en-us/home/account/email-signup\" class=\"dark-theme email-signup\" style=\"background-color:#0090da\"></div>\r\n\r\n    <div class=\"row lower-links-row footer-margin\">\r\n        <div class=\"small-12 medium-4 large-3 xlarge-4 columns left-column\">\r\n            <div class=\"row\">\r\n                <div class=\"columns small-7 medium-12 headline\"></div>\r\n               <div class=\"columns small-5 medium-12 align-self-bottom\"></div>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"small-12 columns\">\r\n            <div class=\"parsys\"></div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"row copyright-row footer-margin\">\r\n        <div class=\"small-12 medium-8 columns align-self-middle\"></div>\r\n        <div class=\"small-12 medium-4 columns social-icons-column\"></div>\r\n    </div>\r\n</footer>\r\n\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

