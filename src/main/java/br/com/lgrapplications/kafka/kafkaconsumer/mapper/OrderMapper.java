package br.com.lgrapplications.kafka.kafkaconsumer.mapper;

import br.com.lgrapplications.kafka.dto.OrderDTO;
import br.com.lgrapplications.kafka.kafkaconsumer.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order convertToModel(OrderDTO orderDTO) {
        return convertToModel(orderDTO,null);
    }

    public Order convertToModel(OrderDTO orderDTO, Order order) {
        if (order == null) {
            order = new Order();
        }

        order.setId(orderDTO.getId());
        order.setIdade(orderDTO.getIdade());
        order.setNome(orderDTO.getNome());

        return order;
    }

    public OrderDTO convertToDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setIdade(order.getIdade());
        orderDTO.setNome(order.getNome());

        return orderDTO;
    }

}
