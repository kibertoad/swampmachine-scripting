package net.kiberion.swampmachine.scripting.api;

import java.util.function.Function;

public interface SwampScript extends Function<SwampBinding, SwampScriptInvokationResult> {

    public static final String SCRIPT_RESULT = "scriptResult";
    
}
