
import grpc
from concurrent import futures
import book_pb2
import book_pb2_grpc

class BookService(book_pb2_grpc.BookServiceServicer):

    def GetBook(self, request, context):
        print("Requested ISBN:", request.isbn)

        if request.isbn != "9781234567890":
            context.abort(grpc.StatusCode.NOT_FOUND, "Book not found")

        return book_pb2.Book(
            title="Distributed Systems",
            author="John Smith",
            isbn=request.isbn,
            year=2024,
            category=book_pb2.Book.TECHNOLOGY
        )

server = grpc.server(futures.ThreadPoolExecutor(max_workers=5))
book_pb2_grpc.add_BookServiceServicer_to_server(BookService(), server)

server.add_insecure_port("localhost:50051")
server.start()

print("gRPC Server running on port 50051")
server.wait_for_termination()
