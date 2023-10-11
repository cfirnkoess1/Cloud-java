package edu.shadsluiter.products.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.shadsluiter.products.data.OrdersDataService;
import edu.shadsluiter.products.models.OrderModel;

import org.springframework.web.bind.annotation.PostMapping; 


@Controller
@RequestMapping("/orders")
public class OrdersController {
    
    // add a data member for the repository using dependency injection
    @Autowired
    private OrdersDataService ordersDataService;

    // use constructor injection to inject the repository
    public OrdersController(OrdersDataService ordersDataService) {
        this.ordersDataService = ordersDataService;
    }
    
    // now the methods to handel the request endpoints...

    @GetMapping("")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", ordersDataService.getAll());
        model.addAttribute("title", "All Orders");
        return "allOrders";
    }

    // get one item
    @GetMapping("/showOrder/{id}")
    public String showOneOrder(@PathVariable("id") int id, Model model ) {
        
        model.addAttribute("order", ordersDataService.getById(id));
        model.addAttribute("title", "One Order");

        return "oneOrder";
    }   

     // show edit form
     @GetMapping("/editOrder/{id}")
     public String editOrder(@PathVariable("id") int id, Model model) {
         model.addAttribute("order", ordersDataService.getById(id));
         model.addAttribute("title", "Edit Order");
 
         return "editOrder";
     }

     @PostMapping("/processEditOrder")
     public String doUpdate(OrderModel orderModel, BindingResult br, Model model) {  
             ordersDataService.update(orderModel);
             return "redirect:/orders";
     }

    // show new form
    @GetMapping("/newOrder")
    public String newOrder(Model model) {
        model.addAttribute("order", new OrderModel());
        model.addAttribute("title", "New Order");

        return "newOrder";
    }

    // process new
    @PostMapping("/processNewOrder")
    public String processNewOrder(@Valid OrderModel orderModel, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("title", "New Order");
            return "newOrder";
        }
        ordersDataService.create(orderModel);
        return "redirect:/orders";
    }


    // delete
    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id, Model model) {
        ordersDataService.deleteById(id);
        return "redirect:/orders";
    }

}
