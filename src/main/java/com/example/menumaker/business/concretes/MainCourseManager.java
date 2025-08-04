package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.MainCourseService;
import com.example.menumaker.business.requests.CreateMainCourseRequest;
import com.example.menumaker.business.responses.GetAllMainCoursesResponse;
import com.example.menumaker.business.responses.GetRandomMainCourseResponse;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.MainCourseRepository;
import com.example.menumaker.entities.concretes.MainCourse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class MainCourseManager implements MainCourseService {

    private MainCourseRepository mainCourseRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void addMainCourse(CreateMainCourseRequest createMainCourse) {
        MainCourse newMaincourse = this.modelMapperService.forRequest().map(createMainCourse,MainCourse.class);
        this.mainCourseRepository.save(newMaincourse);
    }

    @Override
    public List<GetAllMainCoursesResponse> getAllMainCourse() {
        List<MainCourse> mainCourses = this.mainCourseRepository.findAll();
        List<GetAllMainCoursesResponse> mainCoursesResponses = mainCourses.stream().map(mainCourse ->
                this.modelMapperService.forResponse().map(mainCourse,GetAllMainCoursesResponse.class)).toList();

        return mainCoursesResponses;
    }

    @Override
    public GetRandomMainCourseResponse getMainCourse(){
        List<MainCourse> mainCourses = mainCourseRepository.findAll();
        Random random = new Random();
        int number = random.nextInt(mainCourses.size());
        MainCourse mainCourse = mainCourses.get(number);
        GetRandomMainCourseResponse mainCourseResponse = this.modelMapperService.forResponse().map(mainCourse,GetRandomMainCourseResponse.class);
        return mainCourseResponse;
    }
}
