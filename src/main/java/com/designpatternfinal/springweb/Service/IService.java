package com.designpatternfinal.springweb.Service;

public interface IService<T> {
    public void saveOrUpdate(T t);
}
