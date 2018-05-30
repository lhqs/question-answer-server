package cn.lhqs.middle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lhqs.middle.mapper")
public class MiddleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddleApplication.class, args);
	}
}
