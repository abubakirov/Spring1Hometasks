package lesson02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example")
public class NewIndexController {

    @GetMapping("/hello")
    public String hello(Model uiModel) {
        uiModel.addAttribute("message", "Hello, World!");
        return "index";
    }

    @GetMapping("/bye")
    public String bye(Model uiModel) {
        uiModel.addAttribute("message", "Bye, World!");
        return "index";
    }

    @GetMapping("hello/{name}")
    public String helloName(Model uiModel, @PathVariable String name) {
        uiModel.addAttribute("message", "Hello, " + name + "!");
        return "index";
    }
}
