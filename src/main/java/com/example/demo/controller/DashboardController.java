package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    /**
     * Redirige vers la page d'accueil principale.
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Accueil - Gestion Médicale");
        return "index";
    }

    /**
     * Affiche le tableau de bord réservé aux administrateurs.
     */
    @GetMapping("/adminDashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("pageTitle", "Tableau de bord Administrateur");
        model.addAttribute("userRole", "ADMIN");
        return "adminDashboard";
    }

    /**
     * Affiche le tableau de bord réservé aux médecins.
     */
    @GetMapping("/doctorDashboard")
    public String doctorDashboard(Model model) {
        model.addAttribute("pageTitle", "Tableau de bord Médecin");
        model.addAttribute("userRole", "DOCTOR");
        return "doctorDashboard";
    }
}
