package net.kiberion.swampmachine.scripting.common;


import java.util.function.Supplier;
import net.kiberion.swampmachine.scripting.api.SwampBinding;
import net.kiberion.swampmachine.scripting.api.SwampScript;
import org.apache.commons.lang3.Validate;

public class ScriptExecutingSupplier<R> implements Supplier<R> {

  private final SwampScript script;
  private final SwampBinding binding;

  public ScriptExecutingSupplier(SwampScript script, SwampBinding binding) {
    Validate.notNull(script);
    Validate.notNull(binding);
    this.script = script;
    this.binding = binding;
  }

  @SuppressWarnings("unchecked")
  @Override
  public R get() {
    return (R) script.apply(binding).getResult();
  }

}
