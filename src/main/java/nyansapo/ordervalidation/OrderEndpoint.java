package nyansapo.ordervalidation;

import nyansapo.ordervalidation.model.GetOrderRequest;
import nyansapo.ordervalidation.model.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OrderEndpoint {

    @Autowired
    private OrderService orderService = null;
    @PayloadRoot(namespace = "http://nyansapo/ordervalidation/model", localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request){
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        getOrderResponse.setOrder(orderService.getOrder(request.getClientId()));
        return getOrderResponse;
    }
}
