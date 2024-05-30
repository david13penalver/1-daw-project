package com.dimentials.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/cookies")
    public String cookies() {
        return "cookies";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }

    @GetMapping("/basic_concepts")
    public String basicConcepts() {
        return "basic_concepts";
    }

    @GetMapping("/basic_strategy")
    public String basicStrategy() {
        return "basic_strategy";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/gallery_cards")
    public String gallery() {
        return "galleryCards";
    }

    @GetMapping("/detail_cards")
    public String detailCards() {
        return "cardList";
    }

    @GetMapping("/shop")
    public String shop() {
        return "tienda";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/proximamente")
    public String proximamente() {
        return "proximamente";
    }

}
