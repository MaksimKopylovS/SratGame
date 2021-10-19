package max_sk.star.game.vector;

import com.badlogic.gdx.math.Vector2;

public class Vector{

//Vector2 - Класс для работы с весторами
    Vector2 v1 = new Vector2(2,2);
    Vector2 v2 = new Vector2();
    Vector2 v3 = new Vector2();


    public Vector(){
        v2.set(2,1);
//        Сложение векторов
        v1.add(v2);
        System.out.println("v1.add(v2) v1.x = " + v1.x + " v1.y = " + v1.y);
//        Вычитание векторов используется для определени растояния между кеторами
        v1.set(3,7);
        v2.set(6,2);
        v1.sub(v2);
        System.out.println("v1.sub(v2) v1.x = " + v1.x + " v1.y = " + v1.y);
//      Поиск длины вектора
        System.out.println("v1.len() = " + v1.len());
//        Скаирование векторов
//        setLength Устанавливает длину вектора
        v1.setLength(100);
        System.out.println("v1.len() = " + v1.len());
        System.out.println("v1.setLength(100) v1.x = " + v1.x + " v1.y = " + v1.y);
//      scl  уменьшавет длину вектора умножеает на скаляр
        v1.scl(0.95f);
//        nor - нормализация вектора
        v1.nor();
        System.out.println("v1.len() = " + v1.len());
        System.out.println(" v1.x = " + v1.x + " v1.y = " + v1.y);
//     cpy() Создаёт копию вектора
        v1.set(3,7);
        v2.set(6,2);
        v3 = v1.cpy().add(v2);
        System.out.println(" v1.add(v2) v1.x ="  + v1.x + " v1.y = " + v1.y);
        System.out.println(" v1.cpy().add(v2); v3.x" + v3.x + " v3.y = " + v3.y);
//      Скалаярное произведение веторов позволяет опоределить угол между веторами
//      Позволяет узнать паралельность(1) перпендикулярность(0) и разнонаправленнось (-1)
        v1.set(1,1);
        v2.set(-1,1);
        v1.nor();
        v2.nor();
        System.out.println(Math.acos(v1.dot(v2)));

    }



}
