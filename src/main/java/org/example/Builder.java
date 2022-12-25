package org.example;

public interface Builder<T> {
//    final private T type;
    T getResult(int id) throws Exception;
}