package optional.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExample3 {

    static Map<Long, Order> orderRepository = new HashMap<>();

    public static void main(String[] args) {

        orderRepository.put(1L, new Order(1L, new Delivery(1L, "배송중", false)));
        orderRepository.put(2L, new Order(2L, new Delivery(2L, "배송중", true)));
        orderRepository.put(3L, new Order(3L, new Delivery(3L, "배송완료", false)));
        orderRepository.put(4L, new Order(4L, null));

        for (Long key : orderRepository.keySet()) {
            System.out.println(
                    findDeliveryById(key)
                    .filter(n -> !n.isCancel())
                    .map(Delivery::getDeliveryStatus)
                    .orElse("배송 X")
            );
        }

    }

    public static Optional<Delivery> findDeliveryById(Long id){
        return Optional.ofNullable(orderRepository.get(id).getDelivery());
    }

    static class Order{
        private Long orderNumber;
        private Delivery delivery;

        public Order(Long orderNumber, Delivery delivery) {
            this.orderNumber = orderNumber;
            this.delivery = delivery;
        }

        public Delivery getDelivery() {
            return delivery;
        }
    }


    static class Delivery{
        private Long id;
        private String status;
        private boolean cancel;

        public Delivery(Long id, String status, boolean cancel) {
            this.id = id;
            this.status = status;
            this.cancel = cancel;
        }

        public String getDeliveryStatus(){
            return status;
        }

        public boolean isCancel() {
            return cancel;
        }

    }

}
