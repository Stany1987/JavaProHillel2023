package org.ua.javaPro.berezhnoy.hillelHomwWork26HeroMVC;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HeroExceptionHandler {
    @ExceptionHandler(HeroNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleHeroNotFoundException(HeroNotFoundException ex, Model model) {
        model.addAttribute("errorMassage", ex.getMessage());
        return "error";
    }

}
