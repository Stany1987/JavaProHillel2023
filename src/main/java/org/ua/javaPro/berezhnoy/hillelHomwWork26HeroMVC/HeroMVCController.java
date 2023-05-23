package org.ua.javaPro.berezhnoy.hillelHomwWork26HeroMVC;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDto;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroService;

import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HeroMVCController {
    private final HeroService heroService;

    @GetMapping("")
    public String heroes(Model model) {
        model.addAttribute("name", "All Heroes");
        model.addAttribute("heroes", heroService.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String findHero(@PathVariable("id") Long id, Model model) {
        List<HeroDto> hero = heroService.findById(id);
        if (hero.isEmpty()) {
            throw new HeroNotFoundException("Hero not found " + id);
        }

        model.addAttribute("name", "Find hero by id");
        model.addAttribute("heroes", hero);
        return "index";
    }
}