package net.kiberion.swampmachine.scripting.common;

import net.kiberion.swampmachine.scripting.api.SwampBinding;
import net.kiberion.swampmachine.scripting.api.SwampScript;
import org.apache.commons.lang3.Validate;

import lombok.Getter;

public class SwampConditionScript {

    @Getter
    private final SwampScript script;
    
    private static final String RESULT_VAR = "result";
    
    
    public SwampConditionScript(SwampScript script) {
        this.script = script;
    }

    public boolean evaluate (SwampBinding binding) {
        script.apply(binding);
        Boolean result = binding.getVariableValue(RESULT_VAR);
        Validate.notNull(result, "Result was not set for this script");
        return result;
    }

   
}
