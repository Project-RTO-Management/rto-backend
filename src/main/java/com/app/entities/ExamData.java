package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="examData")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExamData extends BaseEntity{
@Column(length=250, unique=true,nullable=false)
private String questions;
@Column(length=50,nullable = false)
private String optA;
@Column(length=50,nullable = false)
private String optB;
@Column(length=50,nullable = false)
private String optC;
@Column(length=50,nullable = false)
private String optD;
@Enumerated(EnumType.STRING)
private Answer correctAns;

//@ManyToMany(mappedBy = "answer_id")
//private Set<Answer> answer = new HashSet<Answer>();
@OneToOne
@JoinColumn(name="userans_id",nullable = false)
private UserAnswer userans;

}
