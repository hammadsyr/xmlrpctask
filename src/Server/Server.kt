package Server

import helma.xmlrpc.WebServer

class Server {
    var hasil = 0
    fun calc(mode: Int, x: Int, y: Int): Int? {
        when (mode) {
            1 -> hasil =  x + y
            2 -> hasil =  x - y
            3 -> hasil =  x * y
            4 -> hasil =  x / y
        }
        return hasil
    }
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            try {

                println("Starting Server...")

                val server = WebServer(1717)
                server.addHandler("server", Server())
                server.start()

                println("Started successfully.")
                println("Stop if you need")

            } catch (exception: Exception) {
                System.err.println("JavaServer: $exception")
            }
        }
    }
}
/*  var hasil  = 0
  fun calcServer (mode : Int, x: Int, y: Int): Int {
      when (mode){
          1 -> this.hasil = x+y
          2 -> this.hasil = x-y
          3 -> this.hasil = x*y
          4 -> this.hasil = x/y
      }
      hasil =  this.hasil
  }

  companion object {
      @JvmStatic
      fun main(args: Array<String>) {
          try {

              // Invoke me as <http://localhost:1717/RPC2>.
              val server = WebServer(80)
              server.addHandler("server", Server())
              server.start()
              System.out.println("Started Successfully")
              System.out.println("hasil = " )
          } catch (exception: Exception) {
              System.err.println("Server: " + exception.toString())
          }

      }
  }*/

