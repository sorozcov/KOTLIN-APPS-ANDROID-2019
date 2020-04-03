
package com.example.silvi.lab2restaurante
//MyMENUORDER implementada
class MyMenuOrder(override var myOrder: ArrayList<String>) :MenuOrder{

    override fun add(element: String) {
        TODO(reason = "not implemented") //Agregar elemnto.
         myOrder.add(element)
    }

    override fun clear() {
        TODO("not implemented") //Clear array.
        myOrder.clear()
    }

    override fun del(elementIndex: Int) {
        TODO("not implemented") //Eliminar un elemento.
        myOrder.removeAt(elementIndex)
    }

    override fun done() {
        TODO("not implemented") //Enviar pedido.
    }
}


