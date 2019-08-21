package integration.tests;

import integration.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class UpdateParentTest {

    @Test
    @JsonTestCase("integration_tests/put/update_parent_test.json")
    public void test_updateParent() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/put/update_parent_no_body_test.json")
    public void test_updateParentWithEmptyBody() throws Exception {
    }

}
