package com.sparta.week2.service;

import com.sparta.week2.domain.Course;
import com.sparta.week2.domain.CourseRepository;
import com.sparta.week2.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    //courseRepository가 필요하다. 검색하거나 업데이트 하거나 등등...
    // final: 서비스에게 꼭 필요한 녀석임을 명시. 한번 값이 부여되면 변형될 수 없다. 내가 꼭 필요한 멤버변수다.
    private final CourseRepository courseRepository;

//    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
//    // 스프링에게 알려줌
//    public CourseService(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    } ->@RequiredArgsConstructor 으로 만들어준다.

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, CourseRequestDto requestDto) {
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
}