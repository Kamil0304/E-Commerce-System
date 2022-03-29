package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.UserAddress;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> getAddresses();
    UserAddress saveAddress(UserAddress address);

    UserAddress updateAddress(UserAddress address, long id);

    UserAddress getAddressById(long address_id);

    void deleteAddressById(long id);
}
