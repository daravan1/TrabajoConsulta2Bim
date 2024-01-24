package org.example;

//Importacion de paquetes
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Main {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1, 20); //El observable emite numeros del 1 al 20
        observable
                .map(numero -> numero * numero)  // Operación elevar al cuadrado
                .filter(numeroCuadrado -> numeroCuadrado > 150)  // Filtrado de valores mayores a 15
                .map(numeroCuadrado -> "Número filtrado: " + numeroCuadrado)  // Transformación a cadena
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // Suscripción al Observador
                        System.out.println("Se inició la suscripción");
                    }
                    @Override
                    public void onNext(String value) {
                        // Impresion del valor recibido y transformado
                        System.out.println(value);
                    }
                    @Override
                    public void onError(Throwable e) {
                        // Caso Error
                        e.printStackTrace();
                    }
                    @Override
                    public void onComplete() {
                        // Metodo llamado al completar la emision
                        System.out.println("La emision fue completada");
                    }

        });
    }
}