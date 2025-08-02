package com.example.menumaker.dataAccess.abstracts;

import com.example.menumaker.entities.concretes.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainCourseRepository extends JpaRepository<MainCourse,Integer> {
}
