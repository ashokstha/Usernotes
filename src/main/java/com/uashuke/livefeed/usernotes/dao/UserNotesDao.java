package com.uashuke.livefeed.usernotes.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserNotesDao {
    private String username;
    private String message;
    private String lastUpdatedBy;
    private String lastUpdatedTs;
    private String expiryDateTs;
    private String topics;
}
