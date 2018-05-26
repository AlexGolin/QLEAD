package io.qapp.android.qlead

/**
 * Created by Bruce on 2018-05-23.
 */


import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList
import android.widget.AdapterView



class SpinnerAdapter(context: Context, textViewResourceId: Int, internal var objects: ArrayList<ListItem>) : ArrayAdapter<ListItem>(context, textViewResourceId, objects) {

    internal var inflater: LayoutInflater
    internal var holder: ViewHolder? = null

    init {
        inflater = (context as Activity).layoutInflater
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }



    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {

        val listItem = objects[position]
        var row = convertView

        if (null == row) {
            holder = ViewHolder()
            row = inflater.inflate(R.layout.row, parent, false)
            holder!!.name = row!!.findViewById<View>(R.id.name) as TextView
            holder!!.imgThumb = row.findViewById<View>(R.id.imgThumb) as ImageView
            row.tag = holder
        } else {
            holder = row.tag as ViewHolder
        }

        holder!!.name!!.text = listItem.name
        holder!!.imgThumb!!.setBackgroundResource(listItem.logo)

        return row
    }

    internal class ViewHolder {
        var name: TextView? = null
        var imgThumb: ImageView? = null
    }
}