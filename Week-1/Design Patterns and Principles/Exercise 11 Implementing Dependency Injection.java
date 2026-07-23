// Exercise 11: Implementing Dependency Injection
public class Exercise11_DependencyInjection {

    public interface CustomerRepository {
        String findCustomerById(String id);
    }

    public static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(String id) {
            // Simulated DB lookup
            return "Customer data for ID: " + id;
        }
    }

    public static class CustomerService {
        private CustomerRepository repository;

        // Constructor Injection
        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void getCustomerInfo(String id) {
            String data = repository.findCustomerById(id);
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        
        service.getCustomerInfo("1001");
    }
}
