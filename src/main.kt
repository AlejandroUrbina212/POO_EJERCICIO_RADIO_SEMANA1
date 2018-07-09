package main

import main.radio.Radio


val Radio = Radio(

)

fun main(args: Array<String>) {
    do {
        println("""Bienvenido, El estado actual del radio es:
            $Radio
            Por Favor seleccione una opción:
            1. Encender Radio.
            2. Cambiar Frecuencia (AM/FM).
            3. Cambiar de estación.
            4. Subir o bajar Volúmen
            5. Apagar Radio.
            6. Salir del programa.

        """.trimMargin())
        println("Ingrese su selección: ")
        // variables generales
        var frecuencia: Int = 0
        // hasta acá
        val strseleccion: String? = readLine()
        var seleccion: Int = 0
        var OkSeleccion: Boolean = false
        if (strseleccion != null) {
            try {
                seleccion = strseleccion.toInt()
                OkSeleccion = true

            } catch (error: NumberFormatException) {
                println("ERROR: Por favor ingrese un número")
                OkSeleccion = false
            }
        }
        if (OkSeleccion){
            seleccion = strseleccion!!.toInt()
        }

        if (seleccion==1){
            if (!Radio.isTurnedOn){
                Radio.turnOn()
                println("usted ha encendido el Radio")
            }
            else{
                println("El radio ya está Encendido")
            }
        }
        else if (seleccion==2){
            var OkFrecuencia: Boolean = false
            println("Seleccione el número de opción de frecuencia que desea sintonizar")
            println("1. AM")
            println("2. FM")

            val strfrecuencia: String? = readLine()
            if (strfrecuencia != null) {
                try {
                    frecuencia = strfrecuencia.toInt()
                    OkFrecuencia = true

                } catch (error: NumberFormatException) {
                    println("ERROR: Por favor ingrese un número")
                    OkFrecuencia= false
                }
            }
            if (OkFrecuencia && 0<frecuencia && frecuencia<3){
                frecuencia = strfrecuencia!!.toInt()
                when (frecuencia){
                    1-> Radio.RangeToAM()
                    2->Radio.RangeToFM()
                }
            }

        }
        else if (seleccion==3){
            val frec_actual = Radio.frecuencia
            if (frec_actual=="AM"){
                println("xdD")
            }
            else if (frec_actual=="FM"){
                // TERMINAR DE PONER CONDICIONALES PARA EVITAR QUE EL USUARIO SIGA INGRESANDO SIN BAJAR
                var end: Int =0
                while (end==0) {
                    println("Ingrese el signo ´+´ o ´-´ para subir o bajar de estación")
                    val strUpOrDown: String? = readLine()
                    if ((Radio.Station + 10) <= 1600 && strUpOrDown == "+") {
                        Radio.ChangeStation(frec_actual, 0.0, "+")

                    }
                    else if ((Radio.Station - 10) >= 540 && strUpOrDown == "-") {
                        Radio.ChangeStation(frec_actual, 0.0, "-")

                    }
                    println("Desea subir o bajar más? (s/n)")
                    val keepChangingStation: String? = readLine()
                        //val KeepChangingStation: String? = readLine()
                    end = if (keepChangingStation == "s") {
                        0
                    } else {
                        1
                    }

                }


                }

            }





    } while ( seleccion !=6

            )


    }





//    println("Encendiendo radio")
  //  Radio.turnOn()
    //println(Radio)
//println(Radio.Volume)

