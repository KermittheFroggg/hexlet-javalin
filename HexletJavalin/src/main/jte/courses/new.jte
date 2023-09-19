@template.layout.page(
content = @`
<form action="/courses" method="post">
    <div>
        <label>
            Название
            <input type="text" name="name" />
        </label>
    </div>
    <div>
        <label>
            Описание
            <input type="description" required name="description" />
        </label>
    </div>
    <input type="submit" value="Добавить" />
</form>
`
)