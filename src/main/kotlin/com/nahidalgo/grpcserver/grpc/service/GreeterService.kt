package com.nahidalgo.grpcserver.grpc.service

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lognet.springboot.grpc.GRpcService
import proto.greeter.v1.Greeter.HelloRequest
import proto.greeter.v1.Greeter.HelloReply
import proto.greeter.v1.GreeterServiceGrpcKt

@GRpcService
class GreeterGrpcService : GreeterServiceGrpcKt.GreeterServiceCoroutineImplBase() {

    override fun sayStreamHello(request: HelloRequest): Flow<HelloReply> = flow {
        emit(HelloReply.newBuilder().setMessage("Hello, ${request.name}").build())
        delay(2000L)
        emit(HelloReply.newBuilder().setMessage("How are you doing?").build())
        delay(2000L)
        emit(HelloReply.newBuilder().setMessage("How is life going?").build())
        delay(2000L)
        emit(HelloReply.newBuilder().setMessage("Hope everything is ok").build())
    }
}