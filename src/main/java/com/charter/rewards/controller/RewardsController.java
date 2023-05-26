package com.charter.rewards.controller;

import com.charter.rewards.entity.Customer;
import com.charter.rewards.exception.CustomerNotFoundException;
import com.charter.rewards.model.Rewards;
import com.charter.rewards.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.charter.rewards.service.RewardCalculatorService;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
    @Autowired
    RewardCalculatorService rewardsService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customer/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rewards> getRewardsByCustomerId(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer != null)
        {
            Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
            return new ResponseEntity<>(customerRewards, HttpStatus.OK);
        }else{
            throw new CustomerNotFoundException("Customer not found with id : "+ customerId);
        }

    }
}
