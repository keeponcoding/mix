package com.cll.mix.kafka.entity;/**
 * Created by pc on 2019/7/6 9:35
 */

/**
 *@ClassName : StudentEntity
 *@Description : 学生实体
 *@Author : pc
 *@Date : 2019/7/6 9:35
 *@Version : 1.0
 **/
public class StudentEntity {

    private String name;
    private Integer age;

    public StudentEntity() {
    }

    public StudentEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
