package com.example.OrderService.Service;

import com.example.OrderService.Dto.ProductDto;
import com.example.OrderService.Feign.AuthFeignController;
import com.example.OrderService.Feign.ProductFeignController;
import com.example.OrderService.Model.Order;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService{


    private final OrderRepository repository;
    private final ProductFeignController productFeign;
    private final AuthFeignController authFeign;

    @Autowired
    private JwtService jwtService;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, ProductFeignController productFeign, AuthFeignController authFeign) {
        this.repository = repository;
        this.productFeign = productFeign;
        this.authFeign = authFeign;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order placeOrder(Order order) throws Exception {
        ProductDto product = productFeign.getByProductName(order.getProductName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) authentication.getPrincipal();
        int pQty = product.getQty();
        Long pId = product.getProductId();
        int oQty =  order.getQty();
        if( pQty >= oQty){
            Double pAmnt = product.getPrice();
            Double total = oQty * pAmnt;
            order.setOrderAmount(total);
            order.setUsername(userName);
            repository.save(order);
            productFeign.reduceQuantity(pId,oQty);
            return order;
        }
        else throw new Exception("Product Out of Stock --- Try Low Quantity...:) ");


    }
}
