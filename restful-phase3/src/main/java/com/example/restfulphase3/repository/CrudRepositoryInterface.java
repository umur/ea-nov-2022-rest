package com.example.restfulphase3.repository;

import com.example.restfulphase3.entity.Identifiable;

import java.util.ArrayList;
import java.util.Optional;

public interface CrudRepositoryInterface<T extends Identifiable> {

    public ArrayList<T> getAll();
    public Optional<T> get(String id);
    public Boolean create(T course);
    public Boolean delete(String id);
    public Boolean update(T course);
}
