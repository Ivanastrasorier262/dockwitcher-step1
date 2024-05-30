package com.hotakakademy.dockwitcher.controllers

import com.hotakakademy.dockwitcher.contracts.ConductorDto
import com.hotakakademy.dockwitcher.domain.factories.IConductorFactory
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import com.hotakakademy.dockwitcher.domain.services.ConductorService
import com.hotakakademy.dockwitcher.domain.services.IConductorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ConductoresController (
        private val repository: IConductorRepository,
        private val conductorService: IConductorService
) {
    @GetMapping("/conductores")
    fun listado(model: Model
    ): String {
        val tractoras = repository.findAll()
        model.addAttribute("items", tractoras)
        return "listadoconductores"
    }

    @GetMapping("/conductores/nuevo")
    fun nuevo(model: Model
    ): String {
        return "nuevoconductor"
    }

    @PostMapping("/conductores/nuevo")
    fun create(@ModelAttribute conductorDto: ConductorDto
    ): String {
        conductorService.create(conductorDto)
        return "listadoconductores"
    }

}