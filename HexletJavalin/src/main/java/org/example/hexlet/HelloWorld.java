package org.example.hexlet;

import io.javalin.Javalin;

import java.util.Collections;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;

import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;

import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.repository.CourseRepository;


import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class HelloWorld {


    private static final List<Course> COURSES = CourseRepository.getEntities();
    private static final List<User> USERS = UserRepository.getEntities();

    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });


//        app.get("/courses/{id}", ctx -> {
//            var id = ctx.pathParam("id");
//            Course course = COURSES.stream()
//                    .filter(c -> c.getId().equals(Long.valueOf(id)))
//                    .findFirst()
//                    .orElse(null);
//            var page = new CoursePage(course);
//            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
//        });

        app.get("/courses", ctx -> {
            List<Course> courses = new ArrayList();
            String term = ctx.queryParam("term");
            if (term != null) {
                for (Course course : COURSES) {
                    if (course.getName().toLowerCase().startsWith(term.toLowerCase())) {
                        courses.add(course);
                    }
                }
            } else {
                courses = COURSES;
            }
            var page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });
        app.post("/courses", ctx -> {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        });
        app.get("/users/new", ctx -> {
            ctx.render("users/new.jte");
        });
        app.get("/courses/new", ctx -> {
            ctx.render("courses/new.jte");
        });
        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name");
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });
        app.get("/users", ctx -> {
            List<User> users = new ArrayList();
            String term = ctx.queryParam("term");
            if (term != null) {
                for (User user : USERS) {
                    if (user.getName().toLowerCase().startsWith(term.toLowerCase())) {
                        users.add(user);
                    }
                }
            } else {
                users = USERS;
            }
            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });


        app.start(7070);
    }
}