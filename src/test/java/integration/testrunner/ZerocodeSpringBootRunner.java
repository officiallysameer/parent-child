package integration.testrunner;

import com.restful.parentchild.ParentChildApplication;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

public class ZerocodeSpringBootRunner extends ZeroCodeUnitRunner {

    private static boolean appRunning = false;

    public ZerocodeSpringBootRunner(Class<?> klass) throws InitializationError {
        super(klass);
        if (!appRunning) {
            ParentChildApplication.start();
            appRunning = true;
        }
    }
}
