package nyansapo.ordervalidation;

import nyansapo.ordervalidation.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    private static final Map<String, Order> order = new HashMap<>();
    @PostConstruct
    public void initialize() {
        Order od1 = new Order();
        od1.setOrderId("Or0001");
        od1.setClientId("C01");
        od1.setPortfolioId("P01");
        od1.setPrice(2.5);
        od1.setQuantity(2);
        od1.setSide("Sell");
        od1.setProductName("APPL");
        od1.setTimeStamp("12:01:02");
    }

    public Order getOrder (String clientId) {
        return order.get(clientId);
    }

}
