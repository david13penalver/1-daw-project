package com.dimentials.shop.controller;

import com.dimentials.shop.common.container.CardIoC;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.domain.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.math.BigDecimal;

@Controller
@RequestMapping("/cards")
public class CardController {

    private CardService cardService;

    public CardController() {
        this.cardService = CardIoC.getCardService();
    }


    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("cardList", cardService.findAll());
        return "cardList";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        model.addAttribute("cardDetail", cardService.findById(id));
        return "cardDetail";
    }
    @GetMapping("/new-card")
    public String newCard() {
        return "newCardForm";
    }
    @PostMapping("/new-card/add/monster")
    public String addMonster(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam BigDecimal price, @RequestParam String imgPath, @RequestParam Integer atack, @RequestParam Integer life, @RequestParam String mainType, @RequestParam String secondaryType, Model model) {
        Monster monster = new Monster(id,name,description,price,imgPath,atack,life,mainType,secondaryType);
        model.addAttribute("monster", cardService.addMonster(monster));
        return "redirect:/cards";
    }
    @PostMapping("/new-card/add/spell")
    public String addSpell(@RequestParam Integer id,@RequestParam String name,@RequestParam String description,@RequestParam BigDecimal price,@RequestParam String imgPath,@RequestParam Integer mana, Model model) {
        Spell spell = new Spell(id,name,description,price,imgPath,mana);
        model.addAttribute("card", cardService.addSpell(spell));
        return "redirect:/cards";
    }
    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Integer id, Model model) {
        model.addAttribute("cardDetail",cardService.deleteCard(id));    
        return "redirect:/cards";
    }

    @PutMapping("/{id}")
    public String updateSpell(@RequestParam Integer id,@RequestParam String name,@RequestParam String description,@RequestParam BigDecimal price,@RequestParam String imgPath,@RequestParam Integer mana, Model model) {
        Spell spell = new Spell(id,name,description,price,imgPath,mana);
        model.addAttribute("card", cardService.updateSpell(spell));
        return "redirect:/cards";
    }

    @PutMapping("/{id}")
    public String updateMonster(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam BigDecimal price, @RequestParam String imgPath, @RequestParam Integer atack, @RequestParam Integer life, @RequestParam String mainType, @RequestParam String secondaryType, Model model) {
        Monster monster = new Monster(id,name,description,price,imgPath,atack,life,mainType,secondaryType);
        model.addAttribute("monster", cardService.updateMonster(monster));
        return "redirect:/cards";
    }
}
