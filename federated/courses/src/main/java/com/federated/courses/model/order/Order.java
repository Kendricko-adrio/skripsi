package com.federated.courses.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.federated.courses.model.BaseEntity;
import com.federated.courses.model.Course;
import com.federated.courses.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends BaseEntity {
    private BigInteger id;

    private Course course;

//    private BigInteger studentId;
    private User student;

//    private BigInteger teacherId;
    private User teacher;

    private Boolean isActive;

    @JsonProperty("course_id")
    private void unpackNested(Integer course_id){
        this.course = new Course();
        course.setId(new BigInteger(String.valueOf(course_id)));
    }

    @JsonProperty("student_id")
    private void unpackNestedStudent(Integer student_id){
        this.student = new User();
        student.setId(new BigInteger(String.valueOf(student_id)));
    }

    @JsonProperty("teacher_id")
    private void unpackNestedTeacher(Integer teacher_id){
        this.teacher = new User();
        teacher.setId(new BigInteger(String.valueOf(teacher_id)));
    }

}
