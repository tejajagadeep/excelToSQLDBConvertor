package com.cts.userinfo.userdetails.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "User_Account_Details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserAccountDetails {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false)
    private int userId;

    @Column(name = "user_account_no", length = 15, nullable = false, unique = true)
    private long userAccountNo;

    @Column(name = "user_account_type", nullable = false)
    private String userAccountType;

    @Column(name = "account_creation_date", nullable = false, updatable = false)
    private Date accountCreationDate;

    @Column(name = "operation_type", nullable = false)
    private String operationType;

    @Column(name = "second_operator_name")
    private String secondOperatorName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name ="user_id")
//    private UserDetails userDetails;

}
