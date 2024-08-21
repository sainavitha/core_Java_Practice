package com.navitha.HibernateDemo1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//java beans/pojo-->
public class Empinfo {
@Id
private int eid;
private String ename;
private int age;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
}
