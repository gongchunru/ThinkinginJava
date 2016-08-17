package com.java.improve.Patterns.abstractDocument.domain;

import com.java.improve.Patterns.abstractDocument.Document;

import java.util.Optional;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public interface HasType extends Document {
    String PROPERTY = "type";
    default Optional<String> getType(){
        return Optional.ofNullable((String) get(PROPERTY));
    }
}
