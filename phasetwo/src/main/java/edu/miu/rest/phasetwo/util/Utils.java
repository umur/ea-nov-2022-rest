package edu.miu.rest.phasetwo.util;

import org.springframework.beans.BeanUtils;

/**
 * Author: Kuylim TITH
 * Date: 11/2/2022
 */
public class Utils {

    public static <T,R> R entityToDto(T entity, R dto) {
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static <T,R> R dtoToEntity(T dto, R entity) {
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
