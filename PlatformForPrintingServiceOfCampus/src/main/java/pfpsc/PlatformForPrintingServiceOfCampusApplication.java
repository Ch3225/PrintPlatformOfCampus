package pfpsc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
@ComponentScan("pfpsc")//扫描注解元素
@MapperScan("pfpsc.dao")//Mybatis的DAO所在包
public class PlatformForPrintingServiceOfCampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformForPrintingServiceOfCampusApplication.class, args);
	}

}
