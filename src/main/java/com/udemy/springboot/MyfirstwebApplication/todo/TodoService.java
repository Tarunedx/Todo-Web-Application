package com.udemy.springboot.MyfirstwebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount=0;
	static {
		todos.add(new Todo(todoCount++,"udemy","learn AWS",
							LocalDate.now().plusYears(1),false));
		todos.add(new Todo(todoCount++,"udemy","learn Azure",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(todoCount++,"udemy","learn GCP",
				LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate 
		= todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
		
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone ) {
		Todo todo = new Todo(todoCount++,username,description,
				targetDate,false);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate 
			= todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
	
	public void udpateTodo(Todo todo) {
		
		deleteTodo(todo.getId());
		todos.add(todo);
	}

	public static Todo findbyId(int id) {
		
		Predicate<? super Todo> predicate 
		= todo -> todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		System.out.println(todo.getDescription());
		return todo;
		
	}

}
