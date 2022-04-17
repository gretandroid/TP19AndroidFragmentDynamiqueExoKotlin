package education.cccp.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import education.cccp.mobile.fragment.R.id.*
import education.cccp.mobile.fragment.R.layout.fragment_edit
import education.cccp.mobile.fragment.controller.PersonDao.findOneById


class EditFragment : Fragment() {
    private var firstNameText: EditText? = null
    private var lastNameText: EditText? = null
    private var dobText: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            fragment_edit,
            container,
            false
        )
        firstNameText = view.findViewById(firstNameEditText)
        lastNameText = view.findViewById(lastNameEditText)
        dobText = view.findViewById(dobEditText)
        return view
    }

    fun received(id: Int) {
        val person = findOneById(id)
        firstNameText!!.setText(person!!.firstName)
        lastNameText!!.setText(person.lastName)
        dobText!!.setText(person.dob.toString())
    }

    override fun onStart() {
        super.onStart()
        val args = arguments
        val personId = args!!.getInt("personId")
        received(personId)
    }
}