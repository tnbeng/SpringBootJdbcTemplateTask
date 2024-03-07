package in.tnb.database;

import java.util.List;

import in.tnb.service.User;

public interface DatabaseOperations {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public User selectoneObj(String name);
	public List<User> selectMultipleObj(String name);
}
