package com.nimda.nimda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NimdaController {

    @GetMapping("/")
    String hello() {
        return "index.html";
    }

}

// novto commit test