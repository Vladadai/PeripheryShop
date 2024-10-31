package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Customer;

import java.util.List;

public class AppHelperCustomer implements AppHelper<Customer> {
    private final Input input;


    public AppHelperCustomer(Input input) {
        this.input = input;

    }

    @Override
    public Customer create() {
        try {
            Customer user = new Customer();
            System.out.print("Имя пользователя: ");
            user.setFirstName(input.nextLine());
            System.out.print("Фамилия пользователя: ");
            user.setLastName(input.nextLine());
            System.out.print("Телефон: ");
            user.setPhone(input.nextLine());
            return user;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean printList(List<Customer>customers) {
        try {
            if(customers.size() == 0) return false;
            for(int i = 0; i < customers.size(); i++){
                System.out.printf("%d. %s %s. %s%n",
                        i+1,
                        customers.get(i).getFirstName(),
                        customers.get(i).getLastName(),
                        customers.get(i).getPhone()
                );
            }
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }
}
