package net.kiberion.swampmachine.scripting.jython;

import java.io.Reader;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import net.kiberion.swampmachine.scripting.api.SwampScript;
import org.python.core.PyCode;
import org.python.google.common.collect.ImmutableSet;
import org.python.util.PythonInterpreter;

import net.kiberion.swampmachine.scripting.common.AbstractScriptParser;

/**
 * 
 * @author kibertoad
 *
 */
public class PythonScriptParser extends AbstractScriptParser {

    private boolean isInitted;

    private Set<String> extensions = ImmutableSet.of("py");

    @Override
    public PythonScript parseScript(Reader reader) {
        try (PythonInterpreter interp = new PythonInterpreter()) {
            PyCode compiledCode = interp.compile(reader);
            PythonScript activeScript = new PythonScript(compiledCode);
            return activeScript;
        }
    }

    @Override
    public PythonScript parseScript(String script) {
        try (PythonInterpreter interp = new PythonInterpreter()) {
            PyCode compiledCode = interp.compile(script);
            PythonScript activeScript = new PythonScript(compiledCode);
            return activeScript;
        }
    }

    public void init() {
        PythonInitter.init();
        isInitted = true;
    }
    
    @Override
    public List<SwampScript> parseScriptsFromPath(Path directory) {
        if (!isInitted) {
            init();
        }
        return super.parseScriptsFromPath(directory);
    }

    @Override
    protected Set<String> getScriptExtensions() {
        return extensions;
    }

}
