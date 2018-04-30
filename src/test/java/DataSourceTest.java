import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * DataSource 테스트 코드 만들기 (zerock88)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:web/WEB-INF/applicationContext.xml"})
public class DataSourceTest {

    @Inject
    private DataSource ds;

    @Test
    public void testConnection()throws Exception{

        try(Connection con = ds.getConnection()){
            System.out.println(con);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
