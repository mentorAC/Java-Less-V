package com.ExtraShop.Shop.controllers;

import org.springframework.web.bind.annotation.*;

@RestController()
public class TestController {

    //HTTP_METHODS
    //GET
    //POST
    //PUT
    //DELETE
    @PostMapping("/test/get-data")
    public String getDataPost(){
        return "Hello, I am a POST Method";
    }
    @GetMapping("/test/get-data")
    public String getDataGet(){
        return "Hello, I am a GET Method";
    }
    @PutMapping("/test/get-data")
    public String getDataPut(){
        return "Hello, I am a PUT Method";
    }
    @DeleteMapping("/test/get-data")
    public String getDataDelete(){
        return "Hello, I am a DELETE Method";
    }
}
