package integration.tests;

import integration.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class UpdateChildTest {

    @Test
    @JsonTestCase("integration_tests/put/update_child_test.json")
    public void test_updateChild() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/put/update_child_no_body_test.json")
    public void test_updateChildWithEmptyBody() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/put/update_child_wrong_id_test.json")
    public void test_updateChildWithWrongId() throws Exception {
    }

}