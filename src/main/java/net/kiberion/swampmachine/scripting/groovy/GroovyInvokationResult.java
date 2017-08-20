package net.kiberion.swampmachine.scripting.groovy;

import java.util.Map;

import net.kiberion.swampmachine.scripting.api.SwampScriptInvokationResult;
import org.apache.commons.lang3.Validate;

import lombok.Getter;
public class GroovyInvokationResult implements SwampScriptInvokationResult {

    @Getter
    private Map<String, Object> variables;
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getVariableValue(String varName) {
        return (T) variables.get(varName);
    }

    public void setVariables(Map<String, Object> variables) {
        Validate.notNull(variables, "Variables are null");
        this.variables = variables;
    }
}
