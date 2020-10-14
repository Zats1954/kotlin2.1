import java.util.*

fun main(){
    val number1 = Scanner(System.`in`)
    print("Введите количество секунд, прошедших с момента когда человек в сети: ")
    val lastTime = number1.nextInt()
    print("был(а) в сети ${agoToText(lastTime)}")
}

fun agoToText(lastTime: Int):String {
    return  when{
        lastTime < 61 -> "только что"
        lastTime < 3601 -> minutes(lastTime/60)
        lastTime < 86401 -> hours(lastTime/3600)
        lastTime < 172801 -> "сегодня"
        lastTime < 259201 -> "вчера"
        else -> "давно"
    }
}

fun hours(lastTime: Int): String {
    return when{
        lastTime in 11 .. 20    -> "$lastTime часов назад"
        lastTime%10 == 1        -> "$lastTime час назад"
        lastTime%10 in 2 .. 4     -> "$lastTime часа назад"
        else -> "$lastTime часов назад"
    }
}

fun minutes(lastTime: Int): String {
    return when{
        lastTime in 11 .. 20  -> "$lastTime минут назад"
        lastTime%10 == 1      -> "$lastTime минуту назад"
        lastTime%10 in 2 .. 4 -> "$lastTime минуты назад"
        else -> "$lastTime минут назад"
    }
}
