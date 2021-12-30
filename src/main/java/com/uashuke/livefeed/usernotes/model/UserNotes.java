package com.uashuke.livefeed.usernotes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_notes")
public class UserNotes {
    private static final long serailVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;
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
