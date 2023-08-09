package hello.thymeleaf.practice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragment")
public class FragmentController {



    @GetMapping("/fragment")
    public String template(){
        return "fragment/fragments";
    }


    @GetMapping("/layout")
    public String layouts(){
        return "fragment/layouts";
    }


}
