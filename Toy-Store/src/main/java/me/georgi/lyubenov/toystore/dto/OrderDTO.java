package me.georgi.lyubenov.toystore.dto;

public class OrderDTO {
    private UserDTO user;
    private ToyDTO toy;
    private String orderDate;

    public OrderDTO() {
    }

    public OrderDTO(UserDTO user, ToyDTO toy, String orderDate) {
        this.user = user;
        this.toy = toy;
        this.orderDate = orderDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ToyDTO getToy() {
        return toy;
    }

    public void setToy(ToyDTO toy) {
        this.toy = toy;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
