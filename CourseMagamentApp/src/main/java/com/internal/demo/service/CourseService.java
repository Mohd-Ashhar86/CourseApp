package com.internal.demo.service;

import com.internal.demo.model.Course;
import com.internal.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
	 @Autowired
	    private CourseRepository repository;

	    public List<Course> getAllCourses() {
	        return repository.findAll();
	    }

	    public Course getCourseById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public List<Course> getCoursesByInstructor(String instructor) {
	        return repository.findByInstructor(instructor);
	    }

	    public Course addCourse(Course course) {
	        return repository.save(course);
	    }

	    public Course updateCourse(Long id, Course updatedCourse) {
	        Course course = repository.findById(id).orElse(null);
	        if (course != null) {
	            course.setName(updatedCourse.getName());
	            course.setDuration(updatedCourse.getDuration());
	            course.setInstructor(updatedCourse.getInstructor());
	            return repository.save(course);
	        }
	        return null;
	    }

	    public void deleteCourse(Long id) {
	        repository.deleteById(id);
	    }
	}
