package org.example.hexlet;

import io.javalin.Javalin;

import java.util.Collections;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import java.util.Map;
import java.util.List;

public class HelloWorld {

    private static final List<Course> COURSES = Data.getCourses();

    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });


        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            Course course = COURSES.stream()
                    .filter(c -> c.getId().equals(Long.valueOf(id)))
                    .findFirst()
                    .orElse(null);
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses", ctx -> {
            var courses = COURSES;
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });

        app.start(7070);
    }
}