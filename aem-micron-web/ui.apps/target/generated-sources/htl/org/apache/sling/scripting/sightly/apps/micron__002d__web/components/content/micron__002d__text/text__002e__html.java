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
package org.apache.sling.scripting.sightly.apps.micron__002d__web.components.content.micron__002d__text;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class text__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_textmodel = null;
Object _global_component = null;
Object _global_templates = null;
Object _global_text = null;
_global_textmodel = renderContext.call("use", com.micron.web.core.models.ProductionDescriptionModel.class.getName(), obj());
_global_component = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Component.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_text = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_textmodel, "productDetailCfModel"), "description");
if (renderContext.getObjectModel().toBoolean(_global_text)) {
    out.write("<div");
    {
        Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_global_component, "id");
        {
            Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
            {
                boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
                if (var_shoulddisplayattr3) {
                    out.write(" id");
                    {
                        boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                        if (!var_istrueattr2) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write(" class=\"cmp-text\">\r\n    ");
    {
        Object var_unwrapcondition4 = renderContext.getObjectModel().resolveProperty(_global_textmodel, "isRichText");
        if (!renderContext.getObjectModel().toBoolean(var_unwrapcondition4)) {
            out.write("<p class=\"cmp-text__paragraph\">");
        }
        {
            Object var_5 = renderContext.call("xss", _global_text, (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_textmodel, "isRichText")) ? "html" : "text"));
            out.write(renderContext.getObjectModel().toString(var_5));
        }
        if (!renderContext.getObjectModel().toBoolean(var_unwrapcondition4)) {
            out.write("</p>");
        }
    }
    out.write("\r\n</div>");
}
out.write("\r\n");
{
    Object var_templatevar6 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions7_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_text));
        {
            String var_templateoptions7_field$_classappend = "cmp-text";
            {
                java.util.Map var_templateoptions7 = obj().with("isEmpty", var_templateoptions7_field$_isempty).with("classAppend", var_templateoptions7_field$_classappend);
                callUnit(out, renderContext, var_templatevar6, var_templateoptions7);
            }
        }
    }
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

