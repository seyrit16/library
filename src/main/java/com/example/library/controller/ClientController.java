package com.example.library.controller;

import com.example.library.model.Client;
import com.example.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String listClients(Model model){
        model.addAttribute("clients",clientService.getAllClients());
        return "clients/list";
    }

    @GetMapping("/new")
    public String newClientForm(Model model){
        model.addAttribute("client",new Client());
        return "clients/form";
    }

    @PostMapping("/new")
    public String createClient(@ModelAttribute Client client){
        clientService.createClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "clients/form";
    }

    @PostMapping("/edit/{id}")
    public String updateClient(Client client){
        clientService.updateClient(client);
        return "redirect:/clients";
    }
}
