package kz.raskaliyev.locationsystem.controller;

import kz.raskaliyev.locationsystem.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
  
  @GetMapping("/hello")
  public String sayHello() {
    return "hello";
  }
  
  // Other handlers
  
}
