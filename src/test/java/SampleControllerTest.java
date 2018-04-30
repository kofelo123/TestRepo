import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;


/**
 * WAS없이 컨트롤러 테스트하기 / use spring-test dependency / zer-120
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // spring-test dependency필요
@ContextConfiguration(locations ={"file:web/WEB-INF/applicationContext.xml","file:web/WEB-INF/dispatcher-servlet.xml"})

public class SampleControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class); //slf4j dependency

    @Inject
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        logger.info("setup...");
    }

    @Test
    public void testDoA() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
    }
}

/**
 * MockMvc는 브라우저에서 요청과 응답을 의미하는 객체
 * setup()메소드에서 @Before 어노테이션으로 처리되어 매번 테스트 실행전에MockMvc객체를 만든다.
 *
 * testDoa()에서 MockMvc를 사용해서 perform()이라는 메소드로 get(),post()등의 get,post 방식의 호출에 사용한다.
  */
