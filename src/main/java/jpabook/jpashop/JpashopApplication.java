package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//패키지 안에 있는 모든것을 component scan해서 spring bean으로 자동 등록
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

	@Bean
	Hibernate5Module hibernate5Module(){
		return new Hibernate5Module();
	} // 단점 : 엔티티 노출된다.
}
