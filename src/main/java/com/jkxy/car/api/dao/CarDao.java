package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CarDao {
    @Select("select * from carMessage")
    List<Car> findAll();

    @Select("select * from carMessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carMessage where carName = #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carMessage where id = #{id}")
    void deleteById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries},inventory=#{inventory} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries,inventory) values(#{carName},#{carType},#{price},#{carSeries},#{inventory})")
    void insertCar(Car car);

//    #{}内填的是形参
    @Update("update carMessage set inventory= inventory - #{num} where id = #{id}")
    void buyCarById(int id, int num);

//    @Select("select * from carMessage where carName=#{carName} limit (#{pageNumber}-1)*#{numPerPage},#{numPerPage}")
    @Select("select * from carMessage where carName=#{carName} limit #{pageSize} offset #{offset}")
    List<Car> fuzzyFindByCarName(String carName, int pageSize, int offset);
}
