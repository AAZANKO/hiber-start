package com.matveyenka.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
}
