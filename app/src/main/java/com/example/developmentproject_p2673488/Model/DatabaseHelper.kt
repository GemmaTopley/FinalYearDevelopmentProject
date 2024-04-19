package com.example.developmentproject_p2673488.Model

import android.annotation.SuppressLint
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

    /* Non Rubbish Table */
    private val NRubbishTableName = "TNonRubbish"
    private val NRubbishName = "NRubName"
    private val NRubbishDescription = "NRubDescription"
    private val NRubbishVisible = "NRubVisible"


    override fun onCreate(db: SQLiteDatabase?) {
        var sqlCreateStatementRubbish: String = "CREATE TABLE IF NOT EXISTS $RubbishTableName ( $RubbishName TEXT, $RubbishDescription TEXT, " +
                " $RubbishVisible TEXT, " + " $RubbishPickUp TEXT )"

        db?.execSQL(sqlCreateStatementRubbish)

        var sqlCreateStatementNRubbish: String = "CREATE TABLE IF NOT EXISTS $NRubbishTableName ( $NRubbishName TEXT, $NRubbishDescription TEXT, " +
                " $NRubbishVisible TEXT )"

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

            val rubbish = Litter(rubbishName,rubbishDesc,rubbishVisible,rubbishPickup)
            cursor.close()
            db.close()
            return rubbish
        } else{
            cursor.close()
            db.close()
            return null
        }
    }


}