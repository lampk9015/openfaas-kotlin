package com.openfaas.function

import com.openfaas.model.IHandler
import com.openfaas.model.IRequest
import com.openfaas.model.IResponse
import com.openfaas.model.Response
import com.google.gson.*


class Handler : IHandler {
    override fun handle(request: IRequest): IResponse {
        var gson = Gson()
        try {
            // var jsonString = """{"sid":"iTRWQbrJRiZv1nOfqgP87Tv86PxefVgnkaCUk9EY","body":"fun main() {\n    println(\"Hello, world!!!\")\n}"}""";
            // var requestBody = gson.fromJson(jsonString, RequestBody::class.java)
            var requestBody = gson.fromJson(request.body?.trim(), RequestBody::class.java)

            // return Response(body = "${request.body?.trim()}")
            return Response(body = "${requestBody.body}")
        }
        catch(e: JsonSyntaxException) {
            return Response(body = "Can not convert request content to JSON!", statusCode = 500)
        }
        catch(e: Exception) {
            return Response(body = "Unknow request content!", statusCode = 500)
        }
    }

    class RequestBody {
        var sid: String = ""
        var body: String = ""
    }
}
