package com.example.cdek_test.mapper;

import com.example.cdek_test.domain.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TasksMapper {

    @Select("select * from tasks")
    List<Task> findAll();

    @Select("select * from tasks where number=#{number}")
    List<Task> findByNumber(String number);

    @Insert("insert into tasks(number, date, checked) values(#{number},#{date},#{checked})")
    void insert(Task task);

    @Insert("update tasks set checked = true where id=#{id}")
    void setChecked(Integer id);
}
