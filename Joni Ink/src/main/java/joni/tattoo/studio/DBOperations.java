package joni.tattoo.studio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
//import android.provider.Telephony;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by SUNAY on 11/30/13.
 */
public class DBOperations {
    private DataBase dbHelper;
    private String[] PWD_TABLE_COLUMNS = {DataBase.ADMINNAME, DataBase.ADMINPWD};
    private String[] TATTOO_TABLE_COLUMNS = {DataBase.TATTOO_ID, DataBase.TATTOO_PHOTO, DataBase.TATTOO_PRICE_S, DataBase.TATTOO_PRICE_M, DataBase.TATTOO_PRICE_L, DataBase.TATTOO_COLOUR, DataBase.TATTOO_DIFFICULTY};
    private String[] PIERCING_TABLE_COLUMNS = {DataBase.PIERCING_ID, DataBase.PIERCING_PHOTO, DataBase.PIERCING_PRICE, DataBase.PIERCING_MATERIAL, DataBase.PIERCING_AREA};
    private String[] PIERCINGMAT_TABLE_COLUMNS = {DataBase.PIERCINGMAT_ID, DataBase.PIERCINGMAT_NAME};
    private String[] PIERCINGAREA_TABLE_COLUMNS = {DataBase.PIERCINGAREA_ID, DataBase.PIERCINGAREA_NAME};

    private SQLiteDatabase database;

    public DBOperations(Context context)
    {
        dbHelper=new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public boolean validate (String AName, String APwd){
        ContentValues values = new ContentValues();
        values.put(DataBase.ADMINNAME,AName);
        values.put(DataBase.ADMINPWD,APwd);
        Cursor cursor = database.query(DataBase.PWD, PWD_TABLE_COLUMNS,DataBase.ADMINPWD,new String[]{APwd},null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Log.e("","");
            cursor.moveToNext();

        }
        return false;
    }


    //------TABLE TATTOOS ----------------------------------------------------------------------------
    public int updateTattoos(TattooItem tattooItem)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBase.TATTOO_ID,tattooItem.getTattooID());
        values.put(DataBase.TATTOO_PHOTO,tattooItem.getTPhoto());
        values.put(DataBase.TATTOO_PRICE_S,tattooItem.getTPriceS());
        values.put(DataBase.TATTOO_PRICE_M,tattooItem.getTPriceM());
        values.put(DataBase.TATTOO_PRICE_L,tattooItem.getTPriceL());
        values.put(DataBase.TATTOO_COLOUR,tattooItem.getTColour());
        values.put(DataBase.TATTOO_DIFFICULTY,tattooItem.getTDifficulty());

        //updating row
        return db.update(DataBase.TATTOOS, values,DataBase.TATTOO_ID + " = ?", new String[] { String.valueOf(tattooItem.getTattooID()) } );
    }

    public TattooItem newTattoo(TattooItem tattooItem)
    {
        ContentValues values = new ContentValues();
        values.put(DataBase.TATTOO_PHOTO,tattooItem.getTPhoto());
        values.put(DataBase.TATTOO_PRICE_S,tattooItem.getTPriceS());
        values.put(DataBase.TATTOO_PRICE_M,tattooItem.getTPriceM());
        values.put(DataBase.TATTOO_PRICE_L,tattooItem.getTPriceL());
        values.put(DataBase.TATTOO_COLOUR,tattooItem.getTColour());
        values.put(DataBase.TATTOO_DIFFICULTY,tattooItem.getTDifficulty());

        database.insert(DataBase.TATTOOS,null,values);
        return tattooItem;
    }

    public void deleteTattoo(int tattooID)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DataBase.TATTOOS,DataBase.TATTOO_ID + " = ?", new String[] {String.valueOf(tattooID)});
    }

    public ArrayList<TattooItem> getAllTattoos(){
        ArrayList<TattooItem>Tattoos = new ArrayList<TattooItem>();
        Cursor cursor = database.query(DataBase.TATTOOS, TATTOO_TABLE_COLUMNS,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            TattooItem tattooItem = new TattooItem();
            tattooItem.setTattooID(cursor.getInt(0));
            tattooItem.setTPhoto(cursor.getString(1));
            tattooItem.setTPriceS(cursor.getDouble(2));
            tattooItem.setTPriceM(cursor.getDouble(3));
            tattooItem.setTPriceL(cursor.getDouble(4));
            tattooItem.setTColour(cursor.getInt(5));
            tattooItem.setTDifficulty(cursor.getInt(6));

            Tattoos.add(0, tattooItem);
            cursor.moveToNext();
        }
        cursor.close();
        return Tattoos;
    }
    //---------------------------------------------------------------------------------------------

    //------TABLE PIERCING ------------------------------------------------------------------------
    public int updatePiercing(PiercingItem piercingItem)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBase.PIERCING_ID,piercingItem.getPiercingID());
        values.put(DataBase.PIERCING_PHOTO,piercingItem.getPPhoto());
        values.put(DataBase.PIERCING_PRICE,piercingItem.getPPrice());
        values.put(DataBase.PIERCING_MATERIAL,piercingItem.getPMaterial());
        values.put(DataBase.PIERCING_AREA,piercingItem.getPArea());

        //updating row
        return db.update(DataBase.TATTOOS, values,DataBase.TATTOO_ID + " = ?", new String[] { String.valueOf(piercingItem.getPiercingID()) } );
    }

    public PiercingItem newPiercing(PiercingItem piercingItem)
    {
        ContentValues values = new ContentValues();
        values.put(DataBase.PIERCING_PHOTO,piercingItem.getPPhoto());
        values.put(DataBase.PIERCING_PRICE,piercingItem.getPPrice());
        values.put(DataBase.PIERCING_MATERIAL,piercingItem.getPMaterial());
        values.put(DataBase.PIERCING_AREA,piercingItem.getPArea());

        database.insert(DataBase.PIERCING,null,values);
        return piercingItem;
    }

    public void deletePiercing(int piercingID)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DataBase.PIERCING, DataBase.PIERCING_ID + " = ?", new String[]{String.valueOf(piercingID)});
    }

    public ArrayList<PiercingItem> getAllPiercing(){
        ArrayList<PiercingItem>Piercing = new ArrayList<PiercingItem>();
        Cursor cursor = database.query(DataBase.PIERCING, PIERCING_TABLE_COLUMNS,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            PiercingItem piercingItem = new PiercingItem();
            piercingItem.setPiercingID(cursor.getInt(0));
            piercingItem.setPPhoto(cursor.getString(1));
            piercingItem.setPPrice(cursor.getDouble(2));
            piercingItem.setPMaterial(cursor.getInt(3));
            piercingItem.setPArea(cursor.getInt(4));

            Piercing.add(0, piercingItem);
            cursor.moveToNext();
        }
        cursor.close();
        return Piercing;
    }
    //---------------------------------------------------------------------------------------------


}

