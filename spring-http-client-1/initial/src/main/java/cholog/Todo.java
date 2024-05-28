package cholog;

public class Todo {

    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;

    public Todo() {
    }

    public Todo(Long userId, Long id, String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }
}
