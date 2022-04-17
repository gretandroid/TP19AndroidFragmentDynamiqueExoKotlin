package education.cccp.mobile.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import education.cccp.mobile.fragment.controller.PersonDao.all
import education.cccp.mobile.fragment.model.PersonEntity

class PersonViewModel : ViewModel() {
    private var mPersons: MutableLiveData<MutableList<PersonEntity>>? = null

    fun getMPersons(): MutableLiveData<MutableList<PersonEntity>> {
        if (mPersons == null) {
            mPersons = MutableLiveData()
            mPersons!!.value = all
        }
        return mPersons as MutableLiveData<MutableList<PersonEntity>>
    }

    fun addPerson(person: PersonEntity) {
        mPersons!!.value!!.add(person)
        mPersons!!.value = mPersons!!.value
    }
}