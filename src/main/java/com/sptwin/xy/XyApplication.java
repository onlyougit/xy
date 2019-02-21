package com.sptwin.xy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.sptwin.xy.mapper")
public class XyApplication {
	public static void main(String[] args) {
		SpringApplication.run(XyApplication.class, args);
	}
	public void a(){

	}
	public void b(){}
}
