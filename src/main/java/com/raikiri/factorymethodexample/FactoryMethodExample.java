/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.raikiri.factorymethodexample;

/**
 *
 * @author lutwi
 */

/*Se requiere de un producto o en este caso que es lo que hara el estudiante
y este comportamiento se replicara en las distintas instancias en
las cuales se aplique el comportamiento a la clase/objeto, este se conoce como 
Producto
*/
interface Estudiante{
    void inscribirse();
}

/*Las instancias especificas se conocen como producto concreto*/
class EstudianteUMG implements Estudiante{
    @Override
    public void inscribirse(){
        System.out.println("Se ha inscrito el estudiante en la UMG");
    }
}
class EstudianteUSAC implements Estudiante{
    @Override
    public void inscribirse(){
        System.out.println("Se ha inscrito el estudiante en la USAC");
    }
}
class EstudianteURL implements Estudiante{
    @Override
    public void inscribirse(){
        System.out.println("Se ha inscrito el estudiante en la URL");
    }
}

/*Ahora se require de un creador el cual se encarga de generar una clase 
abstracta la cual forzara a sobre escribir los metodos y funciones de la clase
se le conoce como creador*/
abstract class RegistroEstudiante{
    public abstract Estudiante crearEstudiante();
    
    public void procesarInscripcion(){
        Estudiante estudiante = crearEstudiante();
        estudiante.inscribirse();
    }
}

//Ahora se generaran creadores concretos o especificos para cada nueva instancia
class RegistroEstudiantesUMG extends RegistroEstudiante{

    @Override
    public Estudiante crearEstudiante(){
        return new EstudianteUMG();   
    }
}
class RegistroEstudiantesUSAC extends RegistroEstudiante{
    
    @Override
    public Estudiante crearEstudiante(){
        return new EstudianteUSAC();   
    }
}
class RegistroEstudiantesURL extends RegistroEstudiante{
    @Override
    public Estudiante crearEstudiante(){
        return new EstudianteURL();   
    }
}



public class FactoryMethodExample {

    public static void main(String[] args) {
        System.out.println("Hello World!");
            
            RegistroEstudiante registro = new RegistroEstudianteUMG();
            registro.procesarInscripcion();
            
            registro = new RegistroEstudianteUSAC();
            registro.procesarInscripcion();
            
            registro = new RegistroEstudianteURL();
            registro.procesarInscripcion();
    }
}
