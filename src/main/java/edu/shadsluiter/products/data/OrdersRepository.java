package edu.shadsluiter.products.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.shadsluiter.products.models.OrderEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Integer> { 
}
