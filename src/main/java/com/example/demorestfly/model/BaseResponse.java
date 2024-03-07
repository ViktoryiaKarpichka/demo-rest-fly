package com.example.demorestfly.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseResponse {

    private Integer status;
    private final LocalDate timestamp = LocalDate.now();
}
