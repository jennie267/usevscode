package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "TAUSER")
public class User {
    @Id
    @NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private Long userId;
    
    @Column(name = "emp_id")
    private String empId;
    private String userName;
    
}
