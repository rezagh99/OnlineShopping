package com.example.store.model.repository

import com.example.store.model.entity.Member
import com.example.store.model.source.LocalDataBase

object AboutDataRepository {

    fun getMember(): List<Member> {
        return LocalDataBase.selectMembers()

    }


}