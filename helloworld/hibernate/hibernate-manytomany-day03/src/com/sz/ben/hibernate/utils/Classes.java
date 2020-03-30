package com.sz.ben.hibernate.utils;

import java.util.HashSet;
import java.util.Set;


/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes  implements java.io.Serializable {


    // Fields    

     private Long cid;
     private String name;
     private String description;
     private Set students = new HashSet(0);


    // Constructors

    /** default constructor */
    public Classes() {
    }

    
    /** full constructor */
    public Classes(String name, String description, Set students) {
        this.name = name;
        this.description = description;
        this.students = students;
    }

   
    // Property accessors

    public Long getCid() {
        return this.cid;
    }
    
    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Set getStudents() {
        return this.students;
    }
    
    public void setStudents(Set students) {
        this.students = students;
    }
   








}