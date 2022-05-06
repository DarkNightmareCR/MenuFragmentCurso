package cr.ac.menufragmentcurso

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


/**
 * A simple [Fragment] subclass.
 * Use the [AddEmpleadoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddEmpleadoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val vista= inflater.inflate(R.layout.fragment_add_empleado, container, false)

        vista.findViewById<Button>(R.id.add_guardar).setOnClickListener{ Agregar() }

        return vista
    }
    fun Agregar(){

        //  Variables
        val add_id = view?.findViewById<TextView>(R.id.add_SId)
        val add_nombre = view?.findViewById<TextView>(R.id.add_SNombre)
        val add_puesto = view?.findViewById<TextView>(R.id.add_SPuesto)
        val add_departamento = view?.findViewById<TextView>(R.id.add_SDepartamento)

        //  Se crea la instancia del Empleado con cada uno de los parametros
        var empleado = Empleado(add_id?.text.toString(), add_nombre?.text.toString(), add_puesto?.text.toString(), add_departamento?.text.toString(), 0)

        //  Guarda al empleado
        EmpleadoRepository.instance.save(empleado)
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
         * @return A new instance of fragment AddEmpleadoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            AddEmpleadoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}