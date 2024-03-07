package in.tnb.database;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import in.tnb.service.User;

public class RowM implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		 
		User user=new User();
			user.setName(rs.getString("name"));	
		    user.setEmail(rs.getString("email"));
		return user ;
		
	}
     
	
}
