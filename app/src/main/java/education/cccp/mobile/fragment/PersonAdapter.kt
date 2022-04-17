package education.cccp.mobile.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.fragment.R.layout.person_row
import education.cccp.mobile.fragment.model.PersonEntity


class PersonAdapter(
    private val persons: List<PersonEntity>,
    private val onItemEvent: OnItemEvent
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(
            person_row,
            parent,
            false
        )
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PersonViewHolder,
        position: Int
    ) {
        holder.firstNameRow.text = persons[position].firstName
        holder.lastNameRow.text = persons[position].lastName
        holder.dobRow.text = persons[position].dob.toString()
        holder.itemView.setOnClickListener { view: View? ->
            onItemEvent.onRetrievePersonId(
                persons[position].id
            )
        }
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstNameRow: TextView
        val lastNameRow: TextView
        val dobRow: TextView

        init {
            firstNameRow = itemView.findViewById(R.id.firstNameTextViewRow)
            lastNameRow = itemView.findViewById(R.id.lastNameTextViewRow)
            dobRow = itemView.findViewById(R.id.dobTextViewRow)
        }
    }

    interface OnItemEvent {
        fun onRetrievePersonId(id: Int)
    }
}