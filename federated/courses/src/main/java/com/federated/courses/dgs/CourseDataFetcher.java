package com.federated.courses.dgs;

import com.federated.courses.entity.Course;
import com.federated.courses.entity.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class CourseDataFetcher {

    private List<Course> courses = new ArrayList<>();
    public CourseDataFetcher() {
        courses.add(new Course(new BigInteger("1"), "course1", "course1", new BigInteger("100"), new User(new BigInteger("1"))));
        courses.add(new Course(new BigInteger("2"), "course2", "course2", new BigInteger("200"), new User(new BigInteger("2"))));
        courses.add(new Course(new BigInteger("3"), "course3", "course3", new BigInteger("300"), new User(new BigInteger("3"))));
    }

    @DgsQuery
    public List<Course> getCourses() {
        return courses;
    }
}
