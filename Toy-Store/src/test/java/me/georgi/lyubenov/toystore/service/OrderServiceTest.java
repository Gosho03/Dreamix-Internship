package me.georgi.lyubenov.toystore.service;

import me.georgi.lyubenov.toystore.dto.OrderDTO;
import me.georgi.lyubenov.toystore.dto.ToyDTO;
import me.georgi.lyubenov.toystore.dto.UserDTO;
import me.georgi.lyubenov.toystore.model.Order;
import me.georgi.lyubenov.toystore.model.Toy;
import me.georgi.lyubenov.toystore.model.User;
import me.georgi.lyubenov.toystore.repository.OrderRepository;
import me.georgi.lyubenov.toystore.repository.ToyRepository;
import me.georgi.lyubenov.toystore.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {


    @Test
    void calculator() {
        //Addition
        assertEquals(5,OrderService.Calculator(2,3,'+'),"Addition test failed");
        //Subtraction
        assertEquals(3,OrderService.Calculator(5,2,'-'),"Subtraction test failed");
        //Multiplication
        assertEquals(6,OrderService.Calculator(2,3,'*'),"Multiplication test failed");
        //Division
        assertEquals(0.67,OrderService.Calculator(2,3,'/'),"Division test failed");
        assertEquals(1.33,OrderService.Calculator(4,3,'/'),"Division test failed");
        //Division by zero
        assertThrows(IllegalArgumentException.class, () -> OrderService.Calculator(2,0,'/'),"Division by zero test failed");
        //Negative numbers
        assertEquals(-1,OrderService.Calculator(5,6,'-'),"Test for negative numbers failed");
        assertEquals(-2.5,OrderService.Calculator(-5,2,'/'),"Test for negative numbers failed");
        //Large numbers
        assertEquals(-2,OrderService.Calculator(Integer.MAX_VALUE,Integer.MAX_VALUE,'+'),"Test for larger numbers failed");
        assertEquals(0,OrderService.Calculator(Integer.MAX_VALUE,Integer.MAX_VALUE,'-'),"Test for larger numbers failed");
        assertEquals(1,OrderService.Calculator(Integer.MAX_VALUE,Integer.MAX_VALUE,'*'),"Test for larger numbers failed");
        assertEquals(Integer.MAX_VALUE,OrderService.Calculator(Integer.MAX_VALUE,0,'-'),"Test for larger numbers failed");
        //Check for null arguments
        assertThrows(NullPointerException.class, () -> OrderService.Calculator(5,null,'+'),"Test for null arguments failed");
        //Check for invalid operator
        assertThrows(IllegalArgumentException.class, () -> OrderService.Calculator(5,2,'('),"Test for invalid operator failed");

    }


}