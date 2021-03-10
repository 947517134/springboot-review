package com.review.helloworld.pojo;

import lombok.*;

/**
 * 用户
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;


}
