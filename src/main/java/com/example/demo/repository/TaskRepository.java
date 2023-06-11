package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> getByName(String name);

    @Query("SELECT t FROM Task t WHERE t.name = :name")
   List<String> getByName2(@Param("name") String name);

}
