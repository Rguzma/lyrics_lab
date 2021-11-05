package com.guzman.belt_exam_lyrics.repositories;

import java.util.List;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.CrudRepository;


import com.guzman.belt_exam_lyrics.models.User;
import com.guzman.belt_exam_lyrics.models.Song;



public interface SongRepository extends CrudRepository<Song, Long>{
    // this method retrieves all the books from the database
    List<Song> findAll();
    // this method finds books with descriptions containing the search string
//    List<Song> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
    List<Song> findByUsersNotContains(Song song);

}