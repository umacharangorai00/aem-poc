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
package org.apache.sling.scripting.sightly.apps.micron__002d__web.components.content.dynamic__002d__component;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class dynamic__002d__component__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_dynamiccomponent = null;
Object _global_hastype = null;
Object _dynamic_properties = bindings.get("properties");
_global_dynamiccomponent = renderContext.call("use", com.micron.web.core.models.DynamicComponentModel.class.getName(), obj());
out.write("\n\n");
_global_hastype = renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType");
if (renderContext.getObjectModel().toBoolean(_global_hastype)) {
    out.write("\n    <pre>");
    {
        String var_0 = ("This product is a: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "productType"), "text")));
        out.write(renderContext.getObjectModel().toString(var_0));
    }
    out.write("</pre>\n    <pre>Specs</pre>\n    ");
    {
        Object var_testvariable1 = (((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "phone")) ? renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "operatingSystem") : (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "phone"))));
        if (renderContext.getObjectModel().toBoolean(var_testvariable1)) {
            out.write("<pre>");
            {
                String var_2 = ("Operating system: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "operatingSystem"), "text")));
                out.write(renderContext.getObjectModel().toString(var_2));
            }
            out.write("</pre>");
        }
    }
    out.write("\n    ");
    {
        Object var_testvariable3 = (((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "phone")) ? renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "camera") : (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "phone"))));
        if (renderContext.getObjectModel().toBoolean(var_testvariable3)) {
            out.write("<pre>");
            {
                String var_4 = ("Camera: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "camera"), "text")));
                out.write(renderContext.getObjectModel().toString(var_4));
            }
            out.write("</pre>");
        }
    }
    out.write("\n    ");
    {
        Object var_testvariable5 = (((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "laptop")) ? renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "screenSize") : (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "laptop"))));
        if (renderContext.getObjectModel().toBoolean(var_testvariable5)) {
            out.write("<pre>");
            {
                String var_6 = ("Screen size: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "screenSize"), "text")));
                out.write(renderContext.getObjectModel().toString(var_6));
            }
            out.write("</pre>");
        }
    }
    out.write("\n    ");
    {
        Object var_testvariable7 = (((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "laptop")) ? renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "keyboardLayout") : (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "laptop"))));
        if (renderContext.getObjectModel().toBoolean(var_testvariable7)) {
            out.write("<pre>");
            {
                String var_8 = ("Keyboard layout: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "keyboardLayout"), "text")));
                out.write(renderContext.getObjectModel().toString(var_8));
            }
            out.write("</pre>");
        }
    }
    out.write("\n    ");
    {
        Object var_testvariable9 = (((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "tv")) ? renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "supportHdr") : (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "tv"))));
        if (renderContext.getObjectModel().toBoolean(var_testvariable9)) {
            out.write("<pre>");
            {
                String var_10 = ("Supports HDR: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "supportHdr"), "text")));
                out.write(renderContext.getObjectModel().toString(var_10));
            }
            out.write("</pre>");
        }
    }
    out.write("\n    ");
    {
        boolean var_testvariable11 = ((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "tv")) && (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "supportHdr"))));
        if (var_testvariable11) {
            out.write("<pre>Supports HDR: false</pre>");
        }
    }
    out.write("\n    ");
    {
        Object var_testvariable12 = (((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "tv")) ? renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "resolution") : (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "productType"), "tv"))));
        if (renderContext.getObjectModel().toBoolean(var_testvariable12)) {
            out.write("<pre>");
            {
                String var_13 = ("Resolution: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_dynamiccomponent, "resolution"), "text")));
                out.write(renderContext.getObjectModel().toString(var_13));
            }
            out.write("</pre>");
        }
    }
    out.write("\n");
}
out.write("\n");
{
    boolean var_testvariable14 = (!renderContext.getObjectModel().toBoolean(_global_hastype));
    if (var_testvariable14) {
        out.write("<pre>Dynamic Component</pre>");
    }
}
out.write("\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

