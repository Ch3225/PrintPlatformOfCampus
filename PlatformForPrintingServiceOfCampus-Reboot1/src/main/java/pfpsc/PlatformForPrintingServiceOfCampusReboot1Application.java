package pfpsc;

import org.mybatis.spring.annotation.MapperScan;
import org.openjdk.nashorn.internal.runtime.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pfpsc.constant.ChargeFunctionConstant;
import pfpsc.constant.JsonConstant;
import pfpsc.constant.QuestionNaireConstant;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
@ComponentScan("pfpsc")//扫描注解元素
@MapperScan("pfpsc.dao.impl")//Mybatis的DAO所在包
public class PlatformForPrintingServiceOfCampusReboot1Application {
	
	public static void constantOnLoad() {
		QuestionNaireConstant.onLoad();
		JsonConstant.onLoad();
		ChargeFunctionConstant.onLoad();
	}

	public static void main(String[] args) {
		
		SpringApplication.run(PlatformForPrintingServiceOfCampusReboot1Application.class, args);
		
		constantOnLoad();
	}

}
