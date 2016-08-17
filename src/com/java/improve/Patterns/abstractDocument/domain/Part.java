package com.java.improve.Patterns.abstractDocument.domain;

import com.java.improve.Patterns.abstractDocument.AbstractDocument;

import java.util.Map;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public class Part extends AbstractDocument implements HasModel,HasPrice,HasType {
        public Part(Map<String,Object> properties){
            super(properties);
        }
}
