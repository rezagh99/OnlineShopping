package com.example.store.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.store.model.entity.Member
import com.example.store.model.repository.AboutDataRepository

class AboutViewModel : ViewModel() {

    val members: MutableLiveData<List<Member>> = MutableLiveData<List<Member>>().apply {
        value = AboutDataRepository.getMember()
    }
}