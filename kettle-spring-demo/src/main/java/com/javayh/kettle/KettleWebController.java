package com.javayh.kettle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KettleWebController {

    @GetMapping("/kettle")
    public String kettleWebPage() {
        return "redirect:/kettle/index.html";
    }
}