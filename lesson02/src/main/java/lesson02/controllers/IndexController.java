package lesson02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model uiModel) {
        uiModel.addAttribute("message", "My message plus random UUID -> " + UUID.randomUUID());
        return "index";
    }
}
