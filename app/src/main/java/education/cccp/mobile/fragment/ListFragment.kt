package education.cccp.mobile.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.fragment.PersonAdapter.OnItemEvent
import education.cccp.mobile.fragment.R.id.personListView
import education.cccp.mobile.fragment.R.layout.fragment_list
import education.cccp.mobile.fragment.model.PersonEntity

class ListFragment : Fragment(), OnItemEvent {
    private var activity: Activity? = null
    private var transfert: PersonTransfert? = null
    private var mViewModel: PersonViewModel? = null
    private var adapter: PersonAdapter? = null

    override fun onRetrievePersonId(id: Int) {
        Log.d(
            this.javaClass.simpleName,
            "onRetrievePersonId : $id"
        )
        transfert!!.transfertId(id)
    }

    interface PersonTransfert {
        fun transfertId(personId: Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        val view: View = inflater.inflate(
            fragment_list,
            container,
            false
        )
        mViewModel!!.getMPersons().observe(
            requireActivity()
        ) { personList: List<PersonEntity>? ->
            adapter = PersonAdapter(
                persons = personList as List<PersonEntity>,
                onItemEvent = this
            )
            val recyclerView: RecyclerView = view.findViewById(personListView)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
        if (activity is PersonTransfert) transfert = activity as PersonTransfert?
    }
}