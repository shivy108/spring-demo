package com.example.demo.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.web.model.Todo;
import com.example.demo.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUser(model);
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	private String getLoggedInUser(ModelMap model) {
		return (String) model.get("name");
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUser(model), "", new Date(), false));
		return "add-todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "add-todo";
		}

		service.addTodo(getLoggedInUser(model), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(ModelMap model, @RequestParam int id) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "add-todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		todo.setUser(getLoggedInUser(model));
		if (result.hasErrors()) {
			return "add-todo";
		}

		service.updateTodo(todo);
		return "redirect:/list-todos";
	}

}
