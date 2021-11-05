package com.guzman.belt_exam_lyrics.repositories;

import java.util.List;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.CrudRepository;


import com.guzman.belt_exam_lyrics.models.User;
import com.guzman.belt_exam_lyrics.models.Song;



public interface UserRepository extends CrudRepository<User, Long>{
    // this method retrieves all the books from the database
    List<User> findAll();
    // this method finds books with descriptions containing the search string
//    List<User> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
//    List<User> findBySongsNotContains(Song song);
     User findByEmail(String email);
     

}
