package com.winter;

import com.winter.model.User;
import com.winter.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemoApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	public void testFindAllUser() {
		List<User> allUser = userService.findAllUser(1, 5);
		log.info("hello,{}",JSONArray.toJSONString(allUser));
	}

}
