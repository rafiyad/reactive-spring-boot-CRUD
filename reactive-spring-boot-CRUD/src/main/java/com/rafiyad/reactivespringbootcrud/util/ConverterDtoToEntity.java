package com.rafiyad.reactivespringbootcrud.util;

import com.rafiyad.reactivespringbootcrud.dto.CustomerDto;
import com.rafiyad.reactivespringbootcrud.entity.Customer;
import org.springframework.beans.BeanUtils;

public class ConverterDtoToEntity {
    
    public static CustomerDto entityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        //If both entity and dto have same properties use Beanutils otherwise use customerDto.setId(customer.getId());
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }
    
    public static Customer dtoToEntity(CustomerDto dto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(dto, customer);
        return customer;
    }
    
}
