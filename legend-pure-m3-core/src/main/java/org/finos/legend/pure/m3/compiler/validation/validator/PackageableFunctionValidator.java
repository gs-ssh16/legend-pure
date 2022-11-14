package org.finos.legend.pure.m3.compiler.validation.validator;

import org.finos.legend.pure.m3.compiler.Context;
import org.finos.legend.pure.m3.compiler.validation.ValidatorState;
import org.finos.legend.pure.m3.coreinstance.meta.pure.metamodel.function.PackageableFunction;
import org.finos.legend.pure.m3.navigation.M3Paths;
import org.finos.legend.pure.m3.tools.matcher.MatchRunner;
import org.finos.legend.pure.m3.tools.matcher.Matcher;
import org.finos.legend.pure.m3.tools.matcher.MatcherState;
import org.finos.legend.pure.m4.ModelRepository;
import org.finos.legend.pure.m4.coreinstance.CoreInstance;
import org.finos.legend.pure.m4.exception.PureCompilationException;

public class PackageableFunctionValidator implements MatchRunner<PackageableFunction<CoreInstance>>
{
    @Override
    public String getClassName()
    {
        return M3Paths.PackageableFunction;
    }

    @Override
    public void run(PackageableFunction<CoreInstance> functionDefinition, MatcherState state, Matcher matcher, ModelRepository modelRepository, Context context) throws PureCompilationException
    {
        ElementWithConstraintsValidator.validateConstraints(functionDefinition, functionDefinition._preConstraints(), state);
        ElementWithConstraintsValidator.validateConstraints(functionDefinition, functionDefinition._postConstraints(), state);
    }
}
