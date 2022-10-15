package com.reto_3.modelo;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAdmin;
    private String email;
    private String password;
    private String name;

}
