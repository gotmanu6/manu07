package service;

import models.FornecedorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.FornecedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Optional<FornecedorModel> findById(Long id) {
        return fornecedorRepository.findById(id);
    }
    public List<FornecedorModel> findAll() {
        return fornecedorRepository.findAll();
    }

    public void deleteById(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }
}
