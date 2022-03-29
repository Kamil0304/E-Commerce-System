package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.UserAddress;
import edu.miu.gulit.gulit.service.UserAddressService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@CrossOrigin()
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;

    @GetMapping
    public List<UserAddress> addresses(){
        return userAddressService.getAddresses();
    }

    @PostMapping
    public UserAddress saveAddress(@RequestBody UserAddress address){
        return userAddressService.saveAddress(address);
    }

    @PutMapping("{id}")
    public UserAddress updateAddress(@RequestBody UserAddress address, @PathVariable("id") int id){
        return userAddressService.updateAddress(address, id);
    }

    @DeleteMapping("{id}")
    public void deleteAddressById(@PathVariable("id") int id){
        userAddressService.deleteAddressById(id);
    }
}
