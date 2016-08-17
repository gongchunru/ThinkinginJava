package com.java.improve.Patterns.abstractDocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public interface Document  {

    Void put(String key, Object value);

    Object get(String key);

    <T> Stream<T> children(String key, Function<Map<String,Object>,T> constructor);
}
