package io.ecommerce.server.service;

import io.ecommerce.server.dao.UserDao;
import io.ecommerce.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    // Add User
    public ResponseEntity<User> addUser(User user) {
        try {
            User _user = userDao.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Users
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userDao.findAll();
            if(users.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get user by Id
    public ResponseEntity<Optional<User>> getUserById(long id) {
        try {
            Optional<User> user = userDao.findById(id);
            if(user.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete User By Id
    public ResponseEntity<HttpStatus> deleteUser(long id) {
        try {
            userDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update User By Id
    public ResponseEntity<Optional<User>> updateUser(long id, User user) {
        try {
            Optional<User> userData = userDao.findById(id);
            if(userData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(userData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
