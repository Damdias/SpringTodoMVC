package com.apress.todo.controller;

import com.apress.todo.domain.ToDo;
import com.apress.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@Controller
@RequestMapping("/todo")
public class ToDoController {
    private ToDoRepository repository;

    @Autowired
    public ToDoController(ToDoRepository repository){
        this.repository =repository;
    }

    @GetMapping
    public  ModelAndView index(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.addObject("message", "Hellos");
        modelAndView.setViewName("/Todo/index");

        return  modelAndView;
    }
    @GetMapping(value = "/db", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.TEXT_XML_VALUE})
    public ResponseEntity<Iterable<ToDo>> getToDos(@RequestHeader HttpHeaders headers){
        return new ResponseEntity<Iterable<ToDo>>(this.repository.findAll(),headers, HttpStatus.OK);
    }
}
