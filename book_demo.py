
import book_pb2

book = book_pb2.Book()
book.title = "Distributed Systems"
book.author = "John Smith"
book.isbn = "9781234567890"
book.year = 2024
book.category = book_pb2.Book.TECHNOLOGY

# Serialization
data = book.SerializeToString()
print("Protobuf size:", len(data), "bytes")

# Deserialization
received = book_pb2.Book()
received.ParseFromString(data)

print("Title:", received.title)
print("Author:", received.author)
print("ISBN:", received.isbn)
print("Year:", received.year)
print("Category:", book_pb2.Book.Category.Name(received.category))
