package org.ua.javaPro.berezhnoy.hillelHomeWork23Rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class RestControllerExample {
    private final HeroService heroService;

    @GetMapping("/heroes")
    public List<HeroDto> getHeroes() {
        return heroService.findAll();
    }

    @GetMapping("/heroes/{id}")
    public HeroDto getHero(@PathVariable("id") Long id) {
        List<HeroDto> heroes = heroService.findById(id);
        if (getHeroes().isEmpty()) {
            throw new RuntimeException("hero not found");
        }
        return heroes.get(0);
    }

    @PostMapping("/heroes")
    public HeroDto createHero(@RequestBody HeroDto heroDto) {
        return heroService.createHero(heroDto.toEntity());
    }

    @PutMapping("/heroes/{id}")
    public HeroDto updateHero(@PathVariable("id") Long id, @RequestBody HeroDto updateDto) {
        HeroDto existingHero = getHero(id);
        Hero updatedHero = updateDto.toEntity();
        updatedHero.setId(existingHero.id());
        heroService.updateHero(updatedHero);
        return getHero(id);
    }


    @DeleteMapping("/heroes/{id}")
    public HeroDto deleteHero(@PathVariable("id") Long id) {
        HeroDto deletedHero = getHero(id);
        heroService.deleteHero(id);
        System.out.println("delete hero " + id);
        return deletedHero;
    }

}

