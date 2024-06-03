package com.dimentials.shop.controller;

import com.dimentials.shop.common.container.CardIoC;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.domain.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new-monster")
    public String newMonster(Model model) {
        model.addAttribute("monster", new Monster());
        return "newMonsterForm";
    }

    @PostMapping("/new-monster")
    public String addMonster(@RequestParam String name, @RequestParam String description_es, @RequestParam String description_en, @RequestParam String price,
            @RequestParam String imgPath, @RequestParam String attack, @RequestParam String life,
            @RequestParam String mainType_es, @RequestParam String mainType_en, @RequestParam(required = false) String secondaryType_es, @RequestParam(required = false) String secondaryType_en, Model model) {
        Monster monster = new Monster(null, name, description_es, description_en, new BigDecimal(price), imgPath, Integer.parseInt(attack),
                Integer.parseInt(life), mainType_es, mainType_en, secondaryType_es, secondaryType_en);
        cardService.addMonster(monster);
        return "redirect:/cards";
    }

    @GetMapping("/new-spell")
    public String newSpell(Model model) {
        model.addAttribute("spell", new Spell());
        return "newSpellForm";
    }

    @PostMapping("/new-spell")
    public String addSpell(@RequestParam String name, @RequestParam String description, @RequestParam String price,
            @RequestParam String imgPath, @RequestParam String mana, Model model) {
        Spell spell = new Spell(null, name, description, new BigDecimal(price), imgPath, Integer.parseInt(mana));
        cardService.addSpell(spell);
        return "redirect:/cards";
    }

    @GetMapping("/card-deletion")
    public String deleteCardForm(Model model) {
        model.addAttribute("card", new Monster());
        return "deleteCardForm";
    }

    @DeleteMapping("/card-deletion")
    public String deleteCard(@RequestParam int id, Model model) {
        cardService.deleteCard(id);
        return "redirect:/cards";
    }

    @GetMapping("/update-spell")
    public String updateSpell(Model model) {
        model.addAttribute("spell", new Spell());
        return "updateSpellForm";
    }


    @PutMapping("/update-spell")
    public String updateSpell(@RequestParam Integer id,@RequestParam String name,@RequestParam String description,@RequestParam BigDecimal price,@RequestParam String imgPath,@RequestParam Integer mana, Model model) {
        Spell spell = new Spell(id,name,description,price,imgPath,mana);
        cardService.updateSpell(spell);
        return "redirect:/cards";
    }


    @GetMapping("/update-monster")
    public String updateMonster(Model model) {
        model.addAttribute("monster", new Monster());
        return "updateMonsterForm";
    }

    @PutMapping("/update-monster")
    public String updateMonster(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam BigDecimal price, @RequestParam String imgPath, @RequestParam Integer attack, @RequestParam Integer life, @RequestParam String mainType, @RequestParam String secondaryType, Model model) {
        Monster monster = new Monster(id,name,description,price,imgPath,attack,life,mainType,secondaryType);
        cardService.updateMonster(monster);
        return "redirect:/cards";
    }
}
