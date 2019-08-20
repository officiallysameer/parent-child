package integration.testrunner;

import com.restful.parentchild.ParentChildApplication;
import org.jsmart.zerocode.core.runner.ZeroCodePackageRunner;
import org.junit.runners.model.InitializationError;

public class ZerocodeSpringBootSuite extends ZeroCodePackageRunner {

    static {
        ParentChildApplication.start();
    }

    public ZerocodeSpringBootSuite(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
