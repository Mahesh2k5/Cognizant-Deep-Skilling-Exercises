import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 2: Mockito exercises
@ExtendWith(MockitoExtension.class)
public class Exercise2_MockitoExercises {

    // Service Interface
    public interface UserRepository {
        String getUserById(String id);
        boolean saveUser(String id, String name);
    }

    // Class to be tested
    public static class UserService {
        private UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public String fetchUser(String id) {
            return userRepository.getUserById(id);
        }

        public boolean registerUser(String id, String name) {
            if(id == null || name == null) return false;
            return userRepository.saveUser(id, name);
        }
    }

    // Test Class
    public static class UserServiceTest {

        @Mock
        private UserRepository userRepository;

        @InjectMocks
        private UserService userService;

        @Test
        public void testFetchUser() {
            // Arrange
            String userId = "100";
            String expectedName = "John Doe";
            when(userRepository.getUserById(userId)).thenReturn(expectedName);

            // Act
            String actualName = userService.fetchUser(userId);

            // Assert
            assertEquals(expectedName, actualName);
            verify(userRepository, times(1)).getUserById(userId);
        }

        @Test
        public void testRegisterUser() {
            // Arrange
            String userId = "101";
            String name = "Jane Doe";
            when(userRepository.saveUser(userId, name)).thenReturn(true);

            // Act
            boolean isSaved = userService.registerUser(userId, name);

            // Assert
            assertTrue(isSaved);
            verify(userRepository).saveUser(userId, name);
        }
    }
}
