package cr.ac.menufragmentcurso.repository

import cr.ac.menufragmentcurso.entity.Empleado

class EmpleadoRepository {
    val empleados : HashMap<String, Empleado> = HashMap()

    companion object{
        @JvmStatic
        val instance by lazy{
            EmpleadoRepository().apply{}
        }
    }

    constructor(){
        save(Empleado("1","Eduardo Fonseca 1", "Programador","TI", 0))
        save(Empleado("2","Eduardo Fonseca 2", "Programador","TI", 0))
        save(Empleado("3","Eduardo Fonseca 3", "Programador","TI", 0))
        save(Empleado("4","Eduardo Fonseca 4", "Programador","TI", 0))
        save(Empleado("5","Eduardo Fonseca 5", "Programador","TI", 0))
        save(Empleado("6","Eduardo Fonseca 6", "Programador","TI", 0))
        save(Empleado("7","Eduardo Fonseca 7", "Programador","TI", 0))
        save(Empleado("8","Eduardo Fonseca 8", "Programador","TI", 0))
        save(Empleado("9","Eduardo Fonseca 9", "Programador","TI", 0))
        save(Empleado("10","Eduardo Fonseca 10", "Programador","TI", 0))
        save(Empleado("11","Eduardo Fonseca 11", "Programador","TI", 0))
        save(Empleado("12","Eduardo Fonseca 12", "Programador","TI", 0))
        save(Empleado("13","Eduardo Fonseca 13", "Programador","TI", 0))
        save(Empleado("14","Eduardo Fonseca 14", "Programador","TI", 0))
        save(Empleado("15","Eduardo Fonseca 15", "Programador","TI", 0))
    }
    fun save(empleado: Empleado){
        empleados.put(empleado.id, empleado)
    }
    fun edit(empleado: Empleado){
        empleados.put(empleado.id, empleado)
    }
    fun delete (id: String ){
        empleados.remove(id)
    }

    fun datos():List<Empleado>{
        return empleados.values.toList()
    }
}