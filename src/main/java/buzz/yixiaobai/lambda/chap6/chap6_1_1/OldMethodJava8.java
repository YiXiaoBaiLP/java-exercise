package buzz.yixiaobai.lambda.chap6.chap6_1_1;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 使用Java8 之前的方法，实现分组功能
 */
public class OldMethodJava8 {

    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0)
    );

    @Test
    public void test() {
        System.out.println("---------------- Java 8 之前的分组方法 ----------------");
        groupImperatively();
        System.out.println("---------------- Java 8 之后的分组方法 ----------------");
        groupFunctionally();
    }

    private static void groupImperatively(){
        // 建立累积交易分组的Map
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        // 迭代Transaction的List
        for(Transaction transaction : transactions){
            // 提取Transaction的货币
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            // 如果分组Map中没有这种货币的条目，就创建一个
            if(transactionsForCurrency == null){
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            // 将当前遍历的Transaction加入同一货币的Transaction的List
            transactionsForCurrency.add(transaction);
        }
        System.out.println(transactionsByCurrencies);
    }

    private static void groupFunctionally(){
        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println(transactionsByCurrencies);
    }

    public static class Transaction {
        private final Currency currency;
        private final double value;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }

    public enum Currency {
        EUR, USD, JPY, GBP, CHF;
    }
}
