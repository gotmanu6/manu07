package controller;
import models.FornecedorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.FornecedorService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorModel> findAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<FornecedorModel> findById(@PathVariable Long id) {
        return fornecedorService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        fornecedorService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
        FornecedorModel request = fornecedorService.criarFornecedor(fornecedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(fornecedorModel.getId()).toUri();
        return  ResponseEntity.created(uri).body(request);
    }
}