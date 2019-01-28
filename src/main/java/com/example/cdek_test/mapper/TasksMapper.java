package com.example.cdek_test.mapper;

import com.example.cdek_test.domain.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TasksMapper {

    @Select("select * from tasks order by checked")
    List<Task> findAll();

    @Select("select * from tasks where number = #{number} order by checked")
    List<Task> findByNumber(String number);

    @Select("select not exists (select 1 from tasks where number = #{number} and checked = false)")
    boolean isCanAdd(String number);

    @Insert("insert into tasks(number, date, checked) values(#{number}, #{date}, #{checked})")
    void addNew(Task task);

    @Update("update tasks set checked = true where id = #{id}")
    void setChecked(Integer id);
}
