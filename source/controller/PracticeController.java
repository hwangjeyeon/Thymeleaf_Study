package hello.thymeleaf.practice;


import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Practice")
public class PracticeController {


    @GetMapping("/text-practice")
    public String textPractice(Model model){
        model.addAttribute("data", "Hi! My name is Hwang JeYeon");
        return "Practice/text-practice";
    }

    @GetMapping("/unescaped-practice")
    public String UnescapedPractice(Model model){
        model.addAttribute("data", "Hi! My name is <b>Hwang JeYeon</b>");
        return "Practice/unescaped-practice";
    }

    @GetMapping("/variableEL")
    public String VariableEL(Model model){
        User user1 = new User("Hwang", 10);
        User user2 = new User("Yang", 20);

        List<User> list= new ArrayList<>();
        list.add(user1);
        list.add(user2);

        Map<String, User> map = new HashMap<>();
        map.put("user1", user1);
        map.put("user2", user2);

        model.addAttribute("user", user1);
        model.addAttribute("ALLs", list);
        model.addAttribute("ALL", map);

        return "Practice/variableEL";
    }

    @Data
    static class User {
        private String username;
        private int age;
        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    @GetMapping("/date")
    public String date(Model model){
        model.addAttribute("DateTime", LocalDateTime.now());
        return "Practice/date";
    }

    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello " + data;
        }
    }

    @GetMapping("/links-practice")
    public String links(Model model){
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "Practice/links-practice";
    }

    @GetMapping("/literal-practice")
    public String literal(Model model){
        model.addAttribute("data", "HJY");
        return "Practice/literal";
    }


    @GetMapping("/operate-practice")
    public String operate(Model model){
        model.addAttribute("nullPractice", null);
        model.addAttribute("data", "Hwang");
        return "Practice/operate";
    }

    @GetMapping("/attribute")
    public String attribute(Model model){
        return "/Practice/attribute";
    }

    @GetMapping("/repeat")
    public String repeat(Model model){
        tempUsers(model);
        return "/Practice/repeat";
    }


    private void tempUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("user1", 17));
        list.add(new User("user2", 27));
        list.add(new User("user3", 37));
        model.addAttribute("users", list);
    }


    @GetMapping("/conditions")
    public String conditions(Model model){
        tempUsers(model);
        return "Practice/conditions";
    }


    @GetMapping("/js")
    public String js(Model model){
        model.addAttribute("user", new User("user1", 20));
        tempUsers(model);

        return "Practice/js";
    }


}
