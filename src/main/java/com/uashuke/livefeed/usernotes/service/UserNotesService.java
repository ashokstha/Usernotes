package com.uashuke.livefeed.usernotes.service;

import com.uashuke.livefeed.usernotes.dao.UserNotesDao;
import com.uashuke.livefeed.usernotes.model.ApiRequest;

import java.util.List;
import java.util.Map;

public interface UserNotesService {
    public List<UserNotesDao> getAllNotes();
    public void saveUserNotes(ApiRequest apiRequest);
    void deleteUserNotes(ApiRequest apiRequest);

    List<UserNotesDao> getAllNotesWs(Map<String, String> aUserNotes);
    void saveUserNotesWs(Map<String, String> aUserNotes);
    void deleteUserNotesWs(Map<String, String> aUserNotes);
}
