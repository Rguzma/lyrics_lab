package com.guzman.belt_exam_lyrics.services;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.guzman.belt_exam_lyrics.models.Song;
import com.guzman.belt_exam_lyrics.models.User;


import com.guzman.belt_exam_lyrics.repositories.UserRepository;
import com.guzman.belt_exam_lyrics.repositories.UsersSongsCollaborationsRepository;

@Service
public class AppService {
		private final UserRepository userRepo;

		public AppService( UserRepository userRepo) {
			this.userRepo = userRepo;
		}

		

		public User getUser(Long id) {
			return this.userRepo.findById(id).orElse(null);
		}
		public User getByEmail(String email) {
			return this.userRepo.findByEmail(email);
		}
		public List<User> findUsers() {
			return this.userRepo.findAll();
		}

		public User createUser(User user) {
			return this.userRepo.save(user);
		}




//		// register user and hash their password
//	    public User registerUser(User user) {
//	        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//	        user.setPassword(hashed);
//	        return userRepo.save(user);
//	    }


	    // authenticate user
	    public boolean authenticateUser(String email, String password) {
	        // first find the user by email
	        User user = userRepo.findByEmail(email);
	        // if we can't find it by email, return false
	        if(user == null) {
	            return false;
	        } else {
	            // if the passwords match, return true, else, return false
	            if(BCrypt.checkpw(password, user.getPassword())) {
	                return true;
	            } else {
	                return false;
	            }
	        }
		
	}
}


