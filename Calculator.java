public class Calculator implements IOperator{

    @Override
    public Integer add(Integer first, Integer second){
        return first + second;
    }

    @Override
    public Integer substract(Integer first, Integer second){
        return first - second;
    }

    @Override
    public Integer multiply(Integer first, Integer second){
        return first * second;
    }

    @Override
    public Integer divide(Integer first, Integer second){
        if (second != 0)
            return first / second;
        else
            return 0;
    }

    @Override
    public Integer modulo(Integer first, Integer second) {
        return (first - (first/second*second));
    }

    @Override
    public Integer factorial(Integer first) {
        Integer result;

        if(first == 1)
            result =  1;
        else {
            result = factorial(first - 1) * first;
        }
        return result;
    }
}