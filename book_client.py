
import grpc
import book_pb2
import book_pb2_grpc

with grpc.insecure_channel("localhost:50051") as channel:
    stub = book_pb2_grpc.BookServiceStub(channel)

    request = book_pb2.GetBookRequest(
        isbn="9781234567890"
    )

    response = stub.GetBook(request)

    print("Book received from server:")
    print("Title:", response.title)
    print("Author:", response.author)
    print("ISBN:", response.isbn)
    print("Year:", response.year)
    print("Category:", book_pb2.Book.Category.Name(response.category))
