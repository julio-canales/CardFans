package com.revature.cardfans.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.revature.cardfans.models.payload.PlaceOrderRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import java.util.List;

import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "orders")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @JsonIgnore
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();

    public void insertOrderItem(OrderItem o) {
        items.add(o);
    }

    public Order(PlaceOrderRequest orderRequest) {
        this.setItems(
                orderRequest.getItems().stream().map(oi -> new OrderItem(oi, this)).collect(Collectors.toList()));
        this.user = new User(orderRequest.getUserId());
    }
}
