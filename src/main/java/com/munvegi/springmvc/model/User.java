package com.munvegi.springmvc.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Domain Objects. Objects from the business specific area that represent something meaningful to the domain expert.
// Domain objects are mostly represented by entities and value objects. Generaly speaking,
// most objects that live in domain layer contribute to the model and are domain objects.
//
//Entity. An object fundamentally defined not by its attributes, but by a thread of continuity and identity.
// (Meaning it must have Id)

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false)
	private String name;

	// Salary might go after age
	@Column(name = "SALARY", nullable = false)
	private BigDecimal salary;

	@Column(name = "AGE", nullable = false)
	private int age;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Phone> phones;



	public User(){
		id=0;
	}

	public User(int id, String name, int age, BigDecimal salary){
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public User(int id, String name, int age, BigDecimal salary, List<Phone> phones){
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.phones = phones;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public void addPhone(Phone phone) {
		if (this.phones == null) this.phones = new ArrayList<Phone>();
		this.phones.add(phone);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result = (prime * result) + (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
        return id == other.id;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}


}
