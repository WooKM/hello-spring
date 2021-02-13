package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // MVC 예제
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 예제
    @GetMapping("hello-string")
    @ResponseBody // Http의 body 부분에 이 data를 직접 넣겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // "hello (내가 입력한 name)"
    }

    @GetMapping("hello-api")
    @ResponseBody
    // Hello라는 객체를 생성
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // ctrl + shift + enter 하면 자동적으로 코드 완성을 해줌
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
