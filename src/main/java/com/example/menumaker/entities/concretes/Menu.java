package com.example.menumaker.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "soup_id")
    private Soup soup;

    @ManyToOne
    @JoinColumn(name = "maincourse_id")
    private MainCourse mainCourse;

    @ManyToOne
    @JoinColumn(name = "dessert_id")
    private Dessert dessert;

    @ManyToOne
    @JoinColumn(name = "beverage_id")
    private Beverage beverage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
