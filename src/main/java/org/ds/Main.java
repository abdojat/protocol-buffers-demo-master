package org.ds;

import com.google.protobuf.InvalidProtocolBufferException;
import org.ds.proto.Student;
import org.ds.proto.Students;

public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        byte[] msg = sender();
        receiver(msg);

    }

    private static void receiver(byte[] msg) throws InvalidProtocolBufferException {
        System.out.println("Received Data:");
        for (int i = 0; i < msg.length; i++) {
            System.out.print(msg[i] + " ");
        }
        System.out.println();
        System.out.println(msg.length);
        var students = Students.parseFrom(msg);
        System.out.println(students.getStudentsList());
    }

    private static byte[] sender() {
        Student student1 = Student.newBuilder().setName("Mohamad").setAge(40).build(); //builder pattern
        Student student2 = Student.newBuilder().setName("Ahmad").setAge(40).build(); //builder pattern

        Students students = Students.newBuilder().addStudents(student1).addStudents(student2).build();

        byte[] arrayToSend = students.toByteArray();

        for (int i = 0; i < arrayToSend.length; i++) {
            System.out.print(arrayToSend[i] + " ");
        }
        System.out.println();
        System.out.println(arrayToSend.length);
        return arrayToSend;
    }
}

//./protoc --proto_path=src --java_out=.\src\main\java .\src\proto\student.proto

