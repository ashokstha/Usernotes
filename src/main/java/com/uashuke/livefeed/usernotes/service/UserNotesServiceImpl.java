package com.uashuke.livefeed.usernotes.service;

import com.uashuke.livefeed.usernotes.dao.UserNotesDao;
import com.uashuke.livefeed.usernotes.model.ApiRequest;
import com.uashuke.livefeed.usernotes.model.UserNotes;
import com.uashuke.livefeed.usernotes.repository.UserNotesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserNotesServiceImpl implements UserNotesService{
    private static Logger logger = LoggerFactory.getLogger(UserNotesServiceImpl.class);

    @Autowired
    UserNotesRepository userNotesRepository;

    @Override
    public List<UserNotesDao> getAllNotes() {
        logger.info("Inside getallnotes");
        return null;
    }

    @Override
    public void saveUserNotes(ApiRequest apiRequest) {
        logger.info("Inside saveusernotes");
    }

    @Override
    public void deleteUserNotes(ApiRequest apiRequest) {
        logger.info("Inside deleteUserNotes");
    }

    @Override
    public List<UserNotesDao> getAllNotesWs(Map<String, String> aUserNotes) {
        logger.info("Inside getallnotesWS");
        return null;
    }

    @Override
    public void saveUserNotesWs(Map<String, String> aUserNotes) {
        logger.info("Inside saveUserNOtesWS");
    }

    @Override
    public void deleteUserNotesWs(Map<String, String> aUserNotes) {
        logger.info("Inside deleteUserNotesWS");
    }
}
