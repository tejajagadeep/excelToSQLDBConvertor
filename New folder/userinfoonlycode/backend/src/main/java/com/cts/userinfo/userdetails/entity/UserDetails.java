package com.cts.userinfo.userdetails.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "User_Details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDetails {

    @Id
    @Column(name = "user_id", updatable = false)
    private int userId;

    @Column(name = "user_fname", nullable = false)
    private String userFName;

    @Column(name = "user_lname", nullable = false)
    private String userLName;

    @Column(name = "user_mobile_number", length = 10, nullable = false, unique = true)
    private long userMobileNumber;

    @Column(name = "user_email_id", unique = true, nullable = false)
    private String userEmailId;

    @Column(name = "user_created_date", nullable = false, updatable = false)
    private Date userCreatedDate;

}
