package com.example.store.ui.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.store.model.entity.Member
import com.example.store.model.repository.AboutDataRepository

class AboutViewModel(private val aboutDataRepository: List<Member>): ViewModel() {

    val members: MutableLiveData<List<Member>> = MutableLiveData<List<Member>>().apply {
        value = AboutDataRepository.getMember()
    }

//    override fun<T: ViewModel?> create(modelClass: Class<T>): T{
//        return AboutViewModel(aboutDataRepository) as T
//    }
}







