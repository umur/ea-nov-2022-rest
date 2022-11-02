package com.example.restfulphase1.controller;


import com.example.restfulphase1.entity.Identifiable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


public interface CrudControllerInterface<T extends Identifiable> {


    public ResponseEntity<List<T>> getAll();
    public ResponseEntity<T> get(@PathVariable String id);
    public ResponseEntity<Boolean> create(@RequestBody T data);
    public ResponseEntity<Boolean> delete(@PathVariable String id);
    public ResponseEntity<Boolean> update(@RequestBody T data);
}
