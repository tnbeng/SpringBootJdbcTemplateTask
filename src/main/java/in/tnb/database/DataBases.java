package in.tnb.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import in.tnb.service.User;

@Component
public class DataBases {
   
	@Autowired
	JdbcTemplate j;
	
	public void save(User user)
	{  	
		String sql="insert into register(name,email) values(?,?)";
		int i=j.update(sql,user.getName(),user.getEmail());
		System.out.println("Row effected :"+i);
	}
	public void delete(User user)
	{
		String sql="delete from register where name=?";
		int i=j.update(sql,user.getName());
		System.out.println("Row effected :"+i);
	}
	public void update(User user)
	{
		String sql="update register set name=? where  name=?";
		int i=j.update(sql,user.getName(),"t");
		System.out.println("Row effected :"+i);
	}
	public User selectoneObj(String name)
	{
		String sql="select * from register where email=?";
		
		User u=j.queryForObject(sql,new RowM(),name);//It returns only obe object,if it finds miltiple objects it will give exceptiion 
	    u.show();
		return u;
	}
	public List<User> selectMultipleObj(String name)
	{
		String sql="select * from register where email=?";
		
		List<User> stu=j.query(sql,new RowM(), name);//It returns a list of objects
		for(User u:stu)
		{
			u.show();
		}
		return stu;
	}
	
	
	
}
