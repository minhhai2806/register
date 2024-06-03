package admin_user.service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public interface UserService {




	User save (UserDto userDto);
	List<User> getAllUsers();
	Optional<User> findUserById(Long id);


	// Trong UserService.java
	User updateUser(Long id, User updatedUser);

	void deleteUser(Long id);


}
