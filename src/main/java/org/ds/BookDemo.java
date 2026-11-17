
package org.ds;

import org.ds.proto.Book;

public class BookDemo {
    public static void main(String[] args) throws Exception {

        Book book = Book.newBuilder()
                .setTitle("Distributed Systems")
                .setAuthor("John Smith")
                .setIsbn("9781234567890")
                .setYear(2024)
                .setCategory(Book.Category.TECHNOLOGY)
                .build();

        // Serialization
        byte[] data = book.toByteArray();

        System.out.println("Protobuf size: " + data.length + " bytes");

        // Deserialization
        Book received = Book.parseFrom(data);

        System.out.println("Title: " + received.getTitle());
        System.out.println("Author: " + received.getAuthor());
        System.out.println("ISBN: " + received.getIsbn());
        System.out.println("Year: " + received.getYear());
        System.out.println("Category: " + received.getCategory());

        String json = String.format(
                "{\"title\":\"%s\",\"author\":\"%s\",\"isbn\":\"%s\",\"year\":%d,\"category\":\"%s\"}",
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getYear(),
                book.getCategory());

        int jsonSize = json.getBytes(
                java.nio.charset.StandardCharsets.UTF_8).length;

        System.out.println("JSON size: " + jsonSize + " bytes");
        System.out.println("Protobuf size: " + data.length + " bytes");
        System.out.println("Difference: " + (jsonSize - data.length) + " bytes");

    }
}
