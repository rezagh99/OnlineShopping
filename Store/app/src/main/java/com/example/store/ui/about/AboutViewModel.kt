package com.example.store.ui.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.store.model.entity.Member
import com.example.store.model.repository.AboutDataRepository

class AboutViewModel: ViewModel() {

    val member1: MutableLiveData<Member> = MutableLiveData<Member>().apply {
        value = AboutDataRepository.getMember1()
    }

    val member2: MutableLiveData<Member> = MutableLiveData<Member>().apply {
        value = AboutDataRepository.getMember2()
    }

//    override fun<T: ViewModel?> create(modelClass: Class<T>): T{
//        return AboutViewModel(aboutDataRepository) as T
//    }
}







