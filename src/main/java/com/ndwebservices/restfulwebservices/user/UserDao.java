package com.ndwebservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	// jpa/hibernate > database
	
	private static List<User> users = new ArrayList<>();
	
	public static int usercnt = 0;
	
	static {
		users.add(new User(++usercnt,"pd",LocalDate.now().minusYears(15)));
		users.add(new User(++usercnt,"pk", LocalDate.now().minusYears(32)));
		users.add(new User(++usercnt,"sk", LocalDate.now().minusYears(7)));
	}
	
	//public List<User> findAll
	public List<User> findAll(){
		return users;
	}
	public User save(User user) {
		user.setId(++usercnt);
		users.add(user);
		return user;
	}
	
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
		
	}

}
