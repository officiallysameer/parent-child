package integration.tests;

import integration.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class GetParentByIdTest {

    @Test
    @JsonTestCase("integration_tests/get/get_parent_by_id_test.json")
    public void test_getParentById() throws Exception {
    }
}
