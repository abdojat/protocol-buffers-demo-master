# ProtoBuf

## Generating Classes
[Download protoc](https://protobuf.dev/programming-guides/proto3/#generating)
```
./protoc --proto_path=src --java_out=.\src\main\java .\src\proto\student.proto
```

## Results
### Data as json (RestF)
[name: "Mohamad"
age: 40
, name: "Ahmad"
age: 40
]
<br>
**50 byte**

### Encode Data using protobuf
10 11 10 7 77 111 104 97 109 97 100 16 40 10 9 10 5 65 104 109 97 100 16 40
<br>
**24 byte**



### Useful Link 
* [Why GRPC? How protobuf empowers GRPC?
](https://www.youtube.com/watch?v=9ttYs4dXc9k&list=PL1F54YqZCTdxpGWMM7zyOigOQ_MVwSNc2&index=2&ab_channel=BetterDevwithAnubhav)
* [How Protocol buffers help GRPC | Code Tutorial | Java](https://www.youtube.com/watch?v=UAZ5Y9gay30&list=PL1F54YqZCTdxpGWMM7zyOigOQ_MVwSNc2&index=3&ab_channel=BetterDevwithAnubhav)
* [Java Generated Code Guide](https://protobuf.dev/reference/java/java-generated/#invocation)