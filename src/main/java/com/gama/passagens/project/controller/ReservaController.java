package com.gama.passagens.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.project.model.reserva.Reserva;
import com.gama.passagens.project.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
	@Autowired
	private ReservaService service;
	
	@GetMapping()
	public List<Reserva> getReservas(@RequestParam("viajanteId") Integer viajanteId, @RequestParam("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime inicio, @RequestParam("fim") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fim ) {
		return service.listarReservas(viajanteId, inicio, fim);
	}
}