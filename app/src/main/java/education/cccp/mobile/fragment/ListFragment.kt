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

class ListFragment : Fragment(), OnItemEvent {
    private lateinit var activity: Activity
    private lateinit var transfert: PersonTransfert
    private lateinit var mViewModel: PersonViewModel
    private lateinit var personAdapter: PersonAdapter

    override fun onRetrievePersonId(id: Int) =
        transfert.transfertId(id).also {
            Log.d(
                this.javaClass.simpleName,
                "onRetrievePersonId : $id"
            )
        }

    interface PersonTransfert {
        fun transfertId(personId: Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        fragment_list,
        container,
        false
    ).apply {
        mViewModel = ViewModelProvider(
            this@ListFragment
        ).get(PersonViewModel::class.java)
        mViewModel.getPersons().observe(requireActivity()) {
            personAdapter = PersonAdapter(
                persons = it,
                onItemEvent = this@ListFragment
            )
            findViewById<RecyclerView>(personListView).apply {
                adapter = personAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
        if (activity is PersonTransfert)
            transfert = (activity as PersonTransfert?)!!
    }
}