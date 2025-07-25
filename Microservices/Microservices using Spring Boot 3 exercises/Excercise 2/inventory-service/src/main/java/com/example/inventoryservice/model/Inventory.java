package com.example.inventoryservice.model;

import jakarta.persistence.*;

@Entity
public class Inventory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long productId;
  private int quantity;
}
