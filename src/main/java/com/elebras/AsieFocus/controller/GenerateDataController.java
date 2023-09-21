package com.elebras.AsieFocus.controller;

import com.elebras.AsieFocus.service.GenerateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenerateDataController {
    private final GenerateData generateData;

    @Autowired
    public GenerateDataController(GenerateData generateData) {
        this.generateData = generateData;
    }

    @GetMapping("/generate")
    public void generateComptes() {
        generateData.generateComptes(10);
        generateData.generateAnnonces(10);
        generateData.generateRubriques();
        generateData.generateRessources(110);
        generateData.generateArticles(120);
        generateData.generateCommentaires(300);
        generateData.generatePays();
        generateData.generateComposes();
        generateData.generateFavoris();
    }
}
