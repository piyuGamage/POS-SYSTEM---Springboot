package edu.lk.ijse.Controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("hello")
@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "Get";
    }

    @PostMapping
    public String helloPost() {
        return "Post";
    }

    @PutMapping
    public String helloPut() {
        return "Put";
    }

    @DeleteMapping
    public String helloDelete() {
        return "Delete";
    }
    @PatchMapping
    public String helloPatch() {
        return "Patch";
    }
}
