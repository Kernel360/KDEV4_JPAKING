package com.example.rest_api.model;

//RequestBody로 사용자의 이름, 전화번호, 이메일을 받는 POST Method 만들기

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String userName;

    private Integer userAge;

    private String email;

    private Boolean isKorean; // is_korean

}