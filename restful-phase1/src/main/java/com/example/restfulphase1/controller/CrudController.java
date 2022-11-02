package com.example.restfulphase1.controller;

import com.example.restfulphase1.entity.Identifiable;
import com.example.restfulphase1.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CrudController<T extends Identifiable, S extends CrudService> implements CrudControllerInterface<T>{

    public final S service;

    @Override
    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        var result = service.getAll();
        return ResponseEntity.status(200).body(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable String id) {

        Optional<T> data = service.get(id);

        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody T data) {
        if (service.create(data)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        if (service.delete(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody T data) {
        if (service.update(data)) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
