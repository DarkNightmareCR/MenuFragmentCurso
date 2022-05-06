package cr.ac.menufragmentcurso.entity

import java.io.Serializable

class Empleado(val id:String, val nombre:String,
               val puesto:String ,
               val departamento:String,val imagen:Int ): Serializable {
}