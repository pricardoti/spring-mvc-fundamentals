package br.com.conference.controller;

import br.com.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("registration")
    public String getRegitration(@ModelAttribute("registration") Registration registration) {
        return "registration";
    }

    @GetMapping("message")
    public String getRegitrationMessage(
            @RequestParam(name = "param1", required = false) String param1,
            @RequestParam(name = "param2", required = false) String param2,
            Map<String, Object> model
    ) {
        if (!StringUtils.isEmpty(param1)) {
            model.put("message", param1 + " " + param2 + " registered successfully !!!");
        }
        return "message";
    }

    @PostMapping("registration")
    public String addRegitration(
            @Valid @ModelAttribute("registration") Registration registration,
            BindingResult result
    ) {
        System.out.println(">>> hasErrors :: " + result.hasErrors());
        if (result.hasErrors()) {
            return "registration";
        }

        System.out.println(">>> Add registration :: " + registration.getFirstName() + "" + registration.getLastName());
        return "redirect:/message?param1=" + registration.getFirstName() + "&param2=" + registration.getLastName();
    }
}
