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
    private lateinit var firstNameText: EditText
    private lateinit var lastNameText: EditText
    private lateinit var dobText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        fragment_edit,
        container,
        false
    ).apply {
        firstNameText = findViewById(firstNameEditText)
        lastNameText = findViewById(lastNameEditText)
        dobText = findViewById(dobEditText)
    }

    fun received(id: Int) = findOneById(id)?.apply {
        firstNameText.setText(firstName)
        lastNameText.setText(lastName)
        dobText.setText(dob.toString())
    }

    override fun onStart() = super.onStart().also {
        received(requireArguments().getInt("personId"))
    }
}