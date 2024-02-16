package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="examApplication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class examApplication extends BaseEntity{

	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp dateOfAppl=Timestamp.valueOf(LocalDateTime.now());
	
//	@Enumerated(EnumType.STRING)
//	private examType examType;

	
	
	@OneToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	@OneToOne
	@JoinColumn(name="payment_id", nullable = false)
	private Payment payment;
}
