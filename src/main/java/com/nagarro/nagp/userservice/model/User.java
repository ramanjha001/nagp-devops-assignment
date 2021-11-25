package com.nagarro.nagp.userservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2326171997103401269L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private Integer salary;
    private String teamName;
}
