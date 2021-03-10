package com.review.helloworld.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.Set;


@ConfigurationProperties(prefix = "person")
@Component
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String userName;
    private boolean boss;
    private Data birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String,Object> score;
    private Set<Double> salarys;
    private Map<String,List<Pet>> allPets;

}
