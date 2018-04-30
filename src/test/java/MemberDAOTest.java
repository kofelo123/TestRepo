import domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import persistence.MemberDAO;

import javax.inject.Inject;

/**
 * DAO Test/(MyBatis-Dao-NoWas)/(zer136)
  */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations ={"file:web/WEB-INF/applicationContext.xml"})
public class MemberDAOTest {

    @Inject
    private MemberDAO dao;

    @Test
    public void testTime()throws Exception{

        System.out.println(dao.getTime());

    }

    @Test
    public void testInsertMember()throws Exception{

        MemberVO vo = new MemberVO();
        vo.setUserid("user90");
        vo.setUserpw("user00");
        vo.setUsername("USER00");
        vo.setEmail("user00@aaa.com");

        dao.insertMember(vo);

    }

}
