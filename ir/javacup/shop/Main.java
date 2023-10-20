package ir.javacup.shop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Product product  =new Product ("100","nike",120000000,ProductState.AVAILABLE,ProductType.NORMAL);
        Product product1 =new Product("101","nike",1300000,ProductState.AVAILABLE,ProductType.NORMAL);
        Product product2 =new Product("105","nike",140000,ProductState.AVAILABLE,ProductType.NORMAL);
        Product product3 =new Product("104","nike",1200000,ProductState.AVAILABLE,ProductType.NORMAL);
        Product product4 =new Product("102","nike",150000,ProductState.AVAILABLE,ProductType.NORMAL);
        Product product5 =new Product("108","nike",1300000,ProductState.AVAILABLE,ProductType.PERISHABLE);
        List<Product> list = Arrays.asList(product,product1,product2,product3,product4,product5);;
        final Optional<Long> reduce = list.stream().map(Product::getPrice).reduce(Long::sum);



        Order order =new Order("120", reduce.get(),"Samyar",OrderState.READY_TO_SEND,list);
        OrderFunctionUtil orderFunctionUtil =new OrderFunctionUtilImpl();


        System.out.println(orderFunctionUtil.isBigOrder().apply(order));


        System.out.println(orderFunctionUtil.hasMultipleProducts().apply(order));


        System.out.println(orderFunctionUtil.hasUnavailableProduct().apply(order));


        System.out.println(orderFunctionUtil.isReadyToDeliver().apply(order));

        System.out.println(orderFunctionUtil.hasPerishableProduct().apply(order));


    }
}
