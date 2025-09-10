package com.overflow.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "MC K");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "Hello " + name + "!";
    }

    /*
     * @ResponseBody 사용 시 HttpMessageConverter가 동작
     * 객체의 경우 기본적으로 JsonConverter가 동작 (Json으로 변환)
     * 문자열의 경우 기본적으로 StringConverter가 동작 (문자열로 변환)
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("age") byte age) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);

        return hello;
    }

    class Hello {
        private String name;
        private byte age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public byte getAge() {
            return age;
        }

        public void setAge(byte age) {
            this.age = age;
        }
    }
}