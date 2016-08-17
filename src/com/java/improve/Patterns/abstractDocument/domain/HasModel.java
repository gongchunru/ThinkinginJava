package com.java.improve.Patterns.abstractDocument.domain;

import com.java.improve.Patterns.abstractDocument.Document;

import java.util.Optional;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public interface HasModel extends Document {
    String PROPERTY = "model";
    default Optional<String> getModel(){
        return Optional.ofNullable((String)get(PROPERTY));
    }
}
