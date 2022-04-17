package education.cccp.mobile.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import education.cccp.mobile.fragment.ListFragment.PersonTransfert
import education.cccp.mobile.fragment.R.id.frame
import education.cccp.mobile.fragment.R.layout.activity_main

class MainActivity : AppCompatActivity(), PersonTransfert {
    private lateinit var listFragment: ListFragment
    private lateinit var editFragment: EditFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        listFragment = ListFragment()
        editFragment = EditFragment()
        supportFragmentManager
            .beginTransaction()
            .add(frame, listFragment)
            .commit()
    }

    override fun transfertId(personId: Int) {
        val bundle = Bundle()
        bundle.putInt("personId", personId)
        editFragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(frame, editFragment)
            .addToBackStack(null)
            .commit()
    }
}