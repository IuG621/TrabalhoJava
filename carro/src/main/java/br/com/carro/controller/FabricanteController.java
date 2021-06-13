package br.com.carro.controller;


import br.com.carro.model.Fabricante;
import br.com.carro.repository.FabricanteRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FabricanteController {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @GetMapping("/gerenciarFabricantes")
    public String listarFabricante(Model model) {
        model.addAttribute("listaFabricantes", fabricanteRepository.findAll());
        return "gerenciar_fabricantes";
    }

    @GetMapping("/novoFabricante")
    public String novoFabricante(Model model) {
        model.addAttribute("fabricante", new Fabricante());
        return "editar_fabricante";
    }

    @GetMapping("/editarFabricante/{id}")
    public String editarFabricante(@PathVariable("id") long idFabricante, Model model) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(idFabricante);
        model.addAttribute("fabricante", fabricante.get());
        return "editar_fabricante";
    }

    @PostMapping("/salvarFabricante")
    public String salvarFabricante(Fabricante fabricante, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_fabricante";
        }
        fabricanteRepository.save(fabricante);
        return "redirect:/gerenciarFabricantes";
    }

    @GetMapping("/excluirFabricante/{id}")
    public String excluirFabricante(@PathVariable("id") long idFabricante) {
        fabricanteRepository.deleteById(idFabricante);
        return "redirect:/gerenciarFabricantes";
    }
}
