package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import com.example.demo.domain.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@PostMapping("/create")
	public User create(@RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}
	/*
	 * public List<User> listar(){ var user1 = new User(); user1.setId(1L);
	 * user1.setName("Fernando Duarte");
	 * user1.setEmail("fernandoduarte@ifsp.edu.br"); user1.setPhone(987654321);
	 * 
	 * var user2 = new User(); user2.setId(2L); user2.setName("Gislaine Rosales");
	 * user2.setEmail("gislaine@ifsp.edu.br"); user2.setPhone(123456789);
	 * 
	 * var user3 = new User(); user2.setId(3L); user2.setName("Edson nascimento");
	 * user2.setEmail("edson@ifsp.edu.br"); user2.setPhone(2143658798);
	 */
		
		//return Arrays.asList(user1, user2, user3);	
	//}
}
