package com.tools.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tools.demo.test.dao.UserMapper;
import com.tools.demo.test.model.User;

/** 
* @ClassName: DemoApplicationTests 
* @Description: 测试
* @author lzx
* @date 2019年1月31日 上午11:23:13 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	UserMapper userMapper;

	@Test
	public void contextLoads() {
		List<User> selectAll = userMapper.selectAll();
		for (User user : selectAll) {
			System.out.println(user.getName());
		}
	}

}

