package education.cccp.mobile.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import education.cccp.mobile.fragment.controller.PersonDao.all
import education.cccp.mobile.fragment.model.PersonEntity

class PersonViewModel : ViewModel() {
    private val persons: MutableLiveData<List<PersonEntity>> by lazy {
        MutableLiveData<List<PersonEntity>>().also { all }
    }

    fun getPersons(): LiveData<List<PersonEntity>> = persons

//    fun addPerson(person: PersonEntity) {
//        persons?.value?.add(person)
//        persons!!.value = persons!!.value
//    }
}