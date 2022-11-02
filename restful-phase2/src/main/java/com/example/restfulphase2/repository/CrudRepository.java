package com.example.restfulphase2.repository;
import com.example.restfulphase2.entity.Identifiable;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
public class CrudRepository<T extends Identifiable> implements CrudRepositoryInterface<T> {

    public ArrayList<T> list;

    public ArrayList<T> getAll(){
        return list;
    }

    public Optional<T> get(String id){
        return list.stream().filter(course -> course.getId().equals(id)).findFirst();
    }

    public Boolean delete(String id){
        if (get(id).isPresent()){
            list.remove(get(id).get());
            return true;
        }else{
            return false;
        }
    }

    public Boolean update(T data){
        if (get(data.getId()).isPresent()){
            Integer index = list.indexOf(get(data.getId()).get());
            list.set(index, data);
            return true;
        }else{
            return false;
        }
    }

    public Boolean create(T data) {
        if (!get(data.getId()).isPresent()){
            list.add(data);
            return true;
        }else{
            return false;
        }

    }
}