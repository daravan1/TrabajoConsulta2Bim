package org.example;

//Importacion de paquetes
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Main {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1, 5);
        // Suscripción al Observable
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                // Metodo utilizado despues de iniciar la suscripción
                System.out.println("Se inicio la suscripcion");
            }
            @Override
            public void onNext(Integer value) {
                // Impresion del valor recibido
                System.out.println("Se recibe: " + value);
            }

            @Override
            public void onError(Throwable e) {
                // Caso Error
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                // Metodo llamado al completar la emision
                System.out.println("Emision completada!");
            }
        });
    }
}