package pl.koper.primerarch.dao;

import pl.koper.primerarch.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    List<User> getAll();
    User getUserByUserName(String username);
}
