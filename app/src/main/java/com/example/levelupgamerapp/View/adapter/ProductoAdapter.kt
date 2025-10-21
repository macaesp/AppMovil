package com.example.levelupgamerapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto



sealed class ProductoAdapter(
    private var lista: List<Producto> = listOf(),      // le damos valor por defecto
    private val onAgregarClick: (Producto) -> Unit
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imgProducto)
        val nombre: TextView = itemView.findViewById(R.id.txtNombre)
        val descripcion: TextView = itemView.findViewById(R.id.txtDescripcion)
        val precio: TextView = itemView.findViewById(R.id.txtPrecio)
        val btnAgregar: Button = itemView.findViewById(R.id.btnAgregar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = lista[position]
        holder.nombre.text = producto.nombre
        holder.descripcion.text = producto.descripcion
        holder.precio.text = "$${producto.precio}"

        // Cargar imagen (usa ícono por defecto si no hay imagen)

        val resId = holder.itemView.context.resources.getIdentifier(
            "ic_gamepad", // nombre del recurso
            "drawable",                         // tipo de recurso
            holder.itemView.context.packageName // paquete actual
        )
        holder.imagen.setImageResource(
            if (resId != 0) resId else R.drawable.ic_gamepad //
        )

        fun getItemCount(): Int = lista.size

        fun actualizarLista(nuevaLista: List<Producto>) {
            lista = nuevaLista
            notifyDataSetChanged()
        }
    }
}
