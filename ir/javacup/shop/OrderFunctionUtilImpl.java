package ir.javacup.shop;

import java.util.function.Function;
@SuppressWarnings("unused")
public class OrderFunctionUtilImpl implements OrderFunctionUtil {


    @Override
    public Function<Order, Boolean> isBigOrder() {

        Function<Order,Boolean> function = order -> {
            if (order.getPrice()>10000000){
                 return true;}
            else
                return false;
        };

        return function;
    }

    @Override
    public Function<Order, Boolean> hasMultipleProducts() {

        Function<Order,Boolean> function =order -> {
            if((long) order.getProducts().size() >1){
                return true;
            }
            return false;
        };
        return function;
    }

    @Override
    public Function<Order, Boolean> hasUnavailableProduct() {
        Function<Order,Boolean> orderBooleanFunction =p -> {
            if(p.getState().equals(ProductState.UNAVAILABLE)){
                return true;
            }
            return false;
        };
        return orderBooleanFunction;
    }

    @Override
    public Function<Order, Boolean> isReadyToDeliver() {
        return null;
    }

    @Override
    public Function<Order, Boolean> hasPerishableProduct() {
        return null;
    }

    @Override
    public Function<Order, Boolean> hasExpensiveBreakableProduct() {
        return null;
    }
}
