package com.java.improve.Patterns.abstractDocument.domain;

import com.java.improve.Patterns.abstractDocument.Document;

import java.util.Optional;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public interface HasPrice extends Document {
    String PROPERTY = "type";
    default Optional<Number> getPrice(){
        return Optional.ofNullable((Number)get(PROPERTY));
    }
}
