package javacode;

/*
We are running a catering service, and we'd like to run a report of how much money each of our customers have spent on us.

For example, we might have a list of transactions that looks like this:

transactions_1 = [
    ['customer_4', 'event_34', '7000'],  # customer_4 spent $7000 catering event_34
    ['customer_4', 'event_37', '6000'],
    ['customer_6', 'event_15', '3000'],
    ['customer_6', 'event_36', '7000'],
    ['customer_6', 'event_49', '4000'],
    ['customer_6', 'event_67', '6000'],
    ['customer_6', 'event_85', '6000']
]

We would like to know how many events each customer had catered, and how much they spent in total. Here, customer_4 had two events totaling 7000 + 6000 = $13000, and customer_6 had five events totaling $26000.

Write a function that takes a transaction list and outputs how many events each customer had and how much they spent in total in a suitable data structure.

All inputs:

transactions_1 = [
    ["customer_4", "event_34", "7000"],
    ["customer_4", "event_37", "6000"],
    ["customer_6", "event_15", "3000"],
    ["customer_6", "event_36", "7000"],
    ["customer_6", "event_49", "4000"],
    ["customer_6", "event_67", "6000"],
    ["customer_6", "event_85", "6000"]
]
transactions_2 = [
    ["customer_6", "event_49", "4000"],
    ["customer_6", "event_85", "6000"],
    ["customer_4", "event_34", "7000"],
    ["customer_6", "event_67", "6000"],
    ["customer_6", "event_15", "3000"],
    ["customer_6", "event_36", "7000"],
    ["customer_4", "event_37", "6000"]
]
transactions_3 = [
    ["customer_3", "event_70", "4000"],
    ["customer_3", "event_71", "6900"],
    ["customer_1", "event_40", "1600"],
    ["customer_6", "event_74", "6900"],
    ["customer_8", "event_75", "7400"],
    ["customer_1", "event_43", "6400"],
    ["customer_3", "event_52", "6300"],
    ["customer_6", "event_25", "3500"],
    ["customer_1", "event_62", "2500"]
]

All test cases (results be in any order):

report_sales(transactions_1) => customer_4: (2, 13000), customer_6: (5, 26000)
report_sales(transactions_2) => customer_4: (2, 13000), customer_6: (5, 26000)
report_sales(transactions_3) => customer_1: (3, 10500), customer_3: (3, 17200), customer_6: (2, 10400), customer_8: (1, 7400)

Complexity variables:
N = the number of transactions
*/
//import java.io.*;
import java.util.*;
//import javafx.util.Pair;

public class Solution {
    public static void main(String[] argv) {


        String[][] transactions_1 = {
                {"customer_4", "event_34", "7000"},
                {"customer_4", "event_37", "6000"},
                {"customer_6", "event_15", "3000"},
                {"customer_6", "event_36", "7000"},
                {"customer_6", "event_49", "4000"},
                {"customer_6", "event_67", "6000"},
                {"customer_6", "event_85", "6000"}
        };
        String[][] transactions_2 = {
                {"customer_6", "event_49", "4000"},
                {"customer_6", "event_85", "6000"},
                {"customer_4", "event_34", "7000"},
                {"customer_6", "event_67", "6000"},
                {"customer_6", "event_15", "3000"},
                {"customer_6", "event_36", "7000"},
                {"customer_4", "event_37", "6000"}
        };
        String[][] transactions_3 = {
                {"customer_3", "event_70", "4000"},
                {"customer_3", "event_71", "6900"},
                {"customer_1", "event_40", "1600"},
                {"customer_6", "event_74", "6900"},
                {"customer_8", "event_75", "7400"},
                {"customer_1", "event_43", "6400"},
                {"customer_3", "event_52", "6300"},
                {"customer_6", "event_25", "3500"},
                {"customer_1", "event_62", "2500"}
        };
        Map<String,Customer> customers = new Solution().calculate(transactions_3);
        Iterator<Map.Entry<String, Customer>> iterator = customers.entrySet().iterator();
        System.out.println("Output for transactions_3 :" );
        while (iterator.hasNext()) {
            Map.Entry<String, Customer> entry = iterator.next();
            System.out.println(entry.getValue().toString());
        }

    }

    public class Customer {
        private String id;
        private int no;
        private int amt;

        public String getId() {
            return this.id;
        }
        public int getNo() {
            return this.no;
        }
        public int getAmt() {
            return this.amt;
        }
        public void setId(String id) {
            this.id = id;
        }
        public void setNo(int no) {
            this.no = no;
        }
        public void setAmt(int amt) {
            this.amt = amt;
        }

        public String toString() {
            return "customer name: " + this.id +
                    " No of events: " + this.no +
                    " Amount spent: " + this.amt;
        }
    }
    private Map<String,Customer> calculate(String[][] matrix) {
        Map<String,Customer> customers = new HashMap<>();
        for (int i=0; i<matrix.length-1;i++) {
                String id = matrix[i][0];
                if(customers.containsKey(id)) {
                    Customer customer = customers.get(id);
                    int no = customer.getNo();
                    int amt = customer.getAmt();
                    customer.setNo(++no);
                    customer.setAmt(amt+Integer.parseInt(matrix[i][2]));
                    customers.put(id, customer);
                } else {
                    Customer customer = new Customer();
                    customer.setId(id);
                    customer.setNo(1);
                    customer.setAmt(Integer.parseInt(matrix[i][2]));
                    customers.put(id, customer);
                }
        }
        return customers;
    }
}

