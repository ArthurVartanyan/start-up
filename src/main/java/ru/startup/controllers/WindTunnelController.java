package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.WindTunnelDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.WindTunnelService;

@RestController
public class WindTunnelController {

    private WindTunnelService windTunnelService;

    @Autowired
    public void setWindTunnelService(WindTunnelService windTunnelService) {
        this.windTunnelService = windTunnelService;
    }

    @GetMapping("/api/wind-tunnel/{id}")
    public WindTunnelDTO getWindTunnelById(@PathVariable Long id){
        return windTunnelService.getWindTunnelById(id);
    }

    @DeleteMapping("/api/wind-tunnel/{id}")
    public void deleteWindTunnelById(@PathVariable Long id){
        windTunnelService.deleteWindTunnelById(id);
    }

    @PostMapping("/api/wind-tunnel")
    public WindTunnelDTO createWindTunnel(@RequestBody WindTunnelDTO windTunnelDTO, @RequestParam EntertainmentType entertainmentType){
        return windTunnelService.createWindTunnel(windTunnelDTO, entertainmentType);
    }
}
