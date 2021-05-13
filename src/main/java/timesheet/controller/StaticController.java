package timesheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StaticController {

    @GetMapping({"/Timesheet/"})
    public String index () {
        return "/Timesheet/index.html";
    }

    @GetMapping({"/", "/Timesheet"})
    public RedirectView redirectWithUsingRedirectView(
            RedirectAttributes attributes) {
        return new RedirectView("/Timesheet/");
    }

}
