package org.example.hexlet;

import java.util.Random;
import java.util.Locale;
import com.github.javafaker.Faker;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Collections;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import java.util.stream.LongStream;

public class Data {
    private static final int ITEMS_COUNT = 30;

    private static int idCounter = ITEMS_COUNT;

    public static List<Course> getCourses() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);


        List<Course> courses = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            Course course = new Course(faker.funnyName().name(), faker.witcher().witcher());
            course.setId(Long.valueOf(i));
            courses.add(course);
        }
        return courses;
    }
}
