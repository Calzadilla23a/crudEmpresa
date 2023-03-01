package com.example.crudEmpresa.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    HashMap<String, Object> map = new HashMap<>();
    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository=empresaRepository;
    }
    public List<Empresa> getEmpresa(){
        return this.empresaRepository.findAll();
    }

    public ResponseEntity<Object> newEmpresa(Empresa empresa) {
        Optional<Empresa> res = empresaRepository.findEmpresaByNombre(empresa.getNombre());


        if(res.isPresent()){
            map.put("error",true);
            map.put("messagge","Ya existe la empresa");
            return new ResponseEntity<>(
                    map,
                    HttpStatus.CONFLICT
            );
        }
        empresaRepository.save(empresa);
        map.put("map",empresa);
        map.put("messagge","Se guardo con exito");
        return new ResponseEntity<>(
                map,
                HttpStatus.CREATED);

    }
    public ResponseEntity<Object>deleteEmpresa(Integer id){
        map.put("mesagge","Producto eliminado");
        return new ResponseEntity<>(
               map,
               HttpStatus.ACCEPTED
        );
    }
}
