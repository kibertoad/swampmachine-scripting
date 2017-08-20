package net.kiberion.swampmachine.templating.mustache;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import com.github.mustachejava.Mustache;
import net.kiberion.swampmachine.templating.api.Template;

/**
 * Mustache-based template implementation.
 *
 * @author kibertoad
 * @see <a href="https://github.com/spullara/mustache.java</a>
 */
public class MustacheTemplate implements Template {

  private final Mustache mustache;

  public MustacheTemplate(Mustache mustache) {
    this.mustache = mustache;
  }

  @Override
  public String eval(Map<String, Object> variableMap) {
    try (Writer writer = new StringWriter()) {
      mustache.execute(writer, variableMap);
      writer.flush();
      return writer.toString();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
