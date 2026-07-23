// Exercise 6: Library Management System
public class Exercise6_LibraryManagementSystem {

    public static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getTitle() { return title; }

        @Override
        public String toString() {
            return "Book{title='" + title + "', author='" + author + "'}";
        }
    }

    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }
            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B1", "A Tale of Two Cities", "Charles Dickens"),
            new Book("B2", "1984", "George Orwell"),
            new Book("B3", "Moby Dick", "Herman Melville"),
            new Book("B4", "Pride and Prejudice", "Jane Austen"),
            new Book("B5", "The Great Gatsby", "F. Scott Fitzgerald")
        };

        System.out.println("Linear Search for '1984':");
        System.out.println(linearSearchByTitle(books, "1984"));

        // Binary search requires sorted array, let's sort first
        java.util.Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        
        System.out.println("\nBinary Search for 'The Great Gatsby':");
        System.out.println(binarySearchByTitle(books, "The Great Gatsby"));
    }
}
