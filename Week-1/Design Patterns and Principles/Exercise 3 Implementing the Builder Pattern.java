// Exercise 3: Implementing the Builder Pattern
public class BuilderPatternExample {

    public static class Computer {
        private String CPU;
        private String RAM;
        private String Storage;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
        }

        public static class Builder {
            private String CPU;
            private String RAM;
            private String Storage;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String Storage) {
                this.Storage = Storage;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + "]";
        }
    }

    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
                
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB NVMe SSD")
                .build();

        System.out.println(basicComputer);
        System.out.println(gamingComputer);
    }
}
