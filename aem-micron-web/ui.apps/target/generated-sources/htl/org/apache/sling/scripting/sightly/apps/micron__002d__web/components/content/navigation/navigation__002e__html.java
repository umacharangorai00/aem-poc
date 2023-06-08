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
package org.apache.sling.scripting.sightly.apps.micron__002d__web.components.content.navigation;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class navigation__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_clientlib = bindings.get("clientlib");
Object _global_navigation = null;
Object _global_template = null;
Object _global_grouptemplate = null;
Object _global_hascontent = null;
{
    Object var_templatevar0 = renderContext.getObjectModel().resolveProperty(_dynamic_clientlib, "css");
    {
        String var_templateoptions1_field$_categories = "micron-web.nav-header";
        {
            java.util.Map var_templateoptions1 = obj().with("categories", var_templateoptions1_field$_categories);
            callUnit(out, renderContext, var_templatevar0, var_templateoptions1);
        }
    }
}
out.write("\r\n\r\n\r\n");
_global_navigation = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Navigation.class.getName(), obj());
_global_template = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_grouptemplate = renderContext.call("use", "group.html", obj());
_global_hascontent = (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_navigation, "items"), "size"), 0)));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    out.write("<nav");
    {
        Object var_attrvalue2 = renderContext.getObjectModel().resolveProperty(_global_navigation, "id");
        {
            Object var_attrcontent3 = renderContext.call("xss", var_attrvalue2, "attribute");
            {
                boolean var_shoulddisplayattr5 = (((null != var_attrcontent3) && (!"".equals(var_attrcontent3))) && ((!"".equals(var_attrvalue2)) && (!((Object)false).equals(var_attrvalue2))));
                if (var_shoulddisplayattr5) {
                    out.write(" id");
                    {
                        boolean var_istrueattr4 = (var_attrvalue2.equals(true));
                        if (!var_istrueattr4) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent3));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write(" class=\"cmp-navigation\" itemscope itemtype=\"http://schema.org/SiteNavigationElement\"");
    {
        Object var_attrvalue6 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_navigation, "data"), "json");
        {
            Object var_attrcontent7 = renderContext.call("xss", var_attrvalue6, "attribute");
            {
                boolean var_shoulddisplayattr9 = (((null != var_attrcontent7) && (!"".equals(var_attrcontent7))) && ((!"".equals(var_attrvalue6)) && (!((Object)false).equals(var_attrvalue6))));
                if (var_shoulddisplayattr9) {
                    out.write(" data-cmp-data-layer");
                    {
                        boolean var_istrueattr8 = (var_attrvalue6.equals(true));
                        if (!var_istrueattr8) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent7));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    {
        Object var_attrvalue10 = renderContext.getObjectModel().resolveProperty(_global_navigation, "accessibilityLabel");
        {
            Object var_attrcontent11 = renderContext.call("xss", var_attrvalue10, "attribute");
            {
                boolean var_shoulddisplayattr13 = (((null != var_attrcontent11) && (!"".equals(var_attrcontent11))) && ((!"".equals(var_attrvalue10)) && (!((Object)false).equals(var_attrvalue10))));
                if (var_shoulddisplayattr13) {
                    out.write(" aria-label");
                    {
                        boolean var_istrueattr12 = (var_attrvalue10.equals(true));
                        if (!var_istrueattr12) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent11));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write(">");
    {
        Object var_templatevar14 = renderContext.getObjectModel().resolveProperty(_global_grouptemplate, "group");
        {
            Object var_templateoptions15_field$_items = renderContext.getObjectModel().resolveProperty(_global_navigation, "items");
            {
                java.util.Map var_templateoptions15 = obj().with("items", var_templateoptions15_field$_items);
                callUnit(out, renderContext, var_templatevar14, var_templateoptions15);
            }
        }
    }
    out.write("</nav>");
}
out.write("\r\n");
{
    Object var_templatevar16 = renderContext.getObjectModel().resolveProperty(_global_template, "placeholder");
    {
        boolean var_templateoptions17_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            String var_templateoptions17_field$_classappend = "cmp-navigation";
            {
                java.util.Map var_templateoptions17 = obj().with("isEmpty", var_templateoptions17_field$_isempty).with("classAppend", var_templateoptions17_field$_classappend);
                callUnit(out, renderContext, var_templatevar16, var_templateoptions17);
            }
        }
    }
}
out.write("\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

