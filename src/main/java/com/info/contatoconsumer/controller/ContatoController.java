package com.info.contatoconsumer.controller;


import com.info.contatoconsumer.model.Contato;
import com.info.contatoconsumer.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/new")
    public String newContato(Model model){
        model.addAttribute("contato", new Contato());
        return "contato/form";
    }

    @GetMapping("")
    public String listContato(Model model){
        model.addAttribute("listContato", contatoService.findAll());
        return "contato/list";
    }

    @GetMapping("/{id}/edit")
    public String editContato(@PathVariable("id") Integer id, Model model){
        model.addAttribute("contato", contatoService.findById(id));
        return "redirect:/contato";
    }

    @GetMapping("/{id}/delete")
    public String deleteContato(@PathVariable("id") Integer id){
        contatoService.delete(id);
        return "redirect:/contato";
    }
}
