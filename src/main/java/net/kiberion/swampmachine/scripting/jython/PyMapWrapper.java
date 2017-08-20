package net.kiberion.swampmachine.scripting.jython;

import net.kiberion.swampmachine.scripting.api.SwampScriptInvokationResult;
import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyStringMap;


public class PyMapWrapper implements SwampScriptInvokationResult {

    private final PyStringMap map;

    public PyMapWrapper(PyStringMap map) {
        this.map = map.copy();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getVariableValue(String key) {
        PyObject object = map.get(Py.newString(key));
        return (T) convertSupportedValues(object);
    }

    private Object convertSupportedValues(PyObject object) {
        if (object instanceof PyBoolean) {
            return ((PyBoolean) object).getBooleanValue();
        } else if (object instanceof PyInteger) {
            return ((PyInteger) object).getValue();
        } else {
            return object;
        }
    }

}
