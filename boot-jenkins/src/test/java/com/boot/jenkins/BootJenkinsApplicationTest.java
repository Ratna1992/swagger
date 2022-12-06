package com.boot.jenkins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootJenkinsApplicationTest {

	public static Logger log = LoggerFactory.getLogger(BootJenkinsApplicationTest.class);
	@Test
	void test() {
		log.info("BootJenkinsApplicationTest started .....");
		assertEquals(true, true);
	}

}
