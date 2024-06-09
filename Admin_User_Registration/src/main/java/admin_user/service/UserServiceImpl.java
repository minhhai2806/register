package admin_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}

	// Trong UserService.java





	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(), userDto.getFullname(),userDto.getDob(),userDto.getJob(), userDto.getLevel(),userDto.getDesire() );
		return userRepository.save(user);
	}

}
