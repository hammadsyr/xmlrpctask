package Client

import sun.misc.Unsafe
import helma.xmlrpc.XmlRpcClient
import java.util.*
import org.apache.xerces.parsers.SAXParser;

class Client {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            try {
                val client = XmlRpcClient("http://localhost:1717/RPC2")
                val params = Vector<Int>()

                var masukan = Scanner(System.`in`)

                println("Input 1 untuk tambah, 2 untuk kurang, 3 untuk kali, dan 4 untuk bagi")
                var mode = masukan.nextInt()
                println("masukkan nilai x")
                var x = masukan.nextInt()
                println("masukkan nilai x")
                var y = masukan.nextInt()

                params.addElement(mode)
                params.addElement(x)
                params.addElement(y)

                val result = client.execute("server.calc", params)

                val sum = (result as Int).toInt()
                println("The result is : $sum")

            } catch (exception: Exception) {
                System.err.println("JavaClient: $exception")
            }

        }

    }
}


/*@JvmStatic
fun main(args: Array<String>) {
    try {
        val client = XmlRpcClient("http://10.72.44.1593:80/RPC2")
        val params = Vector<Int>()
        var masukan = Scanner(System.`in`)

        println("masukkan 1 untuk tambah, 2 untuk kurang, 3 untuk kali, dan 4 untuk bagi")
        var mode = masukan.nextInt()
        println("masukkan nilai x")
        var x = masukan.nextInt()
        println("masukkan nilai x")
        var y = masukan.nextInt()

        params.addElement(mode)
        params.addElement(x)
        params.addElement(y)

        val result = client.execute("server.calcServer", params)

        val sum = (result as Int).toInt()
        println("The sum is: $sum")

    } catch (exception: Exception) {
        System.err.println("JavaClient: $exception")
    }
    var theUnsafeField = Unsafe::class.java!!.getDeclaredField("theUnsafe")
    theUnsafeField.setAccessible(true);
    var theUnsafe = theUnsafeField.get(null) as Unsafe

}*/

