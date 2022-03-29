package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.ProductPhoto;
import edu.miu.gulit.gulit.domain.User;
import edu.miu.gulit.gulit.service.MyUserDetailsService;
import edu.miu.gulit.gulit.service.ProductService;
import edu.miu.gulit.gulit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    MyUserDetailsService service;

    @Autowired
    UserService userService;


    @GetMapping("{id}")
    public User findById(@PathVariable("id") long id) {

        return userService.findById(id);
    }
        @GetMapping("{username}")
        public UserDetails findByUsername(@PathVariable  String username) {
            {
                return service.loadUserByUsername(username);
            }
        }
        @GetMapping
        public List<User> findAll() {
            return userService.findAll();
        }

        @PostMapping
        public User save(@RequestBody @Valid User data) {
            return userService.save(data);
        }
//
        @PutMapping("{id}")
        public User update(@RequestBody  User user, @PathVariable long id) {
            return userService.update(user, id);
        }
//
        @DeleteMapping("{id}")
        public void deleteById(@PathVariable  long id) {
            userService.deleteById(id);
        }
//
//        @PutMapping("/{id}/images")
//        public List<ProductPhoto> findImagesById(@PathVariable long id) {
//            return  service.findImagesById(id);
//        }
//    }



}
