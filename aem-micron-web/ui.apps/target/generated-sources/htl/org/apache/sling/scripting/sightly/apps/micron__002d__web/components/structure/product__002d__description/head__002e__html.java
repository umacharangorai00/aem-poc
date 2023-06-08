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

public final class head__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_head = getProperty("head");
out.write("\r\n");
out.write("\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------

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
addSubTemplate("head", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _global_headlibrenderer = null;
Object _global_headresources = null;
Object _global_pdpdesc = null;
Object _dynamic_page = arguments.get("page");
Object _global_keywords = null;
Object _dynamic_properties = bindings.get("properties");
Object _global_description = null;
Object _global_templatename = null;
Object _dynamic_pwa = arguments.get("pwa");
Object _global_clientlib = null;
Object _global_appresourcespath = null;
Collection var_collectionvar45_list_coerced$ = null;
Collection var_attrmap56_list_coerced$ = null;
_global_headlibrenderer = renderContext.call("use", "headlibs.html", obj());
_global_headresources = renderContext.call("use", "head.resources.html", obj());
out.write("\r\n\r\n\t");
_global_pdpdesc = renderContext.call("use", "com.micron.web.core.models.ProductionDescriptionModel", obj());
out.write("\r\n    <meta charset=\"UTF-8\"/>\r\n    <title>");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_pdpdesc, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</title>\r\n    ");
_global_keywords = renderContext.getObjectModel().resolveProperty(_dynamic_page, "keywords");
if (renderContext.getObjectModel().toBoolean(_global_keywords)) {
    out.write("<meta name=\"keywords\"");
    {
        Object var_attrvalue1 = _global_keywords;
        {
            Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
            {
                boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
                if (var_shoulddisplayattr4) {
                    out.write(" content");
                    {
                        boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                        if (!var_istrueattr3) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent2));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\r\n    ");
_global_description = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_page, "description")) ? renderContext.getObjectModel().resolveProperty(_dynamic_page, "description") : renderContext.getObjectModel().resolveProperty(_dynamic_properties, "jcr:description")));
if (renderContext.getObjectModel().toBoolean(_global_description)) {
    out.write("<meta name=\"description\"");
    {
        Object var_attrvalue5 = _global_description;
        {
            Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
            {
                boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
                if (var_shoulddisplayattr8) {
                    out.write(" content");
                    {
                        boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                        if (!var_istrueattr7) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\r\n    ");
_global_templatename = renderContext.getObjectModel().resolveProperty(_dynamic_page, "templateName");
if (renderContext.getObjectModel().toBoolean(_global_templatename)) {
    out.write("<meta name=\"template\"");
    {
        Object var_attrvalue9 = _global_templatename;
        {
            Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
            {
                boolean var_shoulddisplayattr12 = (((null != var_attrcontent10) && (!"".equals(var_attrcontent10))) && ((!"".equals(var_attrvalue9)) && (!((Object)false).equals(var_attrvalue9))));
                if (var_shoulddisplayattr12) {
                    out.write(" content");
                    {
                        boolean var_istrueattr11 = (var_attrvalue9.equals(true));
                        if (!var_istrueattr11) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent10));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\r\n    ");
{
    Object var_testvariable13 = renderContext.getObjectModel().resolveProperty(_dynamic_page, "robotsTags");
    if (renderContext.getObjectModel().toBoolean(var_testvariable13)) {
        out.write("<meta name=\"robots\"");
        {
            Object var_attrvalue14 = renderContext.call("join", renderContext.getObjectModel().resolveProperty(_dynamic_page, "robotsTags"), ", ");
            {
                Object var_attrcontent15 = renderContext.call("xss", var_attrvalue14, "attribute");
                {
                    boolean var_shoulddisplayattr17 = (((null != var_attrcontent15) && (!"".equals(var_attrcontent15))) && ((!"".equals(var_attrvalue14)) && (!((Object)false).equals(var_attrvalue14))));
                    if (var_shoulddisplayattr17) {
                        out.write(" content");
                        {
                            boolean var_istrueattr16 = (var_attrvalue14.equals(true));
                            if (!var_istrueattr16) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent15));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>");
    }
}
out.write("\r\n\r\n    ");
{
    Object var_testvariable18 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "enabled");
    if (renderContext.getObjectModel().toBoolean(var_testvariable18)) {
        out.write("\r\n        <link rel=\"manifest\"");
        {
            Object var_attrvalue19 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "manifestPath");
            {
                Object var_attrcontent20 = renderContext.call("xss", var_attrvalue19, "uri");
                {
                    boolean var_shoulddisplayattr22 = (((null != var_attrcontent20) && (!"".equals(var_attrcontent20))) && ((!"".equals(var_attrvalue19)) && (!((Object)false).equals(var_attrvalue19))));
                    if (var_shoulddisplayattr22) {
                        out.write(" href");
                        {
                            boolean var_istrueattr21 = (var_attrvalue19.equals(true));
                            if (!var_istrueattr21) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent20));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(" crossorigin=\"use-credentials\"/>\r\n        <meta name=\"theme-color\"");
        {
            Object var_attrvalue23 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "themeColor");
            {
                Object var_attrcontent24 = renderContext.call("xss", var_attrvalue23, "attribute");
                {
                    boolean var_shoulddisplayattr26 = (((null != var_attrcontent24) && (!"".equals(var_attrcontent24))) && ((!"".equals(var_attrvalue23)) && (!((Object)false).equals(var_attrvalue23))));
                    if (var_shoulddisplayattr26) {
                        out.write(" content");
                        {
                            boolean var_istrueattr25 = (var_attrvalue23.equals(true));
                            if (!var_istrueattr25) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent24));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\r\n        <link rel=\"apple-touch-icon\"");
        {
            Object var_attrvalue27 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "iconPath");
            {
                Object var_attrcontent28 = renderContext.call("xss", var_attrvalue27, "uri");
                {
                    boolean var_shoulddisplayattr30 = (((null != var_attrcontent28) && (!"".equals(var_attrcontent28))) && ((!"".equals(var_attrvalue27)) && (!((Object)false).equals(var_attrvalue27))));
                    if (var_shoulddisplayattr30) {
                        out.write(" href");
                        {
                            boolean var_istrueattr29 = (var_attrvalue27.equals(true));
                            if (!var_istrueattr29) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent28));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\r\n        ");
_global_clientlib = renderContext.call("use", "core/wcm/components/commons/v1/templates/clientlib.html", obj());
        {
            Object var_templatevar31 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "css");
            {
                String var_templateoptions32_field$_categories = "core.wcm.components.page.v2.pwa";
                {
                    java.util.Map var_templateoptions32 = obj().with("categories", var_templateoptions32_field$_categories);
                    callUnit(out, renderContext, var_templatevar31, var_templateoptions32);
                }
            }
        }
        out.write("\r\n        <meta name=\"cq:sw_path\"");
        {
            Object var_attrvalue33 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "serviceWorkerPath"), "text");
            {
                boolean var_shoulddisplayattr36 = ((!"".equals(var_attrvalue33)) && (!((Object)false).equals(var_attrvalue33)));
                if (var_shoulddisplayattr36) {
                    out.write(" content");
                    {
                        boolean var_istrueattr35 = (var_attrvalue33.equals(true));
                        if (!var_istrueattr35) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrvalue33));
                            out.write("\"");
                        }
                    }
                }
            }
        }
        out.write("/>\r\n    ");
    }
}
out.write("\r\n    ");
{
    Object var_includedresult37 = renderContext.call("include", "head.links.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult37));
}
out.write("\r\n    ");
{
    Object var_includedresult39 = renderContext.call("include", "customheaderlibs.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult39));
}
out.write("\r\n    ");
{
    Object var_templatevar41 = renderContext.getObjectModel().resolveProperty(_global_headlibrenderer, "headlibs");
    {
        Object var_templateoptions42_field$_clientlibcategories = renderContext.getObjectModel().resolveProperty(_dynamic_page, "clientLibCategories");
        {
            Object var_templateoptions42_field$_hascloudconfigsupport = renderContext.getObjectModel().resolveProperty(_dynamic_page, "hasCloudconfigSupport");
            {
                Object var_templateoptions42_field$_clientlibcategoriesjshead = renderContext.getObjectModel().resolveProperty(_dynamic_page, "clientLibCategoriesJsHead");
                {
                    Object var_templateoptions42_field$_staticdesignpath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "staticDesignPath");
                    {
                        Object var_templateoptions42_field$_page = _dynamic_page;
                        {
                            Object var_templateoptions42_field$_designpath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "designPath");
                            {
                                java.util.Map var_templateoptions42 = obj().with("clientLibCategories", var_templateoptions42_field$_clientlibcategories).with("hasCloudconfigSupport", var_templateoptions42_field$_hascloudconfigsupport).with("clientLibCategoriesJsHead", var_templateoptions42_field$_clientlibcategoriesjshead).with("staticDesignPath", var_templateoptions42_field$_staticdesignpath).with("page", var_templateoptions42_field$_page).with("designPath", var_templateoptions42_field$_designpath);
                                callUnit(out, renderContext, var_templatevar41, var_templateoptions42);
                            }
                        }
                    }
                }
            }
        }
    }
}
out.write("\r\n    ");
_global_appresourcespath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "appResourcesPath");
if (renderContext.getObjectModel().toBoolean(_global_appresourcespath)) {
    {
        Object var_templatevar43 = renderContext.getObjectModel().resolveProperty(_global_headresources, "favicons");
        {
            Object var_templateoptions44_field$_path = _global_appresourcespath;
            {
                java.util.Map var_templateoptions44 = obj().with("path", var_templateoptions44_field$_path);
                callUnit(out, renderContext, var_templatevar43, var_templateoptions44);
            }
        }
    }
}
out.write("\r\n    ");
{
    Object var_collectionvar45 = renderContext.getObjectModel().resolveProperty(_dynamic_page, "htmlPageItems");
    {
        long var_size46 = ((var_collectionvar45_list_coerced$ == null ? (var_collectionvar45_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar45)) : var_collectionvar45_list_coerced$).size());
        {
            boolean var_notempty47 = (var_size46 > 0);
            if (var_notempty47) {
                {
                    long var_end50 = var_size46;
                    {
                        boolean var_validstartstepend51 = (((0 < var_size46) && true) && (var_end50 > 0));
                        if (var_validstartstepend51) {
                            if (var_collectionvar45_list_coerced$ == null) {
                                var_collectionvar45_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar45);
                            }
                            long var_index52 = 0;
                            for (Object item : var_collectionvar45_list_coerced$) {
                                {
                                    boolean var_traversal54 = (((var_index52 >= 0) && (var_index52 <= var_end50)) && true);
                                    if (var_traversal54) {
                                        {
                                            boolean var_testvariable57 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "location"), "name"), "header"));
                                            if (var_testvariable57) {
                                                {
                                                    Object var_tagvar55 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "element"), "name"), "unsafe");
                                                    if (renderContext.getObjectModel().toBoolean(var_tagvar55)) {
                                                        out.write("<");
                                                        out.write(renderContext.getObjectModel().toString(var_tagvar55));
                                                    }
                                                    if (!renderContext.getObjectModel().toBoolean(var_tagvar55)) {
                                                        out.write("<script");
                                                    }
                                                    {
                                                        Object var_attrmap56 = renderContext.getObjectModel().resolveProperty(item, "attributes");
                                                        {
                                                            java.util.Map var_ignoredattributes58 = obj();
                                                            if (var_attrmap56_list_coerced$ == null) {
                                                                var_attrmap56_list_coerced$ = renderContext.getObjectModel().toCollection(var_attrmap56);
                                                            }
                                                            long var_attrindex61 = 0;
                                                            for (Object var_attrname59 : var_attrmap56_list_coerced$) {
                                                                {
                                                                    Object var_attrnameescaped60 = renderContext.call("xss", var_attrname59, "attributeName");
                                                                    if (renderContext.getObjectModel().toBoolean(var_attrnameescaped60)) {
                                                                        {
                                                                            Object var_isignoredattr62 = var_ignoredattributes58.get(var_attrname59);
                                                                            if (!renderContext.getObjectModel().toBoolean(var_isignoredattr62)) {
                                                                                {
                                                                                    Object var_attrcontent63 = renderContext.getObjectModel().resolveProperty(var_attrmap56, var_attrname59);
                                                                                    {
                                                                                        Object var_attrcontentescaped64 = renderContext.call("xss", var_attrcontent63, "attribute", var_attrnameescaped60);
                                                                                        {
                                                                                            boolean var_shoulddisplayattr65 = (((null != var_attrcontentescaped64) && (!"".equals(var_attrcontentescaped64))) && ((!"".equals(var_attrcontent63)) && (!((Object)false).equals(var_attrcontent63))));
                                                                                            if (var_shoulddisplayattr65) {
                                                                                                out.write(" ");
                                                                                                out.write(renderContext.getObjectModel().toString(var_attrnameescaped60));
                                                                                                {
                                                                                                    boolean var_istrueattr66 = (var_attrcontent63.equals(true));
                                                                                                    if (!var_istrueattr66) {
                                                                                                        out.write("=\"");
                                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontentescaped64));
                                                                                                        out.write("\"");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                var_attrindex61++;
                                                            }
                                                        }
                                                        var_attrmap56_list_coerced$ = null;
                                                    }
                                                    out.write(">");
                                                    if (renderContext.getObjectModel().toBoolean(var_tagvar55)) {
                                                        out.write("</");
                                                        out.write(renderContext.getObjectModel().toString(var_tagvar55));
                                                        out.write(">");
                                                    }
                                                    if (!renderContext.getObjectModel().toBoolean(var_tagvar55)) {
                                                        out.write("</script>");
                                                    }
                                                }
                                            }
                                        }
                                        out.write("\r\n    ");
                                    }
                                }
                                var_index52++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar45_list_coerced$ = null;
}
out.write("\r\n");


// End Of Main Sub-Template Body ------------------------------------------------------------------
    }



    {
//Sub-Sub-Templates Initialization ----------------------------------------------------------------



//End of Sub-Sub-Templates Initialization ---------------------------------------------------------
    }
    
});


//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

