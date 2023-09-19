@import org.example.hexlet.dto.courses.CoursePage

@param CoursePage page

<html lang="en">

<!-- Для простоты упущена основная структура HTML -->
<body>
<main>
    <h1>${page.getCourse().getName()}</h1>
    <p>${page.getCourse().getDescription()}</p>
</main>
</body>
</html>