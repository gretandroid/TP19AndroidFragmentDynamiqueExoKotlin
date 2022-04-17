package education.cccp.mobile.fragment

import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import education.cccp.mobile.fragment.R.id.*
import education.cccp.mobile.fragment.R.layout.person_row
import education.cccp.mobile.fragment.model.PersonEntity


class PersonAdapter(
    private val persons: List<PersonEntity>,
    private val onItemEvent: OnItemEvent
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonViewHolder = PersonViewHolder(
        from(parent.context).inflate(
            person_row,
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: PersonViewHolder,
        position: Int
    ) {
        holder.apply {
            firstNameRow.text = persons[position].firstName
            lastNameRow.text = persons[position].lastName
            dobRow.text = persons[position].dob.toString()
            itemView.setOnClickListener {
                onItemEvent.onRetrievePersonId(persons[position].id)
            }
        }
    }

    override fun getItemCount(): Int = persons.size

    inner class PersonViewHolder(itemView: View) : ViewHolder(itemView) {
        val firstNameRow: TextView by lazy { itemView.findViewById(firstNameTextViewRow) }
        val lastNameRow: TextView by lazy { itemView.findViewById(lastNameTextViewRow) }
        val dobRow: TextView by lazy { itemView.findViewById(dobTextViewRow) }
    }

    interface OnItemEvent {
        fun onRetrievePersonId(id: Int)
    }
}