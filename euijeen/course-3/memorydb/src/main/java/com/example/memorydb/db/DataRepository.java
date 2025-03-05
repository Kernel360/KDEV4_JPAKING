package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, Id>  extends Repository<T, Id> {

    //create, update
    T save(T data);


    //read
    Optional<T>  findById(Id Id);


    List<T> findAll();


    //delete
    void delete(Id Id);


}
