package com.uashuke.livefeed.usernotes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_notes")
public class UserNotes {
    @Column(name = "user_name")
    private String username;
    private String message;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;
    @Column(name = "last_updated_ts")
    private String lastUpdatedTs;
    @Column(name = "expiry_date_ts")
    private String expiryDateTs;
    private String topics;
}
