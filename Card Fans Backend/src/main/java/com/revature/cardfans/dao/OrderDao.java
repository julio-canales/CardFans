package com.revature.cardfans.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.cardfans.models.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findByUser_UserId(Integer userId);

    List<Order> findByUser_Username(String username);

}