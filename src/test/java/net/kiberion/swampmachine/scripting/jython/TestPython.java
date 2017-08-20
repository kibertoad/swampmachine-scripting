package net.kiberion.swampmachine.scripting.jython;

import java.nio.file.Path;
import net.kiberion.swampmachine.scripting.AbstractScriptTest;
import net.kiberion.swampmachine.scripting.api.ScriptEntityFactory;
import net.kiberion.swampmachine.scripting.utils.FilePathUtils;

public class TestPython extends AbstractScriptTest {

    
    
    private final PythonEntityFactory factory = new PythonEntityFactory();
    
    @Override
    protected ScriptEntityFactory getEntityFactory() {
        return factory;
    }
    
    
    @Override
    protected Path getPathToTestResourcres() {
        return FilePathUtils.getResourceRootPath(TestPython.class, "test.py");
    }
    
}
