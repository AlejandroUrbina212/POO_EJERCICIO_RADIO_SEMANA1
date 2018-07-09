package main.radio
class Radio (
        var isTurnedOn: Boolean = false,
        var frecuencia: String = "AM",
        var Volume: Int=0,
        var Station: Double = 87.0
) {
    fun turnOn() {
        isTurnedOn = true
    }

    fun turnOff() {
        isTurnedOn = false
    }
    fun RangeToAM() {
        frecuencia = "AM"
        Station = 87.0
    }

    fun RangeToFM() {
        frecuencia = "FM"
        Station = 540.0
    }
    fun ChangeVolume(UpOrDown: String) {
        if (UpOrDown == "+") {
            Volume += 1
        } else if (UpOrDown == "-"){
            Volume -= 1
        }
    }
    fun ChangeStation(frec_act:String, Step: Double, UpOrDown: String) {
        if (frec_act=="AM") {
            if (UpOrDown == "+") {
                Station += Step
            } else if (UpOrDown == "-") {
                Station -= Step
            }

        }
        else if (frec_act=="FM"){
            if (UpOrDown == "+") {
                Station += 10.0
            } else if (UpOrDown == "-") {
                Station -= 10.0
            }
        }
    }
    override fun toString(): String {
        return """
            Radio:
                Estado: $isTurnedOn
                Frecuencia: $frecuencia
                Volúmen: $Volume
                Estación: $Station
        """.trimIndent()
    }

    }
