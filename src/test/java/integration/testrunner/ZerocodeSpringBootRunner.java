package integration.testrunner;

import com.restful.parentchild.ParentChildApplication;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

public class ZerocodeSpringBootRunner extends ZeroCodeUnitRunner {
    public ZerocodeSpringBootRunner(Class<?> klass) throws InitializationError {
        super(klass);
        ParentChildApplication.start();
    }
}
