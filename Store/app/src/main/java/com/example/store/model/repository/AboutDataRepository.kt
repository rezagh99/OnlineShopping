package com.example.store.model.repository

import com.example.store.model.entity.Member
import com.example.store.model.source.LocalDataBase

object AboutDataRepository {

    fun getMember(): List<Member> {
        return LocalDataBase.selectMembers()

    }

    fun getMember1():Member?{
        val member_1=LocalDataBase.selectMembers()
        val member: Member? = member_1.find { it.name == "Reza Ghahremani" }
        return member
    }

    fun getMember2():Member?{
        val member_2=LocalDataBase.selectMembers()
        val member: Member? = member_2.find { it.name == "Mercedeh Irani" }
        return member
    }



}