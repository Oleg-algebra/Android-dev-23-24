package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

private val TAG = "XXXX"
class CustomAdapter(private val dataSet: List<ItemData>):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewCat)
        val catName: TextView = view.findViewById(R.id.catName)
        var cardView: CardView = view.findViewById(R.id.catCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cat_item, parent, false)
        Log.d(TAG, "onCreateViewHolder")
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(dataSet[position].resId)
        holder.catName.text = dataSet[position].name
//        holder.cardView.setOnClickListener {
//            Toast.makeText(holder.cardView.context,dataSet[position].name,Toast.LENGTH_SHORT).show()
//        }

//        holder.cardView.setOnClickListener(clickListener)
        holder.cardView.setOnClickListener {
            clickListener?.onClick(holder.cardView,dataSet[position])
        }
        Log.d(TAG, "onBindViewHolder")
    }
//    var clickListener: View.OnClickListener? = null

    fun interface CatItemClickListener {
        fun onClick(view: View?, itemData: ItemData)
    }

    var clickListener : CatItemClickListener? = null
}

