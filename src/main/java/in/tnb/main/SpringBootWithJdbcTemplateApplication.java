package in.tnb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import in.tnb.database.DataBases;
import in.tnb.service.User;

@SpringBootApplication
@ComponentScan(basePackages={"in.tnb.database","in.tnb.service"})
public class SpringBootWithJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext con= SpringApplication.run(SpringBootWithJdbcTemplateApplication.class, args);
		User u=(User)con.getBean("user");
		u.setEmail("btarak@gmail.com");
		u.setName("Tarak Nath Bar");
		DataBases db=(DataBases)con.getBean("dataBases");
		//db.save(u);
		//db.delete(u);
		//db.update(u);
		//db.selectoneObj(u.getEmail());
		db.selectMultipleObj(u.getEmail());
		
	}

}
