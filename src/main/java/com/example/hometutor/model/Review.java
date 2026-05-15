//create a  package
package com.example.hometutor.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "review_type", discriminatorType = DiscriminatorType.STRING)
//create a class
public abstract class Review implements IdentifiableEntity {
  //attribute
  @Id
  private String id;

    @Column(nullable = false)
    private String tutorId;

    @Column(nullable = false)
    private String userId;

    private int rating;

    @Column(length = 1000)
    private String comment;

    //default constructor











}