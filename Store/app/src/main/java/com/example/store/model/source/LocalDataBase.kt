package com.example.store.model.source
import com.example.store.model.entity.Product
import com.example.store.R
import com.example.store.model.entity.Member

object LocalDataBase {

    fun selectProducts(): List<Product> {
        //val appDatabase = BaseApplication.appDatabase
       // return appDatabase.animalDao().getAnimals().map { AnimalEntityMapper.map(it) }
        val table=Product("table","12",R.drawable.table,"10","1")
        val shirt= Product("shirt","7",R.drawable.shirt,"30","4")
        val lamp=Product("lamp","5",R.drawable.lamp,"1","6")

        val laptop=Product("laptop","1000",R.drawable.laptop,"1","6")
        val notebook=Product("notebook","5",R.drawable.notebook,"1","6")
        val pen=Product("pen","2",R.drawable.pen,"1","6")
        val vacumcleaner=Product("vacumcleaner","30",R.drawable.vacumcleaner,"1","6")
        val bed=Product("bed","100",R.drawable.bed,"1","6")

        return listOf(table,shirt,lamp,laptop,notebook,pen,vacumcleaner,bed)
    }

    fun selectMembers(): List<Member> {
        val meReza=Member("Reza Ghahremani","96521425",R.drawable.rezagh)
        val meMercedeh= Member("Mercedeh Irani","96525252",R.drawable.irani)

        return listOf(meReza,meMercedeh)
    }
}