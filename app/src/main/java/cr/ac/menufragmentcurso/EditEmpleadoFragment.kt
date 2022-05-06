package cr.ac.menufragmentcurso

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cr.ac.menufragmentcurso.entity.Empleado
import cr.ac.menufragmentcurso.repository.EmpleadoRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditEmpleadoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditEmpleadoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var empleado: Empleado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            empleado=it.get(ARG_PARAM1) as Empleado?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View =inflater.inflate(R.layout.fragment_edit_empleado, container, false)

        val nombre=view.findViewById<TextView>(R.id.edit_SNombre)
        nombre.setText(empleado?.nombre)

        val identificacion=view.findViewById<TextView>(R.id.edit_SId)
        identificacion.setText(empleado?.id)

        val puesto=view.findViewById<TextView>(R.id.edit_SPuesto)
        puesto.setText(empleado?.puesto)

        val departamento=view.findViewById<TextView>(R.id.edit_SDepartamento)
        departamento.setText(empleado?.departamento)

        view.findViewById<Button>(R.id.edit_eliminar).setOnClickListener{ Eliminar(identificacion.text.toString()) }
        view.findViewById<Button>(R.id.edit_editar).setOnClickListener{ Editar(identificacion.text.toString()) }

        return view
    }

    fun Eliminar(identificacion:String){

        val builder = AlertDialog.Builder(context)
        builder.setMessage("¿Desea modificar el registro?")
            .setCancelable(false)
            .setPositiveButton("Sí") { dialog, id ->

                EmpleadoRepository.instance.delete(identificacion)

            }
            .setNegativeButton(
                "No"
            ) { dialog, id ->
                // logica del no
            }
        val alert = builder.create()
        alert.show()

        /*var fragmento : Fragment = CamaraFragment.newInstance("Camara" )
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.home_content, fragmento)
            ?.commit()
        activity?.setTitle("Camara")*/
    }
    fun Editar(identificacion:String){

        val depa:String= view?.findViewById<TextView>(R.id.edit_SDepartamento)?.text.toString()
        val puesto:String= view?.findViewById<TextView>(R.id.edit_SPuesto)?.text.toString()
        val nombre:String= view?.findViewById<TextView>(R.id.edit_SNombre)?.text.toString()
        val empleado : Empleado  =  Empleado(identificacion,nombre, depa,puesto,0)
        EmpleadoRepository.instance.save(empleado)
        println(view?.findViewById<TextView>(R.id.empleado_puesto)?.text.toString())
        Salir()
    }
    fun Salir(){
        val fragmento: Fragment = CamaraFragment.newInstance("Camara")
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.home_content, fragmento)
            ?.commit()
        activity?.setTitle("Camara")
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditEmpleadoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(empleado: Empleado) =
            EditEmpleadoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, empleado)
                }
            }
    }
}