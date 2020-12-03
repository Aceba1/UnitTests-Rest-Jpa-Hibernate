package com.careerdevs.restjpahibernate.controller;

import com.careerdevs.restjpahibernate.model.User;
import com.careerdevs.restjpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api") // OPTIONAL
public class UserController {

  public static final int DEFAULT_SIZE = 30;

  @Autowired
  UserService service;

  @GetMapping("/users")
  public Object getUserPage(
    @RequestParam(/*required = false,*/defaultValue = "0") Integer page,
    @RequestParam(/*required = false,*/defaultValue = "30") Integer size
  ) {
//    int _page = page != null ? page : 0;
//    int _size = size != null ? size : DEFAULT_SIZE;

    Page<User> getPage = service.findAll(page, size);

    Map<String, Object> map = new HashMap<>();
    map.put("content", getPage.getContent());
    map.put("page", page);
    map.put("size", size);
    map.put("totalPages", getPage.getTotalPages());
    map.put("totalItems", getPage.getTotalElements());

    return map;
  }

  @PostMapping("/user")
  public Object postUser(
    @RequestBody User user
  ) {
    return service.save(user).strip();
  }

}
