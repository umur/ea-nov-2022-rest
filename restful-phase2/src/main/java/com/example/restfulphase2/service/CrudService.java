package com.example.restfulphase2.service;

import com.example.restfulphase2.entity.Identifiable;
import com.example.restfulphase2.repository.CrudRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
public class CrudService<T extends Identifiable, R extends CrudRepository<T>> implements CrudServiceInterface<T> {

    final R repository;

    public ArrayList<T> getAll(){
        return repository.getAll();
    }

    public Optional<T> get(String id){
        return repository.get(id);
    }

    public Boolean delete(String id){
        return repository.delete(id);
    }

    public Boolean update(T data){
        return repository.update(data);
    }

    public Boolean create(T data){
        return repository.create(data);
    }




}
