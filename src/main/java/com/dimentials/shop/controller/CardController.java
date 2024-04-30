package com.dimentials.shop.controller;

import com.dimentials.shop.common.container.CardIoC;
import com.dimentials.shop.domain.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addMonster(@RequestParam Integer id,@RequestParam String name,@RequestParam String description,@RequestParam BigDecimal price,@RequestParam String imgPath,@RequestParam Integer atack,@RequestParam Integer life,@RequestParam String mainType,@RequestParam String secondaryType, model Model) {
        Monster monster = new Monster(id,name,description,price,imgPath,atack,life,mainType,secondaryType);
        model.addAttribute("monster", cardService.addMonster(monster));
        return "redirect:/cards";
    }
    @PostMapping("/new-card/add/spell")
    public String addSpell(@RequestParam Integer id,@RequestParam String name,@RequestParam String description,@RequestParam BigDecimal price,@RequestParam String imgPath,@RequestParam String mana, model Model) {
        Spell spell = new Spell(id,name,description,price,imgPath,effect,mainType,secondaryType);
        model.addAttribute("card", card);
        cardService.addSpell(card);
        return "redirect:/cards";
    }
}
