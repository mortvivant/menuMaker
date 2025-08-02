package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateMainCourseRequest;
import com.example.menumaker.business.responses.GetAllMainCoursesResponse;
import com.example.menumaker.business.responses.GetRandomMainCourseResponse;

import java.util.List;

public interface MainCourseService {
    void addMainCourse(CreateMainCourseRequest createMainCourse);
    List<GetAllMainCoursesResponse> getAllMainCourse();
    GetRandomMainCourseResponse getMainCourse();
}
