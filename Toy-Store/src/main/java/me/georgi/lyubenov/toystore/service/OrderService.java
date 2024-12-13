package me.georgi.lyubenov.toystore.service;

import jakarta.persistence.EntityNotFoundException;
import me.georgi.lyubenov.toystore.dto.OrderDTO;
import me.georgi.lyubenov.toystore.dto.ToyDTO;
import me.georgi.lyubenov.toystore.dto.UserDTO;
import me.georgi.lyubenov.toystore.model.*;
import me.georgi.lyubenov.toystore.repository.OrderRepository;
import me.georgi.lyubenov.toystore.repository.ToyRepository;
import me.georgi.lyubenov.toystore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ToyRepository toyRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ToyRepository toyRepository) {
        this.orderRepository = orderRepository;


        this.userRepository = userRepository;
        this.toyRepository = toyRepository;
    }

    public OrderDTO convertToDTO(Order order) {
        UserDTO userDTO = new UserDTO(order.getUser().getFirstName(),
                order.getUser().getLastName(),
                order.getUser().getAge());

        ToyDTO toyDTO = new ToyDTO(order.getToy().getName(),order.getToy().getPrice());

        return new OrderDTO(userDTO,toyDTO,order.getOrderDate());
    }

    public Order convertToEntity(OrderDTO orderDTO){
        User user = userRepository.findByFirstNameAndLastName(
                        orderDTO.getUser().getFirstName(),
                        orderDTO.getUser().getLastName()
                );

        Toy toy = toyRepository.findByName(orderDTO.getToy().getName());

        Order order = new Order();
        order.setUser(user);
        order.setToy(toy);
        order.setOrderDate(orderDTO.getOrderDate());
        return order;
    }

    public OrderDTO addOrder(OrderDTO orderDTO){
        Order order = convertToEntity(orderDTO);

        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    public List<OrderDTO> findAllOrders(){
        return orderRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteOrderById(int id){
        orderRepository.deleteById(id);
    }

    public OrderDTO updateOrder(int id, OrderDTO orderDTO){
        Optional<Order> existingOrder = orderRepository.findById(id);
        if(existingOrder.isPresent()){
            OrderDTO updatedOrder = convertToDTO(existingOrder.get());
            updatedOrder.setUser(orderDTO.getUser());
            updatedOrder.setToy(orderDTO.getToy());
            updatedOrder.setOrderDate(orderDTO.getOrderDate());
            orderRepository.save(convertToEntity(updatedOrder));
            return updatedOrder;
        }else {
            throw new EntityNotFoundException();
        }
    }
    // Used it just for testing JUnit
    public static double Calculator(Integer x, Integer y,char operator){
        if(operator!='+'&&operator!='-'&&operator!='*'&&operator!='/'){
            throw new IllegalArgumentException();
        }

        switch(operator){
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            case '/':
                if(x==0||y==0){
                    throw new IllegalArgumentException();
                }
                double result = (double) x / (double) y;

                return Math.round(result*100)/100.0;
            default:
            return 0;
        }
    }

}

