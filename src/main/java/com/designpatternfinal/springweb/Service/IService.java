package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Order;

public abstract class IService<T> {
    abstract void saveOrUpdate(T t);
    abstract Iterable<T> getAll();
}
