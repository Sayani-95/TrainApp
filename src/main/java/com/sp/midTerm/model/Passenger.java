package com.sp.midTerm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="passenger")
public class Passenger {
    @Id
    @Column(name="passenger_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String age;
    private String email;

    public Passenger() {
    }

    public Passenger(String name, String gender, String age, String email) {
        this.name = name;
        this.gender = gender;
        this.age =age;
        this.email = email;
    }

    public Passenger(Long id, String name, String gender, String age, String email) {
        this.id = id;
    	this.name = name;
        this.gender = gender;
        this.age =age;
        this.email = email;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

   
}
