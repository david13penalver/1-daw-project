package com.dimentials.shop.controller;

import com.dimentials.shop.common.container.OrderIoC;
import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.domain.entity.User;
import com.dimentials.shop.domain.service.OrderService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController() {
        this.orderService = OrderIoC.getOrderService();
    }

    @GetMapping
    public String findAllByUser(Model model) {
        User user = new com.dimentials.shop.domain.entity.User(1, "David", "Peñalver", "Navarro", "david13penalver@gmail.com", false, "Spain", "Aldaya", "Plaza Corts Valencianes", "8", "1", "1");
        List<Order> orderList = orderService.findByUserId(user.getUserId());
        model.addAttribute("orderList", orderList);
        return "orders/list";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable int id) {
        Order order = orderService.findById(id);

//        //Modificar el formato de fecha en función del idioma
//        Locale locale = LocaleContextHolder.getLocale();
//        // Obtener el patrón de formato de fecha según el idioma local
//        String dateFormatPattern = messageSource.getMessage("date.format", null, locale);
//        // Formatear las fechas de la orden según el patrón de formato obtenido
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormatPattern, locale);
//        String orderDateFormatted = order.getOrderDate().format(dateFormatter);
//        String deliveryDateFormatted = "";
//        if(order.getDeliveryDate() != null) {
//            deliveryDateFormatted = order.getDeliveryDate().format(dateFormatter);
//        }
//
//        // Agregar las fechas formateadas al modelo
//        model.addAttribute("orderDate", orderDateFormatted);
//        model.addAttribute("deliveryDate", deliveryDateFormatted);
        model.addAttribute("order", order);
        return "orders/detail";
    }
}
