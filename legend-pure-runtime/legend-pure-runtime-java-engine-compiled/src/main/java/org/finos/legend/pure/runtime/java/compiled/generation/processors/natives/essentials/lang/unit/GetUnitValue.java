// Copyright 2020 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.pure.runtime.java.compiled.generation.processors.natives.essentials.lang.unit;

import org.eclipse.collections.api.list.ListIterable;
import org.finos.legend.pure.m4.coreinstance.CoreInstance;
import org.finos.legend.pure.runtime.java.compiled.generation.ProcessorContext;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.natives.AbstractNative;

public class GetUnitValue extends AbstractNative
{
    public GetUnitValue()
    {
        super("getUnitValue_Any_1__Number_1_");
    }

    @Override
    public String build(CoreInstance topLevelElement, CoreInstance functionExpression, ListIterable<String> transformedParams, ProcessorContext processorContext)
    {
        return "((QuantityCoreInstance) " + transformedParams.get(0) + ").getValue()";
    }

    @Override
    public String buildBody()
    {
        return "new DefendedPureFunction1<Object, " + Number.class.getName() + ">()\n" +
                "        {\n" +
                "            @Override\n" +
                "            public " + Number.class.getName() + " value(Object quantity, ExecutionSupport es)\n" +
                "            {\n" +
                "                return ((QuantityCoreInstance) quantity).getValue();\n" +
                "            }\n" +
                "        }";
    }
}
