package br.edu.ifba.redes.escalonamento.users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final List<User> users = List.of(
            new User(1L, "João", "joao@email.com"),
            new User(2L, "Maria", "maria@email.com"),
            new User(3L, "Pedro", "pedro@email.com")
    );

    public List<User> findAll() {
        return users;
    }

    public User findById(Long id) {
        return users.stream()
                .filter(u -> u.id().equals(id))
                .findFirst()
                .orElseThrow();
    }
}