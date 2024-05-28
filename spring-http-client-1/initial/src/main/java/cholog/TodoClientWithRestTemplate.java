package cholog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class TodoClientWithRestTemplate {
    private final RestTemplate restTemplate;

    public TodoClientWithRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Todo getTodoById(Long id) {
        String url = "http://jsonplaceholder.typicode.com/todos/";
        try {
            ResponseEntity<Todo> response = restTemplate.getForEntity(url + id, Todo.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new TodoException.NotFound(id);
            }
            throw new TodoException("Fail getTodoById by client");
        }
    }
}
