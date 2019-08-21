package integration.tests;

import integration.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class CreateParentTest {

    @Test
    @JsonTestCase("integration_tests/post/create_parent_test.json")
    public void test_createNewParent() throws Exception {
    }
}
