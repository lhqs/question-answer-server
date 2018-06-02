package cn.lhqs.middle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiddleApplicationTests {

	/*@Resource
	MailServiceImpl mailService;*/
	@Resource
	DataSource dataSource;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testSimpleMail() throws Exception {
		// mailService.sendSimpleMail("lhqs.gu@qq.com","test simple mail"," hello this is simple mail");
	}

	@Test
	public void datasourceTest() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

}
