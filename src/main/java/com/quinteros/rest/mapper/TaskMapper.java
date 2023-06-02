package com.quinteros.rest.mapper;


import com.quinteros.rest.persistence.entity.Task;
import com.quinteros.rest.service.dto.TaskInDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//Mapper
@Mapper
public interface TaskMapper{
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);


    TaskInDto taskToTaskInDto(Task task);


    Task taskInDtoToTask(TaskInDto taskInDto);


}
