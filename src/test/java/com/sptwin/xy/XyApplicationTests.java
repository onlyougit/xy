package com.sptwin.xy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XyApplicationTests {

	@Test
	public void contextLoads() {
		String no = "A-1002";
		System.out.println(no.substring(0,no.indexOf("-")));
		System.out.println(no.substring(no.indexOf("-")+1));
	}

}
