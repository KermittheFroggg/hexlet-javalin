package org.example.hexlet;

import io.javalin.http.NotFoundResponse;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });
        app.get("/courses/{id}", ctx -> {
            ctx.result("Course ID: " + ctx.pathParam("id"));
        });

        app.get("/courses/{courseId}/lessons/{id}", ctx -> {
            ctx.result("Course ID: " + ctx.pathParam("courseId"));
            ctx.result("Lesson ID: " + ctx.pathParam("id"));
        });
        app.get("/users/{id}/", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
        });
        app.get("/users/{id}/post/{postId}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
            ctx.result("Post ID: " + ctx.pathParam("postId"));
        });

        app.start(7070); // Стартуем веб-сервер
    }
}