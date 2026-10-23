package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.services.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("client")
public class ClientController {
    private final IClientService clientService;
    @PostMapping("/addClient")
    public Client ajouterClient(@RequestBody Client client){
        return clientService.ajouterClient(client);
    }
    @PutMapping()
    public Client modifierClient(@RequestBody Client client){
        return clientService.modifierClient(client);
    }
    @GetMapping
    public List<Client> consulterClients(){
        return clientService.consulterClients();
    }
    @GetMapping("/delete/{idClient}")
    public void supprimerClients(@PathVariable Long idClient){
        clientService.supprimerClient(idClient );
    }


}
