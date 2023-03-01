package com.example.crudEmpresa.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;
    @Autowired
    public EmpresaController(EmpresaService empresaService){
        this.empresaService=empresaService;

    }
    @GetMapping
    public List<Empresa> getEmpresa(){
        return empresaService.getEmpresa();
    }
    @PostMapping(path = "/save")
    public ResponseEntity<Object> registrarEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.newEmpresa(empresa);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Object> actualizarEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.newEmpresa(empresa);
    }
    @DeleteMapping(path="/{empresaId}")
    public ResponseEntity<Object> ELiminarEmpresa(@PathVariable("empresaId") Integer id){
        return this.empresaService.deleteEmpresa(id);
    }

}
