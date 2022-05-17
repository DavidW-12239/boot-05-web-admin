package com.example.admin.mapper;

import com.example.admin.bean.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface EmpMapper {

    @Select("select * from t_emp where id = #{id}")
    public Emp getEmpById(Integer id);

    @Insert("insert into t_emp(`id`, `emp_name`, `age`, `sex`) values(#{id}, #{emp_name}, #{age}, #{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertEmp(Emp emp);
}
