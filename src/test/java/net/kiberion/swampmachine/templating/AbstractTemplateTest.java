package net.kiberion.swampmachine.templating;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import net.kiberion.swampmachine.scripting.utils.StopWatch;
import net.kiberion.swampmachine.templating.api.Template;
import net.kiberion.swampmachine.templating.api.TemplateFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public abstract class AbstractTemplateTest {

  private static final Logger log = LogManager.getLogger();

  public abstract TemplateFactory initTemplateFactory();

  public abstract String getHelloTemplate();

  @Test
  public void testTemplateEval() throws Exception {
    TemplateFactory templateFactory = initTemplateFactory();
    Map<String, Object> variables = new HashMap<>();
    variables.put("name", "Mustache");

    log.info("==========================");
    log.info("Start run with: " + templateFactory.getClass().getSimpleName());

    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    StopWatch stopWatchEval = new StopWatch();
    stopWatchEval.start();
    Template template = templateFactory.produceTemplate(getHelloTemplate());
    stopWatch.endAndLog("produced template");

    assertEquals("Hello, Mustache!", template.eval(variables));
    stopWatchEval.endAndLog("finished eval");
  }

}
