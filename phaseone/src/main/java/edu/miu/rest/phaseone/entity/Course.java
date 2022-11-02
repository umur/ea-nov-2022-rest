package edu.miu.rest.phaseone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private Long id;
    private String name;
    private String code;
}
