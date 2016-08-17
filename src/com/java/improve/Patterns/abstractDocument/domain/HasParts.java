package com.java.improve.Patterns.abstractDocument.domain;

import com.java.improve.Patterns.abstractDocument.Document;

import java.util.stream.Stream;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public interface HasParts extends Document {
    String PROPERTY  = "parts";
    default Stream<Part> getParts(){
        return children(PROPERTY,Part::new);
    }
}
