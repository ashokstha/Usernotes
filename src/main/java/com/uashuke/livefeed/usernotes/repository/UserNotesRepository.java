package com.uashuke.livefeed.usernotes.repository;

import com.uashuke.livefeed.usernotes.dao.UserNotesDao;
import com.uashuke.livefeed.usernotes.model.UserNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserNotesRepository extends JpaRepository<UserNotes, Integer> {
    public List<UserNotes> findAll();

    @Query(value = "select * from dual", nativeQuery = true)
    List<UserNotesDao> findAllUserNotes();
}
