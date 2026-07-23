// Exercise 6: Implementing the Proxy Pattern
public class ProxyPatternExample {

    public interface Image {
        void display();
    }

    public static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromRemoteServer(fileName);
        }

        private void loadFromRemoteServer(String fileName) {
            System.out.println("Loading " + fileName + " from remote server...");
        }

        @Override
        public void display() {
            System.out.println("Displaying " + fileName);
        }
    }

    public static class ProxyImage implements Image {
        private RealImage realImage;
        private String fileName;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        
        // Image will be loaded from disk
        image1.display();
        System.out.println("");
        // Image will not be loaded from disk
        image1.display();
    }
}
