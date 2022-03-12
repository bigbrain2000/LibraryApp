package com.Ness.service;

import com.Ness.model.Role;
import com.Ness.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> listAll() {
        return repository.findAll();
    }

    public void save(Role role) {
        repository.save(role);
    }

    public Role get(Integer id) {
        return repository.findById(id).get();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
