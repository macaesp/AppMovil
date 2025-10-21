package com.example.levelupgamerapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.ItemCarrito

class CarritoAdapter(
    private var lista: List<ItemCarrito>,
    private val onAumentar: (ItemCarrito) -> Unit,
    private val onDisminuir: (ItemCarrito) -> Unit
) : RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder>() {

    class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.txtNombreCarrito)
        val cantidad: TextView = itemView.findViewById(R.id.txtCantidad)
        val precio: TextView = itemView.findViewById(R.id.txtPrecioCarrito)
        val imagen: ImageView = itemView.findViewById(R.id.imgCarrito)
        val btnMas: Button = itemView.findViewById(R.id.btnMas)
        val btnMenos: Button = itemView.findViewById(R.id.btnMenos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto_carrito, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val item = lista[position]
        holder.nombre.text = item.producto.nombre
        holder.cantidad.text = "x${item.cantidad}"
        holder.precio.text = "$${item.producto.precio * item.cantidad}"

        val resId = holder.itemView.context.resources.getIdentifier(
            item.producto.imagenResId.toString(), "drawable",
            holder.itemView.context.packageName
        )
        if (resId != 0) holder.imagen.setImageResource(resId)

        holder.btnMas.setOnClickListener { onAumentar(item) }
        holder.btnMenos.setOnClickListener { onDisminuir(item) }
    }

    override fun getItemCount(): Int = lista.size

    fun actualizarLista(nuevaLista: List<ItemCarrito>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }
}
