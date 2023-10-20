package ir.javacup.shop;

import java.util.function.Function;

@SuppressWarnings("unused")
public class OrderFunctionUtilImpl implements OrderFunctionUtil {


    @Override
    public Function<Order, Boolean> isBigOrder() {

        Function<Order, Boolean> function = order -> {
            if (order.getPrice() > 10000000) {
                return true;
            } else
                return false;
        };

        return function;
    }

    @Override
    public Function<Order, Boolean> hasMultipleProducts() {

        Function<Order, Boolean> function = order -> {
            if ((long) order.getProducts().size() > 1) {
                return true;
            }
            return false;
        };
        return function;
    }

    @Override
    public Function<Order, Boolean> hasUnavailableProduct() {
        Function<Order, Boolean> orderBooleanFunction = (q) -> {
            if (q.getProducts().stream().map(Product::getState).
                    anyMatch((p -> p.equals(ProductState.UNAVAILABLE))))
            {
                return true;
            }
            return false;

        };
        return orderBooleanFunction;
    }

    @Override
    public Function<Order, Boolean> isReadyToDeliver() {
        Function<Order,Boolean> function =(a)->{
            if(a.getProducts().stream().map(Product::getState).
                    allMatch(productState -> productState.equals(ProductState.AVAILABLE)) && a.getState().equals(OrderState.READY_TO_SEND)){
                return true;
            }
            return false;
        };
        return function;
    }

    @Override
    public Function<Order, Boolean> hasPerishableProduct() {
        Function<Order,Boolean> function =(a)->{
            if(a.getProducts().stream().map(Product::getType).anyMatch(productType -> productType.equals(ProductType.PERISHABLE))){
                return true;
            }
            return false;
        };
        return function;
    }

    @Override
    public Function<Order, Boolean> hasExpensiveBreakableProduct() {
        return null;
    }
}
