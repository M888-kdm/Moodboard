package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.KudoBackApplication;

import javax.transaction.Transactional;

@SpringBootTest(classes = {KudoBackApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class GenericTest {

}
