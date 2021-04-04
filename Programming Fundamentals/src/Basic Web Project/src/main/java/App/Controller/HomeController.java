package App.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/hello/test")
    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        List<String> names = Arrays.asList("Ivan", "Georgi", "Pesho");
        modelAndView.addObject("names", names);
        return modelAndView;
    }
}