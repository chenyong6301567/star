package cyTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.hotyum.stars.SpringBootMain;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.TokenInfoVO;

/**
 * @author cy
 * @Description 
 * @date 2018年1月7日下午2:39:41 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CyTest {

	@Autowired
	private UserManager userManager;

	@Test
	public void testLogin() {
		TokenInfoVO tokenInfoVO = userManager.login("15700191306", "123456", "", 2);
		System.out.println(JSON.toJSONString(tokenInfoVO) + "'=========================");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
