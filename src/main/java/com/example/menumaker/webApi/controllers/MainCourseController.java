package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.MainCourseService;
import com.example.menumaker.business.requests.CreateMainCourseRequest;
import com.example.menumaker.business.requests.UpdateMainCourseRequest;
import com.example.menumaker.business.responses.GetAllMainCoursesResponse;
import com.example.menumaker.business.responses.GetRandomMainCourseResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maincourses")
@AllArgsConstructor
public class MainCourseController {

    private MainCourseService mainCourseService;

    @GetMapping("/getmaincourses")
    public List<GetAllMainCoursesResponse> getAllMainCourses(){
        return mainCourseService.getAllMainCourse();
    }

    @GetMapping("/getmaincourse")
    public GetRandomMainCourseResponse getMainCourse(){
        return mainCourseService.getMainCourse();
    }

    @PostMapping("/addmaincourse")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMainCourse(CreateMainCourseRequest createMainCourseRequest){
        this.mainCourseService.addMainCourse(createMainCourseRequest);
    }

    @PutMapping("/updatemaincourse")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateMainCourse(UpdateMainCourseRequest updateMainCourseRequest){
        this.mainCourseService.updateMainCourse(updateMainCourseRequest);
    }
}
