package com.example.developmentproject_p2673488.Model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DataBaseName = "RubbishRemovalDatabase.db"
private val ver : Int = 1

class DatabaseHelper (context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {

    /* Rubbish Table */
    private val RubbishTableName = "TRubbish"
    private val RubbishName = "RubName"
    private val RubbishDescription = "RubDescription"
    private val RubbishVisible = "RubVisible"
    private val RubbishPickUp = "RubPickup"
    private val RubbishParent = "ParentChoice"
    private val RubbishDisposal = "RubDisposal"
    private val RubbishDisposalInfo = "RubDisposalInfo"
    private val RubbishClicked = "RubClicked"
    private val RubbishLevel = "Level"



    /* Non Rubbish Table */
    private val NRubbishTableName = "TNonRubbish"
    private val NRubbishName = "NRubName"
    private val NRubbishDescription = "NRubDescription"
    private val NRubbishVisible = "NRubVisible"
    private val NRubbishParent = "ParentChoice"
    private val NRubbishClicked = "NRubClicked"
    private val NRubbishLevel = "Level"



    override fun onCreate(db: SQLiteDatabase?) {
        var sqlCreateStatementRubbish: String = "CREATE TABLE IF NOT EXISTS $RubbishTableName ( $RubbishName TEXT, $RubbishDescription TEXT, " +
                " $RubbishVisible TEXT, " + " $RubbishPickUp TEXT, "+" $RubbishParent INT, "+" $RubbishDisposal TEXT, "+" $RubbishDisposalInfo TEXT, " +
                " $RubbishClicked INT, "+" $RubbishClicked INT, "+" $RubbishLevel TEXT)"

        db?.execSQL(sqlCreateStatementRubbish)

        var sqlCreateStatementNRubbish: String = "CREATE TABLE IF NOT EXISTS $NRubbishTableName ( $NRubbishName TEXT, $NRubbishDescription TEXT, " +
                " $NRubbishVisible TEXT, "+" $NRubbishParent INT, "+" $NRubbishLevel TEXT  )"

        db?.execSQL(sqlCreateStatementNRubbish)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            onCreate(db)
        }
    }


    @SuppressLint("Range")
    fun getRubbish(name : String) : Litter? {
        val db = readableDatabase

        var sqlStatement ="SELECT * FROM $RubbishTableName WHERE $RubbishName = ?"

        val param = arrayOf(name)
        val cursor: Cursor = db.rawQuery(sqlStatement, param)

        if(cursor.moveToFirst()){
            val rubbishName = cursor.getString(cursor.getColumnIndex(RubbishName))
            val rubbishDesc = cursor.getString(cursor.getColumnIndex(RubbishDescription))
            val rubbishVisible = cursor.getInt(cursor.getColumnIndex(RubbishVisible))
            val rubbishPickup = cursor.getString(cursor.getColumnIndex(RubbishPickUp))
            val rubbishParent = cursor.getInt(cursor.getColumnIndex(RubbishParent))
            val rubbishDisposal = cursor.getString(cursor.getColumnIndex(RubbishDisposal))
            val rubbishDisposalInfo = cursor.getString(cursor.getColumnIndex(RubbishDisposalInfo))
            val rubbishClicked = cursor.getInt(cursor.getColumnIndex(RubbishClicked))
            val rubbishLevel = cursor.getString(cursor.getColumnIndex(RubbishLevel))




            val rubbish = Litter(rubbishName,rubbishDesc,rubbishVisible,rubbishPickup, rubbishParent, rubbishDisposal, rubbishDisposalInfo, rubbishClicked, rubbishLevel)
            cursor.close()
            db.close()
            return rubbish
        } else{
            cursor.close()
            db.close()
            return null
        }
    }


    @SuppressLint("Range")
    fun getNonRubbish(name : String) : NonLitter? {
        val db = readableDatabase

        var sqlStatement ="SELECT * FROM $NRubbishTableName WHERE $NRubbishName = ?"

        val param = arrayOf(name)
        val cursor: Cursor = db.rawQuery(sqlStatement, param)

        if(cursor.moveToFirst()){
            val NRubbishName = cursor.getString(cursor.getColumnIndex(NRubbishName))
            val NRubbishDesc = cursor.getString(cursor.getColumnIndex(NRubbishDescription))
            val NRubbishVisible = cursor.getInt(cursor.getColumnIndex(NRubbishVisible))
            val NRubbishParent = cursor.getInt(cursor.getColumnIndex(NRubbishParent))
            val NRubbishClicked = cursor.getInt(cursor.getColumnIndex(NRubbishClicked))
            val NRubbishLevel = cursor.getString(cursor.getColumnIndex(NRubbishLevel))


            val NRubbish = NonLitter(NRubbishName,NRubbishDesc,NRubbishVisible, NRubbishParent, NRubbishClicked, NRubbishLevel)
            cursor.close()
            db.close()
            return NRubbish
        } else{
            cursor.close()
            db.close()
            return null
        }
    }

    fun updateRubbishVis(name: String, value: Int){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(RubbishVisible, value)
        db.update(RubbishTableName, contentValues, "RubName = ?", arrayOf(name))
        db.close()
    }

    fun updateNonRubbishVis(name: String, value: Int){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NRubbishVisible, value)
        db.update(NRubbishTableName, contentValues, "NRubName = ?", arrayOf(name))
        db.close()
    }

    fun updateRubbishVisParent(name: String, value: Int){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(RubbishParent, value)
        db.update(RubbishTableName, contentValues, "RubName = ?", arrayOf(name))
        db.close()
    }

    fun updateNonRubbishVisParent(name: String, value: Int){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NRubbishParent, value)
        db.update(NRubbishTableName, contentValues, "NRubName = ?", arrayOf(name))
        db.close()
    }

    fun updateRubbishClicked(name: String, value: Int){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(RubbishClicked, value)
        db.update(RubbishTableName, contentValues, "RubName = ?", arrayOf(name))
        db.close()
    }

    fun updateNonRubbishClicked(name: String, value: Int){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NRubbishClicked, value)
        db.update(NRubbishTableName, contentValues, "NRubName = ?", arrayOf(name))
        db.close()
    }

    @SuppressLint("Range")
    fun allClicked(table: String, column: String, levelIn: String): Boolean{
        val db = this.readableDatabase
        val level = "Level = ?"

        val cursor: Cursor? = db.query(table, arrayOf(column), level,arrayOf(levelIn),null,null,null)
        cursor?.use{
            while (cursor.moveToNext()){
                val element = cursor.getInt(cursor.getColumnIndex(column))
                if (element != 1){
                    cursor.close()
                    db.close()
                    return false
                }
            }
        }
        cursor?.close()
        db.close()
        return true
    }

}