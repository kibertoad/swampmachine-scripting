package net.kiberion.swampmachine.scripting.groovy;

import java.io.Reader;
import java.util.HashMap;

import net.kiberion.swampmachine.scripting.api.SwampBinding;
import net.kiberion.swampmachine.scripting.api.SwampScript;
import net.kiberion.swampmachine.scripting.api.SwampScriptInvokationResult;
import org.apache.commons.lang3.Validate;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * This class is thread-safe
 * 
 * @author kibertoad
 *
 */
public class GroovyScript implements SwampScript {

    private Script compiledScript;

    public GroovyScript() {
    }

    public GroovyScript(String script) {
        GroovyShell shell = new GroovyShell();
        compiledScript = shell.parse(script);
    }

    public GroovyScript(Reader script) {
        GroovyShell shell = new GroovyShell();
        compiledScript = shell.parse(script);
    }

    @Override
    public SwampScriptInvokationResult apply(SwampBinding binding) {
        Validate.notNull(binding, "Binding cannot be null.");
        GroovyInvokationResult result = new GroovyInvokationResult();
        try {
            Script invokableScript = compiledScript.getClass().newInstance();
            invokableScript.setBinding((GroovyBinding) binding);
            Object resultObject = invokableScript.run();
            result.setVariables(new HashMap<>(binding.getVariableMap()));
            result.getVariables().put(SCRIPT_RESULT, resultObject);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        return result;
    }

}
