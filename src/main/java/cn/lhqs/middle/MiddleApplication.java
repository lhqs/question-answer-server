package cn.lhqs.middle;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
// @MapperScan("cn.lhqs.middle.mapper")
public class MiddleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddleApplication.class, args);
	}
}
