package net.kiberion.swampmachine.scripting.api;

public interface ScriptEntityFactory {

    public SwampBinding getBindingInstance ();
    public ScriptParser getParserInstance();
    
}
